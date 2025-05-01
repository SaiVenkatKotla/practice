package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {
        int[] candidates = {2, 3, 5};
        int target = 8;
        combinationSum(candidates, target).stream().flatMap(Collection::stream).forEach(System.out::println);
    }

    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> current, int[] candidates, int target, int start){
        if(target == 0){
            result.add(new ArrayList<>(current));
            return ;
        }

        for(int i = start  ; i<candidates.length ; i++){
            if(candidates[i] > target ) break;

            current.add(candidates[i]);
            backtrack(result, current, candidates, target - candidates[i] , i);
            current.removeLast();
        }
    }



}
