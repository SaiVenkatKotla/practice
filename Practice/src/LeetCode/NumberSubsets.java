package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberSubsets {

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        subsets(nums).forEach(System.out::println);
    }

    private static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        getNumberSubsets(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private static void getNumberSubsets(List<List<Integer>> result, List<Integer> current, int[] nums, int start) {
        result.add(new ArrayList<>(current));
        for(int i = start ; i< nums.length ; i++){
            current.add(nums[i]);
            getNumberSubsets(result, current, nums, i+1);
            current.removeLast();
        }

    }
}
