package kadanealgorithm;

public class KadaneCircular {

    public static void main(String[] args) {
        int[] arr = {11, 10, -5, -2, 4};
        int maxSum = maxCircularSubArraySum(arr);
        System.out.println("Maximum circular subarray sum: " + maxSum); // Output: 30
    }

    private static int maxCircularSubArraySum(int[] arr) {
        int baseMax = KadanesSum(arr);
        int maxWrap = 0, totalSum = 0;

        for (int i = 0; i < arr.length; i++) {
            totalSum += arr[i];
            arr[i] = -arr[i];
        }
        maxWrap = totalSum + KadanesSum(arr);
        return Math.max(maxWrap, baseMax);
    }

    private static int KadanesSum(int[] arr) {
        int currentMax = 0;
        int globalMax = Integer.MIN_VALUE;

        for (int n : arr) {
            currentMax = Math.max(n, currentMax +n );
            globalMax = Math.max(currentMax, globalMax);
        }
        return globalMax;
    }

}
