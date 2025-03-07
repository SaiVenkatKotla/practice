package geeksforgeeks;

import java.util.Arrays;
import java.util.HashSet;

public class SubarrayZeroSum {

    // Method to check if a subarray with sum 0 exists
    public static boolean findsum(int arr[]) {
        HashSet<Integer> set = new HashSet<>();
        int sum = 0;
        for (int num : arr) {
            sum += num;
            if (sum == 0 || set.contains(sum)) {
                return true;
            }
            set.add(sum);
        }
        return false;
    }

    public static void main(String[] args) {
        // Test cases
        int[] arr1 = {4, 2, -3, 1, 6};
        System.out.println(findsum(arr1)); // Expected Output: true

        int[] arr2 = {4, 2, 0, 1, 6};
        System.out.println(findsum(arr2)); // Expected Output: true

        int[] arr3 = {1, 2, -1};
        System.out.println(findsum(arr3)); // Expected Output: false
    }
}
