package geeksforgeeks;

public class PowerOfTwoChecker {

    /**
     * Checks if a given non-negative integer is a power of two.
     *
     * @param n The integer to check.
     * @return true if n is a power of two, false otherwise.
     */
    public static boolean isPowerofTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    // Main method to test the isPowerofTwo function with examples.
    public static void main(String[] args) {
        // Test cases
        int[] testCases = {8, 98, 1};
        for (int testCase : testCases) {
            System.out.println("Input: " + testCase);
            System.out.println("Output: " + isPowerofTwo(testCase));
            System.out.println();
        }
    }
}