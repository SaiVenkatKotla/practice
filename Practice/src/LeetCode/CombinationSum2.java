package LeetCode;

import java.util.*;

public class CombinationSum2 {
    public static void main(String[] args) {
        int[] candidates = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        int target = 30;
        combinationSum2(candidates, target).forEach(System.out::println);
    }

    private static List<List<Integer>> combinationSum2(int[] candidates, int target){
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(candidates);
        backtrack2(result, new ArrayList<>() , candidates, target, 0);
        return  new ArrayList<>(result);
    }

    private static void backtrack2(Set<List<Integer>> result, List<Integer> current, int[] candidates, int target, int start){
        if(target == 0){
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i = start; i<candidates.length; i++){
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            if(candidates[i] > target) break;
            current.add(candidates[i]);
            backtrack2(result, current, candidates, target - candidates[i] , i+1);
            current.removeLast();
        }
    }
}
