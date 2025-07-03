package cache;

import java.util.HashMap;

class LRUCache {

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private HashMap<Integer, Node> map;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        // Dummy head and tail nodes for easy handling
        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);         // Remove from current position
            insertToHead(node);   // Insert at front (most recently used)
            return node.value;
        }
        return -1;  // Not found
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // Update existing node value and move to head
            Node node = map.get(key);
            node.value = value;
            remove(node);
            insertToHead(node);
        } else {
            if (map.size() == capacity) {
                // Remove least recently used node (tail.prev)
                Node lru = tail.prev;
                remove(lru);
                map.remove(lru.key);
            }
            Node newNode = new Node(key, value);
            insertToHead(newNode);
            map.put(key, newNode);
        }
    }

    // Helper to remove a node from the linked list
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Helper to insert a node right after head (MRU position)
    private void insertToHead(Node node) {
        node.next = head.next;
        head.next.prev = node;

        head.next = node;
        node.prev = head;
    }

    // For debugging: print the cache state
    public void printCache() {
        Node curr = head.next;
        while (curr != tail) {
            System.out.print("(" + curr.key + ":" + curr.value + ") ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2); // capacity = 2

        cache.put(1, 1);
        cache.put(2, 2);
        cache.printCache();  // Should print: (2:2) (1:1)

        System.out.println(cache.get(1)); // returns 1
        cache.printCache();  // Should print: (1:1) (2:2)

        cache.put(3, 3);     // evicts key 2
        cache.printCache();  // Should print: (3:3) (1:1)

        System.out.println(cache.get(2)); // returns -1 (not found)

        cache.put(4, 4);     // evicts key 1
        cache.printCache();  // Should print: (4:4) (3:3)

        System.out.println(cache.get(1)); // returns -1 (not found)
        System.out.println(cache.get(3)); // returns 3
        System.out.println(cache.get(4)); // returns 4
    }
}
