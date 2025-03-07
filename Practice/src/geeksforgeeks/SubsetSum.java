package geeksforgeeks;

import java.util.Arrays;

public class SubsetSum {

    // Method to determine if there is a subset with the given target sum
    public static Boolean isSubsetSum(int[] arr, int target) {
        boolean[][] t = new boolean[arr.length + 1][target + 1];
        Arrays.fill(t[0], false);
        t[0][0] = true;
        for (int i = 1; i < arr.length + 1; i++) {
            for (int j = 0; j < target + 1; j++) {
                if (j == 0) {
                    t[i][j] = true;
                } else if (j >= arr[i - 1]) {
                    t[i][j] = t[i - 1][j - arr[i - 1]] || t[i-1][j];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        return t[arr.length][target];
    }

    public static void main(String[] args) {
        // Example 1
        int[] arr1 = {3, 34, 4, 12, 5, 2};
        int target1 = 9;
        System.out.println("Example 1 Output: " + isSubsetSum(arr1, target1)); // Expected: true

        // Example 2
        int[] arr2 = {3, 34, 4, 12, 5, 2};
        int target2 = 30;
        System.out.println("Example 2 Output: " + isSubsetSum(arr2, target2)); // Expected: false

        // Example 3
        int[] arr3 = {1, 2, 3};
        int target3 = 6;
        System.out.println("Example 3 Output: " + isSubsetSum(arr3, target3)); // Expected: true
    }
}

