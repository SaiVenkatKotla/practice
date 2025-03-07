package geeksforgeeks;

import java.util.Arrays;
import java.util.stream.IntStream;

class MaxValuePermutation {

    // Method to find the maximum value permutation
    public int maxValue(int arr[]) {
        Arrays.sort(arr);
        return Math.floorMod(IntStream.range(0, arr.length).map(x -> x * arr[x]).sum(), (int) Math.pow(10, 7) + 7);
    }

    public static void main(String[] args) {
        // Example test cases
        int[] arr1 = {5, 3, 2, 4, 1};
        int[] arr2 = {1, 2, 3};
        int[] arr3 = {7, 7, 7, 7};

        MaxValuePermutation obj = new MaxValuePermutation();

        // Placeholder print statements
        System.out.println(obj.maxValue(arr1)); // Expected Output: 40 after implementation
        System.out.println(obj.maxValue(arr2)); // Expected Output: 8 after implementation
        System.out.println(obj.maxValue(arr3)); // Expected Output: 42 after implementation
    }
}
