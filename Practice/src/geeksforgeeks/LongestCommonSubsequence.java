package geeksforgeeks;

import java.util.Arrays;

public class LongestCommonSubsequence {

    // Method to find the length of the longest common subsequence
    public static int lcs(String s1, String s2) {
        int[][] t = new int[s1.length() + 1][s2.length() + 1];
        Arrays.fill(t[0], 0);
        for (int i = 1; i < s1.length() + 1; i++) {
            for (int j = 0; j < s2.length() + 1; j++) {
                if (j == 0) {
                    t[i][j] = 0;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                } else {
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
                }
            }
        }
        return t[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(lcs("ABCDGH", "AEDFHR")); // Expected Output: 3
        System.out.println(lcs("ABC", "AC")); // Expected Output: 2
        System.out.println(lcs("XYZW", "XYWZ")); // Expected Output: 3
        System.out.println(lcs("XAYBZCWD", "XABYWZCD")); // Expected Output: 4

    }
}

