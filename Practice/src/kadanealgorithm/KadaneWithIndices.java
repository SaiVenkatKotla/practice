package kadanealgorithm;

/**
 * This is a variation of KadaneAlgorithm
 * We are supposed to return maximum sum along with
 * indices of the subarray.
 */
public class KadaneWithIndices {

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] result = maxSubArraySumWithIndices(arr);
        System.out.println("Maximum subarray sum: " + result[0]); // Output: 6
        System.out.println("Start index: " + result[1]); // Output: 3
        System.out.println("End index: " + result[2]); // Output: 6
    }

    private static int[] maxSubArraySumWithIndices(int[] arr) {
        int currentMax = 0;
        int globalMax = Integer.MIN_VALUE;
        int startIndex = 0;
        int endIndex = 0;
        int temp_start_index = 0;

        for (int i = 0; i < arr.length; i++) {

            if (currentMax < 0) {
                currentMax = arr[i];
                temp_start_index = i;
            } else {
                currentMax += arr[i];
            }

            if (currentMax > globalMax) {
                globalMax = currentMax;
                startIndex = temp_start_index;
                endIndex = i;
            }
        }

        return new int[]{globalMax, startIndex, endIndex};
    }
}
