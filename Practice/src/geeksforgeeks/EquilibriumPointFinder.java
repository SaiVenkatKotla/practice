package geeksforgeeks;

public class EquilibriumPointFinder {

    // Method to find the equilibrium point in an array
    public static int equilibriumPoint(int arr[]) {
        int totalSum = 0;
        int leftSum = 0;

        for (int num : arr) {
            totalSum += num;
        }

        for (int i = 0; i < arr.length; i++) {
            totalSum -= arr[i];
            if (leftSum == totalSum) {
                return i + 1;
            }

            leftSum += arr[i];
        }

        return -1; // No equilibrium point found
    }

    public static void main(String[] args) {
        // Example 1
        int[] arr1 = {1, 3, 5, 2, 2};
        System.out.println("Equilibrium Point for arr1: " + equilibriumPoint(arr1));

        // Example 2
        int[] arr2 = {0, 1, 0};
        System.out.println("Equilibrium Point for arr2: " + equilibriumPoint(arr2));

        // Example 3
        int[] arr3 = {1, 2, 3};
        System.out.println("Equilibrium Point for arr3: " + equilibriumPoint(arr3));
    }
}
