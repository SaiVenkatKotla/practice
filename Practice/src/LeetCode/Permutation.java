package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        permutate(nums).forEach(System.out::println);
    }

    private static List<List<Integer>> permutate(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        permutateNumbers(result, new ArrayList<>(), nums, used);
        return result;
    }


    private static void permutateNumbers(List<List<Integer>> result,List<Integer> current, int[] nums, boolean[] used) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i = 0 ; i< nums.length ;i ++){
            if(used[i]) continue;
            current.add(nums[i]);
            used[i] = true;
            permutateNumbers(result, current, nums, used);
            used[i] = false;
            current.removeLast();
        }
    }
}
