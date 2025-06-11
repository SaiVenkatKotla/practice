package LeetCode.StackQueueDeque;

import java.util.Stack;

public class TrappingRainWater {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int water = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                // Left side is smaller
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    water += leftMax - height[left];
                }
                left++;
            } else {
                // Right side is smaller
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }
                right--;
            }
        }

        return water;
    }

    // Test
    public static void main(String[] args) {
        TrappingRainWater solver = new TrappingRainWater();
        System.out.println(solver.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1})); // 6
        System.out.println(solver.trap(new int[]{4,2,0,3,2,5})); // 9
    }
}

