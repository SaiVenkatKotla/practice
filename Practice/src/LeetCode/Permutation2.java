package LeetCode;

import java.util.*;

public class Permutation2 {

    public static void main(String[] args) {
        int[] nums = {1, 1 , 2};
        permuteUnique(nums).forEach(System.out::println);
    }


    private static List<List<Integer>> permuteUnique(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        permutateNumbers2(result , new ArrayList<>(), used, nums);
        return new ArrayList<>(result);
    }

    private static void permutateNumbers2(List<List<Integer>> result, List<Integer> current, boolean[] used, int[] nums) {
        if(current.size() == nums.length){
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i= 0;i<nums.length ; i++){
            if(i> 0 && nums[i] == nums[i-1] &&  !used[i-1]) continue;
            if(used[i]) continue;
            current.add(nums[i]);
            used[i] = true;
            permutateNumbers2(result, current, used, nums);
            used[i] = false;
            current.removeLast();
        }
    }


}
