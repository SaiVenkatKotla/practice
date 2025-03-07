package geeksforgeeks;

import java.util.*;

public class NextGreaterElement {

    /**
     * Method to find the next greater element for each element in the array.
     *
     * @param arr The input array of integers.
     * @return An ArrayList containing the next greater element for each element in the array.
     */
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        if (arr == null || arr.length == 0 || arr.length == 1)
            return new ArrayList<>(Arrays.asList(-1));
        ArrayList<Integer> list = new ArrayList<>();
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++)
            list.add(-1);
        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty() && arr[i] >= stack.peek())
                stack.pop();

            if (!stack.isEmpty())
                list.set(i, stack.peek());

            stack.push(arr[i]);
        }
        return list;
    }

    // Main method to test the implementation with examples
    public static void main(String[] args) {
        NextGreaterElement solution = new NextGreaterElement();

        // Example 1
        int[] arr1 = {1, 3, 2, 4};
        ArrayList<Integer> result1 = solution.nextLargerElement(arr1);
        System.out.println("Example 1: " + result1); // Expected output: [3, 4, 4, -1]

        // Example 2
        int[] arr2 = {6, 8, 0, 1, 3};
        ArrayList<Integer> result2 = solution.nextLargerElement(arr2);
        System.out.println("Example 2: " + result2); // Expected output: [8, -1, 1, 3, -1]

        // Example 3
        int[] arr3 = {10, 20, 30, 50};
        ArrayList<Integer> result3 = solution.nextLargerElement(arr3);
        System.out.println("Example 3: " + result3); // Expected output: [20, 30, 50, -1]

        // Example 4
        int[] arr4 = {50, 40, 30, 10};
        ArrayList<Integer> result4 = solution.nextLargerElement(arr4);
        System.out.println("Example 4: " + result4); // Expected output: [-1, -1, -1, -1]

        // Example 5 (New Input)
        int[] arr5 = {46, 90, 7, 46, 90, 7};
        ArrayList<Integer> result5 = solution.nextLargerElement(arr5);
        System.out.println("Example 5: " + result5); // Expected output: [90, -1, 46, 90, -1, -1]
    }
}