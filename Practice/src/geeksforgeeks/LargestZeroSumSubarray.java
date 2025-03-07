package geeksforgeeks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LargestZeroSumSubarray {

    /**
     * Method to compute the length of the largest subarray with a sum of 0.
     *
     * @param arr the input array containing both positive and negative integers
     * @return the length of the largest subarray with a sum of 0
     */
    public int maxLen(int[] arr) {
        // Map to store the cumulative sum and its index
        HashMap<Integer, Integer> sumIndexMap = new HashMap<>();
        int maxLength = 0;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sum == 0) {
                maxLength = i + 1;
            }

            if (sumIndexMap.containsKey(sum)) {
                maxLength = Math.max(maxLength, i - sumIndexMap.get(sum));
            } else {
                sumIndexMap.put(sum, i);
            }
        }

        return maxLength;
    }

    // Main method to test the class
    public static void main(String[] args) {
        LargestZeroSumSubarray obj = new LargestZeroSumSubarray();

        int[] arr1 = {15, -2, 2, -8, 1, 7, 10, 23};
        System.out.println("Output: " + obj.maxLen(arr1)); // Expected: 5


        int[] arr2 = {2, 10, 4};
        System.out.println("Output: " + obj.maxLen(arr2)); // Expected: 0

        int[] arr3 = {1, 0, -4, 3, 1, 0};
        System.out.println("Output: " + obj.maxLen(arr3)); // Expected: 5
    }
}
