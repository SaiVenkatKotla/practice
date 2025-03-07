package geeksforgeeks;

public class FloorFinder {

    /**
     * Finds the index of the largest element in the array that is less than or equal to k.
     *
     * @param arr The sorted array with unique elements.
     * @param k   The integer for which the floor is to be found.
     * @return The index of the floor element, or -1 if no such element exists.
     */
    public static int findFloor(int[] arr, int k) {
        int pos = 0;
        while (k >= arr[pos]) {
            pos++;
        }
        return pos - 1;
    }

    // Main method to test the findFloor function with examples.
    public static void main(String[] args) {
        // Example 1: arr = [1, 2, 8, 10, 11, 12, 19], k = 0
        int[] arr1 = {1, 2, 8, 10, 11, 12, 19};
        int k1 = 0;
        System.out.println("Input: arr = [1, 2, 8, 10, 11, 12, 19], k = " + k1);
        System.out.println("Output: " + findFloor(arr1, k1));
        System.out.println();

        // Example 2: arr = [1, 2, 8, 10, 11, 12, 19], k = 5
        int[] arr2 = {1, 2, 8, 10, 11, 12, 19};
        int k2 = 5;
        System.out.println("Input: arr = [1, 2, 8, 10, 11, 12, 19], k = " + k2);
        System.out.println("Output: " + findFloor(arr2, k2));
        System.out.println();

        // Example 3: arr = [1, 2, 8], k = 1
        int[] arr3 = {1, 2, 8};
        int k3 = 1;
        System.out.println("Input: arr = [1, 2, 8], k = " + k3);
        System.out.println("Output: " + findFloor(arr3, k3));
    }
}
