package geeksforgeeks;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

public class LongestSubArraySum {
    /**
     * Finds the length of the longest subarray with a sum equal to k.
     *
     * @param arr the input array of integers
     * @param k   the target sum
     * @return the length of the longest subarray with sum equal to k
     */
    public int lenOfLongestSubarr(int[] arr, int k) {
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        int maxLength = 0;
        int currentSum = 0;

        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];
            if (currentSum == k) {
                maxLength = i + 1;
            }
            if (sumMap.containsKey(currentSum - k)) {
                maxLength = Math.max(maxLength, i - sumMap.get(currentSum - k));
            }

            if (!sumMap.containsKey(currentSum)) {
                sumMap.put(currentSum, i);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubArraySum solver = new LongestSubArraySum();

        // Example 1
        int[] arr1 = {10, 5, 2, 7, 1, 9};
        int k1 = 15;
        System.out.println("Example 1: " + solver.lenOfLongestSubarr(arr1, k1)); // Expected output: 4

        // Example 2
        int[] arr2 = {-1, 2, -3};
        int k2 = -2;
        System.out.println("Example 2: " + solver.lenOfLongestSubarr(arr2, k2)); // Expected output: 3

        // Example 3
        int[] arr3 = {1, -1, 5, -2, 3};
        int k3 = 3;
        System.out.println("Example 3: " + solver.lenOfLongestSubarr(arr3, k3)); // Expected output: 4
    }
}

