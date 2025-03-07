package geeksforgeeks;

import java.util.Arrays;

public class ArrayEqualityChecker {

    /**
     * Method to check if two arrays are equal (considering permutations and repetitions).
     *
     * @param a The first array of integers.
     * @param b The second array of integers.
     * @return true if the arrays are equal, false otherwise.
     */
    public static boolean checkEqual(int[] a, int[] b) {
        int max = 0;
        for (int n : a) {
            max = Math.max(n, max);
        }
        int[] e = new int[max + 1];
        max = 0;
        for (int m : b) {
            max = Math.max(m, max);
        }
        int[] f = new int[max + 1];
        for (int n : a) {
            e[n] = e[n] + 1;
        }
        for (int n : b) {
            f[n] = f[n] + 1;
        }
        int i = 0;
        while (i < e.length && i < f.length) {
            if (e[i] != f[i])
                return false;
            i++;
        }

        if (i == e.length && i == f.length)
            return true;
        return false; // Placeholder return value
    }

    // Main method to test the implementation with examples
    public static void main(String[] args) {
        // Example 1
        int[] a1 = {1, 2, 5, 4, 0};
        int[] b1 = {2, 4, 5, 0, 1};
        boolean result1 = checkEqual(a1, b1);
        System.out.println("Example 1: " + result1); // Expected output: true

        // Example 2
        int[] a2 = {1, 2, 5};
        int[] b2 = {2, 4, 15};
        boolean result2 = checkEqual(a2, b2);
        System.out.println("Example 2: " + result2); // Expected output: false

        // Example 3
        int[] a3 = {1, 2, 5};
        int[] b3 = {2, 5, 15};
        boolean result3 = checkEqual(a3, b3);
        System.out.println("Example 2: " + result3); // Expected output: false
    }
}