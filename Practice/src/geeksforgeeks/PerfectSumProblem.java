package geeksforgeeks;

public class PerfectSumProblem {

    // Method to count subsets whose sum equals the target
    public int perfectSum(int[] nums, int target) {
        int[][] t = new int[nums.length + 1][target + 1];
        t[0][0] = 1;
        for (int i = 1; i < nums.length + 1; i++) {
            for (int j = 0; j < target + 1; j++) {
                if (j == 0)
                    t[i][j] = 1;
                if (nums[i - 1] <= j) {
                    t[i][j] = t[i - 1][j - nums[i - 1]] + t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }
        return t[nums.length][target]; // Placeholder return
    }

    public static void main(String[] args) {
        PerfectSumProblem psp = new PerfectSumProblem();

        // Example 1
        int[] arr1 = {5, 2, 3, 10, 6, 8};
        int target1 = 10;
        int result1 = psp.perfectSum(arr1, target1);
        System.out.println("Input: arr = " + java.util.Arrays.toString(arr1) + ", target = " + target1);
        System.out.println("Output: " + result1);

        // Example 2
        int[] arr2 = {2, 5, 1, 4, 3};
        int target2 = 10;
        int result2 = psp.perfectSum(arr2, target2);
        System.out.println("Input: arr = " + java.util.Arrays.toString(arr2) + ", target = " + target2);
        System.out.println("Output: " + result2);

        // Example 3
        int[] arr3 = {5, 7, 8};
        int target3 = 3;
        int result3 = psp.perfectSum(arr3, target3);
        System.out.println("Input: arr = " + java.util.Arrays.toString(arr3) + ", target = " + target3);
        System.out.println("Output: " + result3);

        // Example 4
        int[] arr4 = {35, 2, 8, 22};
        int target4 = 0;
        int result4 = psp.perfectSum(arr4, target4);
        System.out.println("Input: arr = " + java.util.Arrays.toString(arr4) + ", target = " + target4);
        System.out.println("Output: " + result4);
    }
}

