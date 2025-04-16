package LeetCode;

import java.util.PriorityQueue;

public class KthLargest {

    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>();

        for (int n : nums) {
            add(n);
        }
    }

    public int add(int n) {
        minHeap.offer(n);

        if (minHeap.size() > k) {
            minHeap.poll();
        }

        return minHeap.peek();
    }
}
