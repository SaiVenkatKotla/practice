package geeksforgeeks;

import java.util.HashMap;
import java.util.Map;

public class MajorityElementFinder {

    // Method to find the majority element, now accepting the array as input
    public int findMajorityElement(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int p = arr.length / 2;
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int n : arr) {
            count.merge(n, 1, Integer::sum);
        }

        for (Map.Entry<Integer, Integer> e : count.entrySet()) {
            if(e.getValue() > p )
                return e.getKey();
        }

        return -1;
    }

    // Main method for testing
    public static void main(String[] args) {
        MajorityElementFinder finder = new MajorityElementFinder();

        // Example 1
        int[] arr1 = {3, 1, 3, 3, 2};
        System.out.println("Majority Element: " + finder.findMajorityElement(arr1)); // Expected: 3

        // Example 2
        int[] arr2 = {7};
        System.out.println("Majority Element: " + finder.findMajorityElement(arr2)); // Expected: 7

        // Example 3
        int[] arr3 = {2, 13};
        System.out.println("Majority Element: " + finder.findMajorityElement(arr3)); // Expected: -1
    }
}

