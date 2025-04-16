package LeetCode;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class kthLargestNumber {
    public static void main(String[] args) {
        String[] nums = {"623986800","3","887298","695","794","6888794705","269409","59930972","723091307","726368","8028385786","378585"};
        int k = 4;
        System.out.println("answer:"+methods(nums, k));
    }

    private static String methods(String[] nums, int k) {
        Arrays.sort(nums, (a, b) -> {
            if (a.length() != b.length()) {
                return b.length() - a.length();
            }
            return b.compareTo(a);
        });
        return nums[k-1];
    }
}
