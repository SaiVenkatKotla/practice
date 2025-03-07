package geeksforgeeks;

import java.util.Arrays;

public class TripletSumZero {

    public static boolean hasTripletWithZeroSum(int[] arr) {
        int n = arr.length;

        // Sort the array
        Arrays.sort(arr);

        // Iterate through the array
        for (int i = 0; i < n - 2; i++) {
            int target = -arr[i]; // Target sum for the two-pointer approach
            int left = i + 1;
            int right = n - 1;

            // Two-pointer approach to find the pair with sum = target
            while (left < right) {
                int sum = arr[left] + arr[right];
                if (sum == target) {
                    return true; // Found a triplet
                } else if (sum < target) {
                    left++; // Move left pointer to increase sum
                } else {
                    right--; // Move right pointer to decrease sum
                }
            }
        }

        return false; // No triplet found
    }

    public static void main(String[] args) {
        int[] arr1 = {0, -1, 2, -3, 1};
        System.out.println(hasTripletWithZeroSum(arr1)); // Output: true

        int[] arr2 = {1, 2, 3};
        System.out.println(hasTripletWithZeroSum(arr2)); // Output: false

        int[] arr3 = {-5, 3, 2, -1, 0, 1};
        System.out.println(hasTripletWithZeroSum(arr3)); // Output: true
    }
}
