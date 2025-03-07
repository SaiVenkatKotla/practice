package geeksforgeeks;

public class MinimumJumps {

    public static int minJumps(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int n = arr.length;
        if (n == 1) {
            return 0; // Already at the end
        }

        if (arr[0] == 0) {
            return -1; // Can't move anywhere
        }

        int maxReach = arr[0]; // The maximum index that can be reached
        int steps = arr[0];   // Steps we can still take
        int jumps = 1;        // Number of jumps taken

        for (int i = 1; i < n; i++) {
            // If we've reached the end of the array
            if (i == n - 1) {
                return jumps;
            }

            // Update maxReach and steps
            maxReach = Math.max(maxReach, i + arr[i]);
            steps--;

            // If steps become zero, we must jump
            if (steps == 0) {
                jumps++;

                // Check if the current index is beyond maxReach
                if (i >= maxReach) {
                    return -1;
                }

                // Reinitialize steps to the number of steps we can take from i
                steps = maxReach - i;
            }
        }

        return -1; // If we never reach the end
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        System.out.println("Minimum jumps to reach the end: " + minJumps(arr));

        int[] arr2 = {1, 0, 3};
        System.out.println("Minimum jumps to reach the end: " + minJumps(arr2));
    }
}
