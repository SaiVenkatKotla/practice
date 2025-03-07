package geeksforgeeks;

import java.util.Arrays;

public class CoinChange {

    /**
     * Finds the number of ways to make the target sum using the given coin denominations.
     *
     * @param coins Array representing different denominations of coins.
     * @param sum   The target sum to achieve.
     * @return The number of ways to make the target sum.
     */
    public int count(int[] coins, int sum) {
        int[][] arr = new int[coins.length + 1][sum + 1];
        Arrays.fill(arr[0], 0);
        for(int i =0 ;i<coins.length+1;i++){
            arr[i][0] = 1;
        }
        for (int i = 1; i < coins.length + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (j >= i)
                    arr[i][j] =  Math.max(1+arr[i - 1][j], arr[i][j - 1]);
                else
                    arr[i][j] = arr[i - 1][j];
            }
        }
        return arr[coins.length][sum];
    }

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();

        // Example 1
        int[] coins1 = {1, 2, 3};
        int sum1 = 4;
        System.out.println("Number of ways: " + coinChange.count(coins1, sum1)); // Output: 4

        // Example 2
        int[] coins2 = {2, 5, 3, 6};
        int sum2 = 10;
        System.out.println("Number of ways: " + coinChange.count(coins2, sum2)); // Output: 5

        // Example 3
        int[] coins3 = {5, 10};
        int sum3 = 3;
        System.out.println("Number of ways: " + coinChange.count(coins3, sum3)); // Output: 0
    }
}
