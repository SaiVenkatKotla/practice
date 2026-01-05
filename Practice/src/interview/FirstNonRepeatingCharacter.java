package interview;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeatingCharacter {

    public static void main(String[] args) {
        String s = "abcddedffgshi";
        Optional<Character> firstChar = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(character -> character, LinkedHashMap::new,Collectors.counting()))
                .entrySet().stream()
                .filter(entry-> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst();

        System.out.println("First non-repeating character is " + firstChar.orElseThrow( () -> new RuntimeException("No such element found exception")));
    }
}
