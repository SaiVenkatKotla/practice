package geeksforgeeks;


import java.util.Arrays;

public class ArrayRotation {

    // Method to rotate the array to the left by d steps
    public static void rotateArr(int arr[], int d) {
        int[] result = new int[arr.length];
        d =  d % arr.length;
        int l = d;
        for (int j = 0; j < arr.length - d; j++) {
            result[j] = arr[l];
            l++;
        }
        l -= d;
        for (int i = 0; i < d; i++) {
            result[l] = arr[i];
            l++;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = result[i];
        }
    }

    // Main method to test the rotateArr method with example inputs
    public static void main(String[] args) {
        // Example 1
        int[] arr1 = {1, 2, 3, 4, 5};
        int d1 = 2;
        rotateArr(arr1, d1);
        System.out.println("Rotated Array (Example 1): " + Arrays.toString(arr1));

        // Example 2
        int[] arr2 = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
        int d2 = 3;
        rotateArr(arr2, d2);
        System.out.println("Rotated Array (Example 2): " + Arrays.toString(arr2));

        // Example 3
        int[] arr3 = {7, 3, 9, 1};
        int d3 = 9;
        rotateArr(arr3, d3);
        System.out.println("Rotated Array (Example 3): " + Arrays.toString(arr3));
    }
}
