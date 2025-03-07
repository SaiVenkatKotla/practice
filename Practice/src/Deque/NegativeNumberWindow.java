package Deque;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class NegativeNumberWindow {

    /**
     * Given an array of integers and a number k, find the first negative number in every contiguous subarray (or window)
     * of size k. If a window does not contain a negative number, return 0 for that window.
     */

    public static void main(String[] args) {

        long[] nums = {12, -1, -7, 8, -15, 30, 16, 28};
        int k = 3;
        System.out.println(Arrays.toString(firstNegativeInEveryWindow(nums, k)));
        // Output: [-1, -1, -7, -15, -15, 0]
    }

    private static long[] firstNegativeInEveryWindow(long[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        long[] result = new long[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) { //i=7

            if (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }

            if (nums[i] < 0) {
                deque.offer(i); //
            }

            if (i >= k - 1) {
                result[i - k + 1] = deque.isEmpty() ? 0 : nums[deque.peek()];
            }
        }
        return result;
    }
}
