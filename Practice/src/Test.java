import java.util.*;
import java.util.concurrent.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) {
        System.out.println(numSubarrayProductLessThanK(new int[]{10, 5, 2, 6, 8}, 200));
        System.out.println(numSubarrayProductLessThanK(new int[]{1, 2, 3}, 0));
        System.out.println(numSubarrayProductLessThanK(new int[]{10, 5, 2, 6, 8}, 200));
        String.valueOf(10);
    }

    private static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int prod = 1, result = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];
            while (prod >= k) {
                prod /= nums[left++];
            }
            result += right - left + 1;
        }
        return result;
    }
}
