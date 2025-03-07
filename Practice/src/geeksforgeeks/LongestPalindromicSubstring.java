package geeksforgeeks;

public class LongestPalindromicSubstring {

    // Method to find the longest palindromic substring
    public static String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);

            int len = Math.max(len1, len2);
            if (len > end + 1 - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    // Main method for testing
    public static void main(String[] args) {
        // Example 1
        String s1 = "aaaabbaa";
        System.out.println(longestPalindrome(s1)); // Expected output: "aabbaa"

        // Example 2
        String s2 = "abc";
        System.out.println(longestPalindrome(s2)); // Expected output: "a"

        // Example 3
        String s3 = "abacdfgdcaba";
        System.out.println(longestPalindrome(s3)); // Expected output: "aba"


        String s4 = "bswrhxboawtdfqggqfdtwyypwnssnwpyyaobxhrwsb";
        System.out.println(longestPalindrome(s4));
    }
}