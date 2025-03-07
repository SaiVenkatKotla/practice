package geeksforgeeks;

import java.util.*;

public class LongestConsecutiveSubsequence {

    /**
     * Method to find the length of the longest consecutive subsequence.
     *
     * @param arr The input array of non-negative integers.
     * @return The length of the longest consecutive subsequence.
     */
    public int longestConsecutive(int[] arr) {
        int max = 0, max_length = 0, window_length = 0;
        for (int n : arr) {
            max = Math.max(n, max);
        }
        int[] frequency_arr = new int[max + 1];
        for (int n : arr) {
            frequency_arr[n] = 1;
        }
        Arrays.sort(arr);
        for (int j : frequency_arr) {
            if (j != 0) {
                max_length = Math.max(max_length, window_length + 1);
                window_length = window_length + j;
            } else {
                window_length = 0;
            }
        }
        return max_length;
    }

    // Main method to test the implementation with examples
    public static void main(String[] args) {
        LongestConsecutiveSubsequence solution = new LongestConsecutiveSubsequence();

        // Example 1
        int[] arr1 = {2, 6, 1, 9, 4, 5, 3};
        int result1 = solution.longestConsecutive(arr1);
        System.out.println("Example 1: " + result1); // Expected output: 6

        // Example 2
        int[] arr2 = {1, 9, 3, 10, 4, 20, 2};
        int result2 = solution.longestConsecutive(arr2);
        System.out.println("Example 2: " + result2); // Expected output: 4

        // Example 3
        int[] arr3 = {15, 13, 12, 14, 11, 10, 9};
        int result3 = solution.longestConsecutive(arr3);
        System.out.println("Example 3: " + result3); // Expected output: 7


        // New Input
        int[] arr4 = {99, 80, 60, 33, 44, 86, 34, 64, 77, 18, 39, 3, 27, 16, 29, 60, 67, 23, 7, 87, 6, 75, 92, 11, 59, 13, 88, 24, 98, 4, 26, 6};
        int result4 = solution.longestConsecutive(arr4);
        System.out.println("New Input: " + result4); // Expected output: 3


        // New Input 2
        int[] arr5 = {53, 57, 77, 15, 78, 58, 17, 63, 90, 73, 68, 82, 40, 68, 22, 52, 81, 92, 80, 37, 62, 17, 76, 67, 55, 56, 20, 22, 37, 71, 65, 7, 30, 93, 1, 1, 90, 46, 36, 74, 0, 37, 76, 69, 39, 97, 39, 30, 14, 89, 74, 71, 27, 79, 51, 45, 51, 54, 90, 35, 68, 38, 7, 82, 55, 65, 14, 40, 20, 64, 89, 95, 8, 43, 14, 88, 5, 24, 72, 9, 56, 17, 60, 91, 16, 94, 47, 15, 33};
        int result5 = solution.longestConsecutive(arr5);
        System.out.println("New Input 2: " + result5); // Expected output: 8
    }
}
