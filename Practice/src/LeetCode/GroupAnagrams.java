package LeetCode;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Map sorted word to list of anagrams
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            // Convert string to char array and sort
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars); // Sorted string is the key

            // Group all anagrams under the same key
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        GroupAnagrams ga = new GroupAnagrams();

        String[] input1 = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(ga.groupAnagrams(input1));

        String[] input2 = {""};
        System.out.println(ga.groupAnagrams(input2));

        String[] input3 = {"a"};
        System.out.println(ga.groupAnagrams(input3));
    }
}

