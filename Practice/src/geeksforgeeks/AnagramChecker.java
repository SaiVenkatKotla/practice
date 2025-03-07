package geeksforgeeks;

public class AnagramChecker {

    /**
     * Method to check if two strings are anagrams of each other.
     *
     * @param s1 The first string.
     * @param s2 The second string.
     * @return true if the strings are anagrams, false otherwise.
     */
    public static boolean areAnagrams(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        int[] frequency = new int[26];
        for (char c : s1.toCharArray()) {
            frequency[c - 'a']++;
        }
        for (char c : s2.toCharArray()) {
            frequency[c - 'a']--;
        }

        for (int j : frequency) {
            if (j != 0)
                return false;
        }
        return true;
    }

    // Main method to test the implementation with examples
    public static void main(String[] args) {
        // Example 1
        String s1 = "geeks";
        String s2 = "kseeg";
        boolean result1 = areAnagrams(s1, s2);
        System.out.println("Example 1: " + result1); // Expected output: true

        // Example 2
        String s3 = "allergy";
        String s4 = "allergic";
        boolean result2 = areAnagrams(s3, s4);
        System.out.println("Example 2: " + result2); // Expected output: false

        // Example 3
        String s5 = "g";
        String s6 = "g";
        boolean result3 = areAnagrams(s5, s6);
        System.out.println("Example 3: " + result3); // Expected output: true

        // Example 4
        String s7 = "listen";
        String s8 = "silent";
        boolean result4 = areAnagrams(s7, s8);
        System.out.println("Example 4: " + result4); // Expected output: true

        // Example 5
        String s9 = "triangle";
        String s10 = "integral";
        boolean result5 = areAnagrams(s9, s10);
        System.out.println("Example 5: " + result5); // Expected output: true
    }
}