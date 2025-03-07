package geeksforgeeks;

import java.util.Arrays;

public class TowerHeightAdjuster {

    public static void main(String[] args) {
        TowerHeightAdjuster adjuster = new TowerHeightAdjuster();

        // Example 1
        int[] arr1 = {1, 5, 8, 10};
        int k1 = 2;
        System.out.println("Output for Example 1: " + adjuster.getMinDiff(arr1, k1)); // Expected Output: 5

        // Example 2
        int[] arr2 = {3, 9, 12, 16, 20};
        int k2 = 3;
        System.out.println("Output for Example 2: " + adjuster.getMinDiff(arr2, k2)); // Expected Output: 11

        int[] arr3 = {1, 8, 10, 6, 4, 6, 9, 1};  //1,1,4,6,6,8,9,10
        int k3 = 7;
        System.out.println("Output for Example 2: " + adjuster.getMinDiff(arr3, k3)); // Expected Output: 9

    }

    private int getMinDiff(int[] arr, int k) {
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){
           if(arr[i]-k <0){
               arr[i]+=k;
           }else{
               arr[i]-=k;
           }
       }
       Arrays.sort(arr);
       return arr[arr.length-1] - arr[0];
    }
}
