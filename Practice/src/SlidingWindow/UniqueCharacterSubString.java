package SlidingWindow;

import java.util.HashSet;

public class UniqueCharacterSubString {


    public static void main(String[] args) {
        String input = "abcabcbb";
        System.out.println("Input: " + input);
        System.out.println("Length of longest substring without repeating characters: " + lengthOfLongestSubstring(input));

        input = "bbbbb";
        System.out.println("\nInput: " + input);
        System.out.println("Length of longest substring without repeating characters: " + lengthOfLongestSubstring(input));

        input = "pwwkew";
        System.out.println("\nInput: " + input);
        System.out.println("Length of longest substring without repeating characters: " + lengthOfLongestSubstring(input));
    }

    private static int lengthOfLongestSubstring(String input) {
        HashSet<Character> charSet = new HashSet<>();
        int start = 0, maxLength = 0;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            while (charSet.contains(c)) {
                charSet.remove(input.charAt(start));
                start++;
            }

            charSet.add(c);
            maxLength = Math.max(maxLength, i - start + 1);
        }

        return maxLength;
    }
}
