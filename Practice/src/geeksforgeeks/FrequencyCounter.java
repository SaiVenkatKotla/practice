package geeksforgeeks;

import java.util.Arrays;

public class FrequencyCounter {

    // Method to count occurrences of target in arr
    public int countFreq(int[] arr, int target) {
        return (int)Arrays.stream(arr).filter(x -> x == target).count();
    }

    public static void main(String[] args) {
        FrequencyCounter counter = new FrequencyCounter();

        // Test cases
        int[] arr1 = {1, 1, 2, 2, 2, 2, 3};
        System.out.println(counter.countFreq(arr1, 2)); // Expected Output: 4

        int[] arr2 = {1, 1, 2, 2, 2, 2, 3};
        System.out.println(counter.countFreq(arr2, 4)); // Expected Output: 0

        int[] arr3 = {8, 9, 10, 12, 12, 12};
        System.out.println(counter.countFreq(arr3, 12)); // Expected Output: 3
    }
}
