package geeksforgeeks;

public class TripletSum {

    // Method to check if there exists a triplet in the array that sums up to the target
    public static boolean hasTripletSum(int arr[], int target) {
        for(int i=0;i<arr.length-2;i++){
            int sum = target - arr[i];
            int left = i+1, right = arr.length - 1;
            while (left <= right) {
                if (arr[left] + arr[right] == sum) {
                    System.out.println(arr[i]+":"+arr[left]+":"+arr[right]);
                    return true;
                } else if (arr[left] + arr[right] < sum) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return false;
    }

    // Main method for testing
    public static void main(String[] args) {
        // Example 1
        int[] arr1 = {1, 4, 45, 6, 10, 8};
        int target1 = 13;
        System.out.println(hasTripletSum(arr1, target1)); // Expected output: true

        // Example 2
        int[] arr2 = {1, 2, 4, 3, 6, 7};
        int target2 = 10;
        System.out.println(hasTripletSum(arr2, target2)); // Expected output: true

        // Example 3
        int[] arr3 = {40, 20, 10, 3, 6, 7};
        int target3 = 24;
        System.out.println(hasTripletSum(arr3, target3)); // Expected output: false
    }
}
