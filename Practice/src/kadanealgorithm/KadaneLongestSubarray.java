package kadanealgorithm;

import java.util.HashMap;
import java.util.Map;

public class KadaneLongestSubarray {

    public static void main(String[] args) {
        int[] nums = {10, 5, 2, 7, 1, 9};
        int k = 15;
        System.out.println("Longest Subarray Length with Sum " + k + ": " + longestSubarraySumK(nums, k));
    }

    private static int longestSubarraySumK(int[] nums, int k) {
        HashMap<Integer , Integer> hashMap = new HashMap<>();
        int maxLen = 0, sum = 0;
        for(int i  = 0 ; i<nums.length ; i++){
            sum+= nums[i];

            if(sum == k){
                maxLen = i+1;
            }

            if(hashMap.containsKey(sum- k)){
                maxLen = Math.max(maxLen,i -  hashMap.get(sum - k));
            }

            hashMap.putIfAbsent(sum , i);
        }

        return maxLen;
    }
}
