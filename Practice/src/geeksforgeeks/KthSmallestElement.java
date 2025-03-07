package geeksforgeeks;

public class KthSmallestElement {
    public static int findKthSmallest(int[] arr, int k) {
        // Find the maximum element in the array
        int maxElement = 0;
        for (int num : arr) {
            maxElement = Math.max(maxElement, num);
        }

        // Create a frequency array
        int[] freq = new int[maxElement + 1];

        // Populate the frequency array
        for (int num : arr) {
            freq[num]++;
        }

        // Find the k-th smallest element
        int count = 0;
        for (int i = 0; i <= maxElement; i++) {
            count += freq[i];
            if (count >= k) {
                return i; // Found the k-th smallest element
            }
        }

        return -1; // Shouldn't reach here for valid inputs
    }

    public static void main(String[] args) {
        // Test case 1
        int[] arr1 = {7, 10, 4, 3, 20, 15};
        int k1 = 3;
        System.out.println("The " + k1 + "rd smallest element is: " + findKthSmallest(arr1, k1)); // Output: 7

        // Test case 2
        int[] arr2 = {2, 3, 1, 20, 15};
        int k2 = 4;
        System.out.println("The " + k2 + "th smallest element is: " + findKthSmallest(arr2, k2)); // Output: 15
    }
}

