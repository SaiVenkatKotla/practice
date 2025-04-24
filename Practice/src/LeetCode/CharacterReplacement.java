package LeetCode;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class CharacterReplacement {
    private static int characterReplacement(String s, int k) {
        int[] freq = new int[26];  // Frequency array for A-Z
        int left = 0;
        int maxFreq = 0;           // Max frequency of any character in the current window
        int result = 0;

        for (int right = 0; right < s.length(); right++) {
            freq[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);

            // Window size is (right - left + 1), if we need to replace more than k characters
            // then shrink the window from the left
            if ((right - left + 1) - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            // Always calculate result as the size of the current valid window
            result = Math.max(result, right - left + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(characterReplacement("AABABBA",1));
        System.out.println(characterReplacement("ABAB", 2));
    }
}
