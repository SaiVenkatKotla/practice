package kadanealgorithm;

public class KadaneWithKLength {

    public static void main(String[] args) {
        int[] arr = {1, 2, -3, -4, 5, 6};
        int k = 2;
        int maxSum = maxSubArraySumKLength(arr, k);
        System.out.println("Maximum subarray sum with at least " + k + " elements: " + maxSum); // Output: 11
    }

    private static int maxSubArraySumKLength(int[] arr, int k) {
        int n = arr.length;
        if (k > n) {
            return Integer.MIN_VALUE;
        }
        int currentSum = 0;
        for (int i = 0; i < k; i++) {
            currentSum += arr[i];
        }
        int prevSum = currentSum;
        int maxSum = currentSum;
        for (int i = k; i < n; i++) {
            prevSum += arr[i] - arr[i - k];
            currentSum = Math.max(prevSum, currentSum + arr[i]);
            maxSum = Math.max(currentSum, maxSum);
        }

        return maxSum;
    }
}
