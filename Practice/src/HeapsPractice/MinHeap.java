package HeapsPractice;

import java.util.ArrayList;
import java.util.List;

public class MinHeap {

    List<Integer> heap;

    public MinHeap() {
        heap = new ArrayList<>();
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int left(int i) {
        return (2 * i + 1) / 2;
    }

    private int right(int i) {
        return (2 * i + 2) / 2;
    }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    private void insert(int val) {
        heap.add(val);
        int current = heap.size() - 1;

        while (current > 0 && heap.get(current) < heap.get(parent(current))) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    private int peek(){
        if(heap.isEmpty()) throw  new IllegalStateException("The Heap is Empty");
        return heap.getFirst();
    }

    private int removeMin() {

        if (heap.isEmpty()) throw new IllegalStateException("the Heap is empty");

        int min = heap.getFirst();
        int last = heap.removeLast();

        if (!heap.isEmpty()) {
            heap.set(0, last);
            heapifyDown(0);
        }

        return min;
    }

    private void heapifyDown(int i) {
        int smallest = i;
        int left = left(i);
        int right = right(i);

        if (left < heap.size() && heap.get(smallest) < heap.get(left)) {
            smallest = left;
        }

        if (right < heap.size() && heap.get(smallest) < heap.get(right)) {
            smallest = right;
        }

        if (smallest != i) {
            swap(i, smallest);
            heapifyDown(smallest);
        }
    }


    public void printHeap() {
        System.out.println(heap);
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(8);
        minHeap.insert(1);
        minHeap.insert(6);

        minHeap.printHeap(); // Output may look like: [1, 3, 8, 5, 6]

        System.out.println("Min: " + minHeap.peek()); // 1
        System.out.println("Removed Min: " + minHeap.removeMin()); // 1
        minHeap.printHeap(); // Heap after removal
    }
}
