package geeksforgeeks;

import java.lang.reflect.Array;
import java.util.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RepeatingElementsFinder {

    public List<Integer> findDuplicates(int[] arr) {
        List<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int n : arr) {
            count.merge(n, 1, Integer::sum);
        }
        Arrays.stream(arr)
                .filter(n -> count.get(n) > 1).distinct().boxed().forEach(System.out::println);
        return result;
    }

    public static void main(String[] args) {
        int[] inputArray1 = {2, 3, 1, 2, 3};
        int[] inputArray2 = {0, 3, 1, 2};
        int[] inputArray3 = {2};

        RepeatingElementsFinder finder = new RepeatingElementsFinder();
        System.out.println("Repeating elements (Array 1): " + finder.findDuplicates(inputArray1));
        System.out.println("Repeating elements (Array 2): " + finder.findDuplicates(inputArray2));
        System.out.println("Repeating elements (Array 3): " + finder.findDuplicates(inputArray3));
    }
}

