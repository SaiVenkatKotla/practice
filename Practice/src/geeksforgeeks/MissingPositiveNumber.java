package geeksforgeeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MissingPositiveNumber {

    /**
     * Finds the smallest positive number missing from the array.
     *
     * @param arr The integer array (can contain negative numbers).
     * @return The smallest positive missing number.
     */
    public int missingNumber(int[] arr) {
        Arrays.sort(arr);
        int i = 1, pos = 0;
        while (pos < arr.length && arr[pos] != i) {
            pos++;
        }
        if (pos == arr.length)
            return i;
        while (pos< arr.length && arr[pos] == i){
            while (pos< arr.length && arr[pos] == i)
                pos++;
            i++;
        }

        return i;
    }

    // Main method to test the missingNumber function with examples.
    public static void main(String[] args) {
        MissingPositiveNumber finder = new MissingPositiveNumber();

        // Example 1: arr = [2, -3, 4, 1, 1, 7]
        int[] arr1 = {2, -3, 4, 1, 1, 7};
        System.out.println("Input: arr = [2, -3, 4, 1, 1, 7]");
        System.out.println("Output: " + finder.missingNumber(arr1));
        System.out.println();

        // Example 2: arr = [5, 3, 2, 5, 1]
        int[] arr2 = {5, 3, 2, 5, 1};
        System.out.println("Input: arr = [5, 3, 2, 5, 1]");
        System.out.println("Output: " + finder.missingNumber(arr2));
        System.out.println();

        // Example 3: arr = [-8, 0, -1, -4, -3]
        int[] arr3 = {-8, 0, -1, -4, -3};
        System.out.println("Input: arr = [-8, 0, -1, -4, -3]");
        System.out.println("Output: " + finder.missingNumber(arr3));

        int[] arr4 = {1, 1, 1, 1, 1};
        System.out.println("Output: " + finder.missingNumber(arr4));
    }
}