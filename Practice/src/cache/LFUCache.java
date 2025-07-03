package cache;

import java.util.*;

class LFUCache {

    class Node {
        int key, value, freq;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    class DoublyLinkedList {
        Node head, tail;
        int size;

        DoublyLinkedList() {
            head = new Node(0, 0); // dummy head
            tail = new Node(0, 0); // dummy tail
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        // Add node to head (most recently used in this freq)
        void addNode(Node node) {
            node.next = head.next;
            head.next.prev = node;

            head.next = node;
            node.prev = head;

            size++;
        }

        // Remove node from list
        void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        // Remove least recently used node (from tail)
        Node removeLRUNode() {
            if (size > 0) {
                Node lru = tail.prev;
                removeNode(lru);
                return lru;
            }
            return null;
        }
    }

    private final int capacity;
    private int minFreq;
    private final Map<Integer, Node> keyNodeMap;
    private final Map<Integer, DoublyLinkedList> freqListMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.keyNodeMap = new HashMap<>();
        this.freqListMap = new HashMap<>();
    }

    public int get(int key) {
        if (!keyNodeMap.containsKey(key)) {
            return -1;
        }
        Node node = keyNodeMap.get(key);
        updateNode(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        if (keyNodeMap.containsKey(key)) {
            Node node = keyNodeMap.get(key);
            node.value = value;
            updateNode(node);
        } else {
            if (keyNodeMap.size() == capacity) {
                // Remove LFU node
                DoublyLinkedList minFreqList = freqListMap.get(minFreq);
                Node lru = minFreqList.removeLRUNode();
                keyNodeMap.remove(lru.key);
            }

            // Insert new node
            Node newNode = new Node(key, value);
            keyNodeMap.put(key, newNode);

            freqListMap.computeIfAbsent(1, k -> new DoublyLinkedList()).addNode(newNode);
            minFreq = 1; // Reset minFreq
        }
    }

    private void updateNode(Node node) {
        int freq = node.freq;
        DoublyLinkedList oldList = freqListMap.get(freq);
        oldList.removeNode(node);

        // If current list is empty and was minFreq, increment minFreq
        if (freq == minFreq && oldList.size == 0) {
            minFreq++;
        }

        node.freq++;
        freqListMap.computeIfAbsent(node.freq, k -> new DoublyLinkedList()).addNode(node);
    }

    // For debugging
    public void printState() {
        System.out.println("Cache State:");
        for (int f : freqListMap.keySet()) {
            System.out.print("Freq " + f + ": ");
            Node curr = freqListMap.get(f).head.next;
            while (curr != freqListMap.get(f).tail) {
                System.out.print("(" + curr.key + ":" + curr.value + ") ");
                curr = curr.next;
            }
            System.out.println();
        }
        System.out.println("MinFreq: " + minFreq);
    }

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        cache.printState();

        System.out.println(cache.get(1)); // returns 1
        cache.printState();

        cache.put(3, 3); // evicts key 2
        cache.printState();

        System.out.println(cache.get(2)); // returns -1
        System.out.println(cache.get(3)); // returns 3
        cache.printState();
    }
}

