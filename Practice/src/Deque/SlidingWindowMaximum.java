package Deque;


/*Problem Statement: Given an array of integers and a sliding window size k,
 find the maximum value in each window as it slides from left to right across the array.
 */

import java.util.*;

public class SlidingWindowMaximum {

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k))); // Output: [3, 3, 5, 5, 6, 7]
    }

    private static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int[] result = new int[nums.length-k+1];
        for (int i = 0; i < nums.length; i++) { //i=0
            if(!deque.isEmpty() && deque.peek() < i - k +1){
                deque.poll();
            }

            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
                deque.pollLast();
            }

            deque.offer(i);

            if( i >= k-1){
                result[i - k + 1] = nums[deque.peek()];
            }

        }

        return result;
    }
}
