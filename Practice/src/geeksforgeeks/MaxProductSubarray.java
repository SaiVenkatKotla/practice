package geeksforgeeks;

public class MaxProductSubarray {

    /**
     * Method to find the maximum product of a subarray in the given array.
     *
     * @param arr The input array containing positive, negative integers, and zeros.
     * @return The maximum product of a subarray.
     */
    public int maxProduct(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;
        int maxProduct = arr[0], minProduct = arr[0], result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < 0) {
                int temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
            }
            maxProduct = Math.max(arr[i], maxProduct * arr[i]);
            minProduct = Math.min(arr[i], minProduct * arr[i]);

            result = Math.max(result, maxProduct);
        }
        return result;
    }

    // Main method to test the implementation with examples
    public static void main(String[] args) {
        MaxProductSubarray solution = new MaxProductSubarray();

        // Example 1
        int[] arr1 = {-2, 6, -3, -10, 0, 2};
        System.out.println("Example 1: " + solution.maxProduct(arr1)); // Expected output: 180

        // Example 2
        int[] arr2 = {-1, -3, -10, 0, 6};
        System.out.println("Example 2: " + solution.maxProduct(arr2)); // Expected output: 30

        // Example 3
        int[] arr3 = {2, 3, 4};
        System.out.println("Example 3: " + solution.maxProduct(arr3)); // Expected output: 24

        // Example 4
        int[] arr4 = {-2, 0, -1};
        System.out.println("Example 4: " + solution.maxProduct(arr4)); // Expected output: 0

        //Example 5
        int[] arr5 = {-6};
        System.out.println("Example 5: " + solution.maxProduct(arr5)); // Expected output: -6
    }
}