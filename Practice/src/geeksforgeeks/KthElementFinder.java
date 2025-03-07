package geeksforgeeks;

import java.util.Arrays;

public class KthElementFinder {

    /**
     * Finds the element at the kth position in the combined sorted array of two sorted arrays.
     *
     * @param a the first sorted array
     * @param b the second sorted array
     * @param k the position (1-based) of the element to find in the combined sorted array
     * @return the element at the kth position
     */
    public int kthElement(int[] a, int[] b, int k) {
        int[] c = new int[a.length+b.length];
        int i =0;
        for (int n : a) {
            c[i++] = n;
        }
        for (int j : b) {
            c[i++] = j;
        }
        Arrays.sort(c);
        return c[k-1];
    }

    public static void main(String[] args) {
        KthElementFinder finder = new KthElementFinder();

        // Example 1
        int[] a1 = {2, 3, 6, 7, 9};
        int[] b1 = {1, 4, 8, 10};
        int k1 = 5;
        System.out.println("The " + k1 + "th element is: " + finder.kthElement(a1, b1, k1));

        // Example 2
        int[] a2 = {100, 112, 256, 349, 770};
        int[] b2 = {72, 86, 113, 119, 265, 445, 892};
        int k2 = 7;
        System.out.println("The " + k2 + "th element is: " + finder.kthElement(a2, b2, k2));
    }
}
