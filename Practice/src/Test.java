import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import LeetCode.KthLargest;
import com.google.common.collect.ImmutableList;

public class Test {
    public static void main(String[] args) {
        KthLargest list = new KthLargest(4 , new int[]{7, 7, 7, 7, 8, 3});
        System.out.println(list.add(2));
        System.out.println(list.add(10));
        System.out.println(list.add(9));
        System.out.println(list.add(9));
        //System.out.println(list.add(3));
    }


}
