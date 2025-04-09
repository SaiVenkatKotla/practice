import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.google.common.collect.ImmutableList;

public class Test {
    public static void main(String[] args) {
        String Q = "abc";
        String P = "bcd";

        TreeMap<Character, Integer> countMap = new TreeMap<>();

        for(char c : P.toCharArray()){
            if(countMap.containsKey(c)){
                countMap.put(c, countMap.get(c)+1);
            }else{
                countMap.put(c, 0);
            }
        }

        for(char c : Q.toCharArray()){
            if(countMap.containsKey(c)){
                countMap.put(c, countMap.get(c)+1);
            }else{
                countMap.put(c, 0);
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        list.addAll(countMap.values());
        list.sort((e1 , e2) -> e2.compareTo(e1));
    }


}
