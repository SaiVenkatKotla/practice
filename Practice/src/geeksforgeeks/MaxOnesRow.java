package geeksforgeeks;

public class MaxOnesRow {

    /**
     * Finds the index of the first row that contains the maximum number of 1s.
     *
     * @param arr 2D binary array with rows sorted in non-decreasing order
     * @return Index of the row with the maximum number of 1s, or -1 if no such row exists
     */
    public int rowWithMax1s(int[][] arr) {
        int n = arr.length;    // Number of rows
        int m = arr[0].length; // Number of columns
        int max1sRow = -1;     // Stores the index of the row with the maximum 1s
        int max1sCount = 0;    // Maximum number of 1s found so far

        for (int i = 0; i < n; i++) {
            int count = countOnesInRow(arr[i]);
            if (count > max1sCount) {
                max1sCount = count;
                max1sRow = i;
            }
        }

        return max1sRow;
    }

    private int countOnesInRow(int[] row) {
        int low = 0, high = row.length - 1;

        // Binary search to find the first occurrence of 1
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (row[mid] == 1) {
                high = mid - 1; // Move to the left part of the array
            } else {
                low = mid + 1; // Move to the right part of the array
            }
        }
        return row.length - low;
    }

    public static void main(String[] args) {
        MaxOnesRow obj = new MaxOnesRow();

        // Example 1
        int[][] arr1 = {{0, 1, 1, 1}, {0, 1, 1, 1}, {0, 1, 1, 1}, {0, 0, 0, 0}};
        System.out.println(obj.rowWithMax1s(arr1)); // Expected Output: 2

        // Example 2
        int[][] arr2 = {{0, 0}, {1, 1}};
        System.out.println(obj.rowWithMax1s(arr2)); // Expected Output: 1

        // Example 3
        int[][] arr3 = {{0, 0}, {0, 0}};
        System.out.println(obj.rowWithMax1s(arr3)); // Expected Output: -

        // Example 4 (New Input)
        int[][] arr4 = {{0}};
        System.out.println("Output: " + obj.rowWithMax1s(arr4)); // Expected Output: -1

        // Example 5 (New Input)
        int[][] arr5 = {{1}};
        System.out.println("Output: " + obj.rowWithMax1s(arr5)); // Expected Output: 0
    }
}

