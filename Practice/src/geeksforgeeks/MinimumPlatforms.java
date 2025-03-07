package geeksforgeeks;

import java.util.Arrays;

import java.util.*;

public class MinimumPlatforms {

    /**
     * Finds the minimum number of platforms required at a station.
     *
     * @param arr array of train arrival times
     * @param dep array of train departure times
     * @return minimum number of platforms required
     */
    public static int findPlatforms(int[] arr, int[] dep) {
        // Sort both arrival and departure arrays
        Arrays.sort(arr);
        Arrays.sort(dep);

        int platforms = 0; // Current number of platforms needed
        int maxPlatforms = 0; // Maximum platforms required
        int i = 0, j = 0;

        // Traverse both arrays
        while (i < arr.length && j < dep.length) {
            if (arr[i] <= dep[j]) {
                // A train is arriving, need an additional platform
                platforms++;
                i++;
            } else {
                // A train is departing, release a platform
                platforms--;
                j++;
            }
            // Update the maximum number of platforms needed
            maxPlatforms = Math.max(maxPlatforms, platforms);
        }

        return maxPlatforms;
    }

    public static void main(String[] args) {
        // Example 1
        int[] arr1 = {900, 940, 950, 1100, 1500, 1800};
        int[] dep1 = {910, 1200, 1120, 1130, 1900, 2000};
        System.out.println("Minimum platforms needed: " + findPlatforms(arr1, dep1)); // Output: 3

        // Example 2
        int[] arr2 = {900, 1235, 1100};
        int[] dep2 = {1000, 1240, 1200};
        System.out.println("Minimum platforms needed: " + findPlatforms(arr2, dep2)); // Output: 1

        // Example 3
        int[] arr3 = {1000, 935, 1100};
        int[] dep3 = {1200, 1240, 1130};
        System.out.println("Minimum platforms needed: " + findPlatforms(arr3, dep3)); // Output: 3
    }
}
