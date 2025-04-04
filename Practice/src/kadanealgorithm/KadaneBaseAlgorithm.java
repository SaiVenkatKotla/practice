package kadanealgorithm;

/**
 * kadane algorithm is used to find the maximum sum of subarray
 * in a given array
 */
public class KadaneBaseAlgorithm {

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int maxSum = maxSubArraySum(arr);
        System.out.println("Maximum subarray sum: " + maxSum); // Output: 6
    }

    private static int maxSubArraySum(int[] arr) {
        int currentMax = 0;
        int globalMax = Integer.MIN_VALUE;

        for (int num : arr) {
            currentMax = Math.max(num, num + currentMax);
            globalMax = Math.max(currentMax, globalMax);
        }
        return globalMax;
    }
}
