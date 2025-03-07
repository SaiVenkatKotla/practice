import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        //IntStream.range(0, 100).filter(i->i%2==0).forEach(System.out::println);

        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        List<Integer> squares = numbers.stream()
                .map(n -> n * n)
                .toList();

        squares.forEach(System.out::println);


        Optional<String> opt = Optional.of("venkat");
        Optional<String> VENKAT = opt.map(String::toUpperCase);
        System.out.println(VENKAT.get());
        Optional<String> venkat = VENKAT.map(String::toLowerCase);
        System.out.println(venkat.orElse(VENKAT.get()));

        venkat.filter(v -> v.endsWith("t")).ifPresent(System.out::println);

        StringBuilder sb = new StringBuilder("Venkat");
        sb.append(" Kotla");
        System.out.println(sb);
        sb.insert(0, "Sai");
        System.out.println(sb);
        sb.delete(0,3);
        System.out.println(sb);
        sb.replace(0,6,"Sandeep");
        System.out.println(sb);
        sb.reverse();
        System.out.println(sb);
        System.out.println("Capacity:"+sb.capacity());
        System.out.println("Length:"+sb.length());
        sb.append("This is a longer String");
        System.out.println("New Capacity:"+sb.capacity());
        System.out.println("New Length:"+sb.length());
        String s = sb.toString();
        System.out.println(s);
        /*sb = new StringBuilder();
        System.out.println("New Capacity:"+sb.capacity());
        System.out.println("New Length:"+sb.length());*/


    }
}