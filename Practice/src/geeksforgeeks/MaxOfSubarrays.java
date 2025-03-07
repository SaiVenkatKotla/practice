package geeksforgeeks;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class MaxOfSubarrays {

    /**
     * Finds the maximum value for each contiguous subarray of size k.
     *
     * @param arr the input array
     * @param k   the size of the subarray
     * @return an ArrayList containing the maximum values of each subarray
     */
    public ArrayList<Integer> max_of_subarrays(int[] arr, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>(); // Stores indices of array elements

        for (int i = 0; i < arr.length; i++) {
            // Remove elements not in the current window
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // Remove all elements smaller than the current element from the deque
            while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]) {
                deque.pollLast();
            }

            // Add current element index
            deque.offerLast(i);

            // Add the maximum element of the current window to the result
            if (i >= k - 1) {
                result.add(arr[deque.peekFirst()]);
            }
        }

        return result;
    }

    // Main method to test the implementation
    public static void main(String[] args) {
        MaxOfSubarrays obj = new MaxOfSubarrays();

        int[] arr1 = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        System.out.println("Output: " + obj.max_of_subarrays(arr1, 3)); // Expected: [3, 3, 4, 5, 5, 5, 6]

        int[] arr2 = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13};
        System.out.println("Output: " + obj.max_of_subarrays(arr2, 4)); // Expected: [10, 10, 10, 15, 15, 90, 90]

        int[] arr3 = {5, 1, 3, 4, 2, 6};
        System.out.println("Output: " + obj.max_of_subarrays(arr3, 1)); // Expected: [5, 1, 3, 4, 2, 6]
    }
}
