package geeksforgeeks;

import java.util.*;

public class UnionOfArrays {

    /**
     * Method to find the number of elements in the union of two arrays.
     *
     * @param a The first array of integers.
     * @param b The second array of integers.
     * @return The number of distinct elements in the union of the two arrays.
     */
    public static int findUnion(int[] a, int[] b) {
        /*Arrays.sort(a);
        Arrays.sort(b);
        int left = 0, right = 0;
        HashSet<Integer> list = new HashSet<>();
        while (left < a.length && right < b.length) {
            if (a[left] == b[right]) {
                list.add(a[left]);
                left++;
                right++;
            } else if (a[left] < b[right]) {
                list.add(a[left]);
                left++;
            } else {
                list.add(b[right]);
                right++;
            }
        }
        while (left < a.length) {
            list.add(a[left]);
            left++;
        }
        while (right < b.length) {
            list.add(b[right]);
            right++;
        }
        return list.size(); // Placeholder return value*/
        HashSet<Integer> list = new HashSet<>();
        for (int n : a) {
            list.add(n);
        }
        for (int m : b) {
            list.add(m);
        }
        return list.size();
    }

    // Main method to test the implementation with examples
    public static void main(String[] args) {
        // Example 1
        int[] a1 = {1, 2, 3, 4, 5};
        int[] b1 = {1, 2, 3};
        int result1 = findUnion(a1, b1);
        System.out.println("Example 1: " + result1); // Expected output: 5

        // Example 2
        int[] a2 = {85, 25, 1, 32, 54, 6};
        int[] b2 = {85, 2};
        int result2 = findUnion(a2, b2);
        System.out.println("Example 2: " + result2); // Expected output: 7

        // Example 3
        int[] a3 = {1, 2, 1, 1, 2};
        int[] b3 = {2, 2, 1, 2, 1};
        int result3 = findUnion(a3, b3);
        System.out.println("Example 3: " + result3); // Expected output: 2
    }
}