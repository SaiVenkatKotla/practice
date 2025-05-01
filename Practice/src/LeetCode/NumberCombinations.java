package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class NumberCombinations {
    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        combine(n, k).forEach(System.out::println);
    }

    private static List<List<Integer>> combine(int n, int k){
        List<List<Integer>> result = new ArrayList<>();
        getCombinedNumbers(result, new ArrayList<>(),n, k, 1);
        return result;
    }

    private static void getCombinedNumbers(List<List<Integer>> result, List<Integer> current, int n , int k , int start){
        if(current.size() == k){
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i = start; i<=n ;i++){
            current.add(i);
            getCombinedNumbers(result, current, n, k, i + 1);
            current.removeLast();
        }
    }
}
