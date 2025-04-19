package LeetCode;

import java.util.*;

public class KthSmallestTrimmedNumber {

    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
       int[] result = new int[queries.length];
       List<StringIndexPair> trimmedList ;

       for(int i = 0; i<queries.length ;i++){
           int index = queries[i][0] -1;
           int trim = queries[i][1];
            trimmedList =  new ArrayList<>();
           for(int j = 0;j<nums.length;j++){
               trimmedList.add(new StringIndexPair(nums[j].substring(nums[j].length()-trim), j));
           }

           Collections.sort(trimmedList, (a, b) -> {
               if(!a.str.equals(b.str)){
                   return a.str.compareTo(b.str);
               }

               return a.index.compareTo(b.index);
           });

           result[i] = trimmedList.get(index).index;
       }
       return result;
    }

    static class StringIndexPair {
        private String str;
        private Integer index;

        public StringIndexPair(String str, Integer index) {
            this.str = str;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        KthSmallestTrimmedNumber solution = new KthSmallestTrimmedNumber();

        String[] nums1 = {"102", "473", "251", "814"};
        int[][] queries1 = {{1, 1}, {2, 3}, {4, 2}, {1, 2}};
        System.out.println(Arrays.toString(solution.smallestTrimmedNumbers(nums1, queries1))); // [2, 2, 1, 0]

        String[] nums2 = {"24", "37", "96", "04"};
        int[][] queries2 = {{2, 1}, {2, 2}};
        System.out.println(Arrays.toString(solution.smallestTrimmedNumbers(nums2, queries2))); // [3, 0]
    }
}

