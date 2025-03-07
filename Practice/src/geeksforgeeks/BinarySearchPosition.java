package geeksforgeeks;

public class BinarySearchPosition {

    // Method to perform binary search in a sorted array
    public int binarySearch(int[] arr, int k) {
        int left = 0;
        int right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == k) {
                result = mid; // Update result to the current index
                right = mid - 1; // Move left to find the smallest index
            } else if (arr[mid] < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        BinarySearchPosition bsp = new BinarySearchPosition();

        // Example 1
        int[] arr1 = {1, 2, 3, 4, 5};
        int k1 = 4;
        System.out.println("Position of " + k1 + " in arr1: " + bsp.binarySearch(arr1, k1));

        // Example 2
        int[] arr2 = {11, 22, 33, 44, 55};
        int k2 = 445;
        System.out.println("Position of " + k2 + " in arr2: " + bsp.binarySearch(arr2, k2));

        // Example 3
        int[] arr3 = {1, 1, 1, 1, 2};
        int k3 = 1;
        System.out.println("Position of " + k3 + " in arr3: " + bsp.binarySearch(arr3, k3));
    }
}
