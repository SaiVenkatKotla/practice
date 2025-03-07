package SlidingWindow;

import java.util.Arrays;

public class SlidingWindowExample {

    private static int maxSumSubarray(int[] arr, int k){
        int maxSum =0, currentSum=0;
        currentSum = Arrays.stream(Arrays.copyOfRange(arr,0,k)).sum();
        maxSum = currentSum;
        for(int i=k;i<arr.length;i++){
            currentSum +=arr[i] - arr[i-k];
            maxSum  = Math.max(currentSum, maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 4;
        System.out.println("Maximum sum of subarray of size " + k + ": " + maxSumSubarray(arr, k));
    }
}
