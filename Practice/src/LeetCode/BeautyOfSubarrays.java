package LeetCode;

import java.util.*;

public class BeautyOfSubarrays {
    public int[]  getSubarrayBeauty(int[] nums, int k, int x) {
        int n = nums.length;
        int[] result = new int[n-k+1];
        int[] freq = new int[101]; // Index 0 for -50, index 100 for 50

        // Initialize the first window
        for (int i = 0; i < k; i++) {
            if (nums[i] < 0) {
                freq[nums[i] + 50]++;
            }
        }
        result[0] =getXthSmallestNegative(freq, x);

        // Slide the window
        for (int i = k; i < nums.length; i++) {
            // Remove the element going out
            if (nums[i - k] < 0) {
                freq[nums[i - k] + 50]--;
            }
            // Add the new element
            if (nums[i] < 0) {
                freq[nums[i] + 50]++;
            }

            result[i-k+1] = getXthSmallestNegative(freq, x);
        }

        return result;
    }

    private int getXthSmallestNegative(int[] freq, int x) {
        int count = 0;
        for (int i = 0; i < 50; i++) { // from -50 to -1
            count += freq[i];
            if (count >= x) {
                return i - 50; // Convert index back to actual number
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        BeautyOfSubarrays sol = new BeautyOfSubarrays();

        System.out.println(Arrays.toString(sol.getSubarrayBeauty(new int[]{1, -1, -3, -2, 3}, 3, 2))); // [-1, -2, -2]
        System.out.println(Arrays.toString(sol.getSubarrayBeauty(new int[]{-1, -2, -3, -4, -5}, 2, 2))); // [-1, -2, -3, -4]
        System.out.println(Arrays.toString(sol.getSubarrayBeauty(new int[]{-3, 1, 2, -3, 0, -3}, 2, 1))); // [-3, 0, -3, -3, -3]
    }
}