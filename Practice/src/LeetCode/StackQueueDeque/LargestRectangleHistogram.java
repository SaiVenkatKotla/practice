package LeetCode.StackQueueDeque;

import java.util.Stack;

public class LargestRectangleHistogram {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // Sentinel
        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            // Maintain increasing stack
            while (stack.peek() != -1 && heights[i] < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = i - stack.peek() - 1; // distance between current and new top
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }

        // Remaining bars in stack
        while (stack.peek() != -1) {
            int height = heights[stack.pop()];
            int width = heights.length - stack.peek() - 1;
            maxArea = Math.max(maxArea, height * width);
        }

        return maxArea;
    }

    // Test
    public static void main(String[] args) {
        LargestRectangleHistogram solver = new LargestRectangleHistogram();
        //System.out.println(solver.largestRectangleArea(new int[]{2,1,5,6,2,3})); // Output: 10
        System.out.println(solver.largestRectangleArea(new int[]{2,4,5,6}));         // Output: 4
    }
}

