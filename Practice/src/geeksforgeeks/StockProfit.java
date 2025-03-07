package geeksforgeeks;

public class StockProfit {

    /**
     * Calculates the maximum profit by buying and selling stocks multiple times.
     *
     * @param prices the array of stock prices on each day
     * @return the maximum profit
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int maxProfit = 0;

        // Loop through the array and calculate profit for every consecutive increase
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        StockProfit sp = new StockProfit();

        // Example 1
        int[] arr1 = {100, 180, 260, 310, 40, 535, 695};
        System.out.println(sp.maxProfit(arr1)); // Output: 865

        // Example 2
        int[] arr2 = {4, 2, 2, 2, 4};
        System.out.println(sp.maxProfit(arr2)); // Output: 2

        // Example 3
        int[] arr3 = {4, 2};
        System.out.println(sp.maxProfit(arr3)); // Output: 0
    }
}
