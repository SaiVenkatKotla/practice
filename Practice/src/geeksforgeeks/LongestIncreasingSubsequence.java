package geeksforgeeks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class LongestIncreasingSubsequence {

    // Method to find the length of the Longest Strictly Increasing Subsequence
    /*public static int lis(int arr[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int  p, max = 0,max_count = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            max_count = 0;
            p = i + 1;
            while (p < arr.length) {
                if (arr[i] < arr[p] && map.containsKey(arr[p])) {
                    max_count = Math.max(map.get(arr[p]), max_count);
                }
                p++;
            }
            map.put(arr[i], max_count + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            max = Math.max(max, entry.getValue());
        }
        return max; // Placeholder return statement
    }*/

    public static int lis(int arr[]) {
        int n = arr.length;
        if (n == 0) return 0;

        // Create an array to store the LIS for each index
        int[] dp = new int[n];
        // Initialize all LIS values to 1 since the minimum LIS is 1 (each element itself)
        Arrays.fill(dp, 1);

        // Compute LIS values for all indices
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        // Find the maximum LIS value
        int maxLis = 0;
        for (int i = 0; i < n; i++) {
            maxLis = Math.max(maxLis, dp[i]);
        }

        return maxLis;
    }

    // Main method for testing
    public static void main(String[] args) {
        // Example 1
        int[] example1 = {5, 8, 3, 7, 9, 1};
        System.out.println("Example 1: " + lis(example1)); // Expected Output: 3

        // Example 2
        int[] example2 = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
        System.out.println("Example 2: " + lis(example2)); // Expected Output: 6

        // Example 3
        int[] example3 = {3, 10, 2, 1, 20};
        System.out.println("Example 3: " + lis(example3)); // Expected Output: 3
    }
}

