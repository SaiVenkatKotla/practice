import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.google.common.collect.ImmutableList;

public class Test {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Apple","Banana","Cherry", "Banana");
        Integer totalLength = words.stream().collect(Collectors.mapping(String::length , Collectors.summingInt(Integer::intValue)));
        words.stream().map(String::length).mapToDouble(Integer::doubleValue).forEach(System.out::println);
        System.out.println(totalLength);
    }


}
