import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Test {

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        List<Integer> even = IntStream.range(0,1000000).filter(n -> n%2 == 0).boxed().toList();
        System.out.println(System.currentTimeMillis());
    }

}
