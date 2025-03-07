package geeksforgeeks;

import java.util.ArrayList;
import java.util.List;

public class UnionOfSortedArrays {
    public static List<Integer> findUnion(int[] a, int[] b) {
        List<Integer> union = new ArrayList<>();
        int i = 0, j = 0;
        int m = a.length, n = b.length;

        // Traverse both arrays
        while (i < m && j < n) {
            // Skip duplicates in array a
            if (i > 0 && a[i] == a[i - 1]) {
                i++;
                continue;
            }
            // Skip duplicates in array b
            if (j > 0 && b[j] == b[j - 1]) {
                j++;
                continue;
            }

            // Add the smaller element to the union list
            if (a[i] < b[j]) {
                union.add(a[i]);
                i++;
            } else if (a[i] > b[j]) {
                union.add(b[j]);
                j++;
            } else {
                // If both elements are equal, add one and move both pointers
                union.add(a[i]);
                i++;
                j++;
            }
        }

        // Add remaining elements of array a (if any)
        while (i < m) {
            if (i == 0 || a[i] != a[i - 1]) {
                union.add(a[i]);
            }
            i++;
        }

        // Add remaining elements of array b (if any)
        while (j < n) {
            if (j == 0 || b[j] != b[j - 1]) {
                union.add(b[j]);
            }
            j++;
        }

        return union;
    }

    public static void main(String[] args) {
        int[] a1 = {1, 2, 3, 4, 5};
        int[] b1 = {1, 2, 3, 6, 7};
        System.out.println(findUnion(a1, b1)); // Output: [1, 2, 3, 4, 5, 6, 7]

        int[] a2 = {2, 2, 3, 4, 5};
        int[] b2 = {1, 1, 2, 3, 4};
        System.out.println(findUnion(a2, b2)); // Output: [1, 2, 3, 4, 5]

        int[] a3 = {1, 1, 1, 1, 1};
        int[] b3 = {2, 2, 2, 2, 2};
        System.out.println(findUnion(a3, b3)); // Output: [1, 2]
    }
}