package LeetCode;

public class LongestSubstringWithKRepeats {
    public int longestSubstring(String s, int k) {
        return helper(s, 0, s.length(), k);
    }

    private int helper(String s, int start, int end, int k) {
        if (end - start < k) return 0;

        // Count frequencies
        int[] freq = new int[26];
        for (int i = start; i < end; i++) {
            freq[s.charAt(i) - 'a']++;
        }

        // Try to find a split point
        for (int mid = start; mid < end; mid++) {
            if (freq[s.charAt(mid) - 'a'] < k) {
                int midNext = mid + 1;
                // Skip all bad chars
                while (midNext < end && freq[s.charAt(midNext) - 'a'] < k) {
                    midNext++;
                }
                return Math.max(
                        helper(s, start, mid, k),
                        helper(s, midNext, end, k)
                );
            }
        }

        // If all characters in this substring are valid
        return end - start;
    }

    public static void main(String[] args) {
        LongestSubstringWithKRepeats sol = new LongestSubstringWithKRepeats();

        System.out.println(sol.longestSubstring("aaabb", 3));   // 3
        System.out.println(sol.longestSubstring("ababbc", 2));  // 5
        System.out.println(sol.longestSubstring("ababacb", 3)); // 0
    }
}
