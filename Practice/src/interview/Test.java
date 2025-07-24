package interview;

import java.util.*;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {
        int[] input = {2, 4, 1, 4, 3, 4, 1, 4, 4, 2, 3, 2, 1};
        Test t = new Test();
        int[] result = t.freqNumber(input);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + ",");
        }
    }

    private int[] freqNumber(int[] nums) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        int[] result = new int[nums.length];
        for (int n : nums) {
            if (freqMap.containsKey(n)) {
                freqMap.put(n, freqMap.get(n) + 1);
            } else {
                freqMap.put(n, 1);
            }
        }
        Map<Integer, Integer> sortedMap = freqMap.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (v1, v2) -> v1,
                        LinkedHashMap::new
                ));

        int index = 0;
        for (Map.Entry<Integer, Integer> entry : sortedMap.entrySet()) {
            int repeat = entry.getValue() - 1;
            while (repeat >= 0) {
                result[index++] = entry.getKey();
                repeat--;
            }
        }
        return result;
    }

}