package Sorting;


import java.util.Arrays;


public class QuickSort {

    public static void main(String[] args) {
        int[] array = {10, 7, 8, 9, 1, 5};
        System.out.println("Original Array: " + Arrays.toString(array));
        quickSort(array, 0, array.length - 1);
        System.out.println("Sorted Array:   " + Arrays.toString(array));
    }

    private static void quickSort(int[] arr, int low, int high) {

        if (low < high) {

            int p = partition(arr, low, high);

            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);

        }
    }

    private static int partition(int[] arr, int low, int high) {
        int i = low - 1;
        int pivot = arr[high];

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
