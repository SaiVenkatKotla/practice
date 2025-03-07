package geeksforgeeks;

import java.lang.reflect.Array;
import java.util.*;

public class UniquePairsFinder {

    // Method to return unique pairs

    /**
     * @param arr
     * @return public static ArrayList<ArrayList<Integer>> getPairs(int[] arr) {
     * Arrays.sort(arr);
     * Set<ArrayList<Integer>> resultSet = new LinkedHashSet<>();
     * int right=arr.length-1, left = 0;
     * while(left<right){
     * ArrayList<Integer> results ;
     * if(arr[left] + arr[right] == 0){
     * results = new ArrayList<>(Arrays.asList(arr[left],arr[right]));
     * resultSet.add(results);
     * left++;
     * right--;
     * }else if(arr[left] < -1*arr[right]){
     * left++;
     * }else{
     * right--;
     * }
     * }
     * ArrayList<ArrayList<Integer>> result = new ArrayList<>(resultSet);
     * return result;
     * }
     */

    public static ArrayList<ArrayList<Integer>> getPairs(int[] arr) {
        Set<ArrayList<Integer>> resultSet = new LinkedHashSet<>();
        Set<Integer> seen = new HashSet<>();

        for (int n : arr) {
            int target = -n;
            if (seen.contains(target)) {
                ArrayList<Integer> list = new ArrayList<>(Arrays.asList(n, -n));
                Collections.sort(list);
                resultSet.add(list);
            }
            seen.add(n);
        }
        return new ArrayList<>(resultSet);
    }

    // Main method for testing the examples
    public static void main(String[] args) {
        // Example 1
        int[] arr1 = {-1, 0, 1, 2, -1, -4};
        ArrayList<ArrayList<Integer>> result1 = getPairs(arr1);
        System.out.println("Input: arr = " + java.util.Arrays.toString(arr1));
        System.out.println("Output: " + result1);

        // Example 2
        int[] arr2 = {6, 1, 8, 0, 4, -9, -1, -10, -6, -5};
        ArrayList<ArrayList<Integer>> result2 = getPairs(arr2);
        System.out.println("Input: arr = " + java.util.Arrays.toString(arr2));
        System.out.println("Output: " + result2);
    }
}
