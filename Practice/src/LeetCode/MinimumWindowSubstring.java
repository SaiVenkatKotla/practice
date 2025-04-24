package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        Map<Character, Integer> targetCount = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetCount.put(c, targetCount.getOrDefault(c, 0) + 1);
        }

        int required = targetCount.size();
        int formed = 0;
        Map<Character, Integer> windowCount = new HashMap<>();

        int l = 0, r = 0;
        int[] ans = {-1, 0, 0}; // length, left, right

        while (r < s.length()) {
            char c = s.charAt(r);
            windowCount.put(c, windowCount.getOrDefault(c, 0) + 1);

            if (targetCount.containsKey(c) && windowCount.get(c).intValue() == targetCount.get(c).intValue()) {
                formed++;
            }

            // Try and contract the window
            while (l <= r && formed == required) {
                c = s.charAt(l);

                // Save the smallest window
                if (ans[0] == -1 || r - l + 1 < ans[0]) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }

                windowCount.put(c, windowCount.get(c) - 1);
                if (targetCount.containsKey(c) && windowCount.get(c).intValue() < targetCount.get(c).intValue()) {
                    formed--;
                }

                l++;
            }

            r++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }

    public static void main(String[] args) {
        System.out.println(new MinimumWindowSubstring().minWindow("ADOBECODEBANC", "ABC")); // Output: "BANC"
        System.out.println(new MinimumWindowSubstring().minWindow("a", "a"));               // Output: "a"
        System.out.println(new MinimumWindowSubstring().minWindow("a", "aa"));
    }
}

