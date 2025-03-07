package geeksforgeeks;

import java.util.*;

public class FractionalKnapsack {

    // Class to represent an item with its value, weight, and value-to-weight ratio
    static class Item {
        int value;
        int weight;
        double ratio;

        Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
            this.ratio = (double) value / weight;
        }
    }

    public static double getMaxValue(int[] val, int[] wt, int capacity) {
        int n = val.length;

        // Create an array of items with value, weight, and ratio
        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            items[i] = new Item(val[i], wt[i]);
        }

        // Sort items in descending order of value-to-weight ratio
        Arrays.sort(items, (a, b) -> Double.compare(b.ratio, a.ratio));

        double totalValue = 0.0;
        int remainingCapacity = capacity;

        // Iterate through the sorted items
        for (Item item : items) {
            if (remainingCapacity == 0) break;

            if (item.weight <= remainingCapacity) {
                // Take the full item
                totalValue += item.value;
                remainingCapacity -= item.weight;
            } else {
                // Take the fractional part of the item
                totalValue += item.ratio * remainingCapacity;
                remainingCapacity = 0; // Knapsack is now full
            }
        }

        // Return the total maximum value rounded to 6 decimal places
        return Math.round(totalValue * 1e6) / 1e6;
    }

    public static void main(String[] args) {
        // Example usage
        int[] val1 = {60, 100, 120};
        int[] wt1 = {10, 20, 30};
        int capacity1 = 50;

        int[] val2 = {60, 100};
        int[] wt2 = {10, 20};
        int capacity2 = 50;

        int[] val3 = {10, 20, 30};
        int[] wt3 = {5, 10, 15};
        int capacity3 = 100;

        System.out.println("Maximum Value 1: " + getMaxValue(val1, wt1, capacity1)); // Output: 240.000000
        System.out.println("Maximum Value 2: " + getMaxValue(val2, wt2, capacity2)); // Output: 160.000000
        System.out.println("Maximum Value 3: " + getMaxValue(val3, wt3, capacity3)); // Output: 60.000000
    }
}
