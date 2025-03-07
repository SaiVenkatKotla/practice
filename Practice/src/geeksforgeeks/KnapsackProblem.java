package geeksforgeeks;

public class KnapsackProblem {

    // Method to calculate the maximum value
    public static int knapSack(int capacity, int[] val, int[] wt) {
        int[][] t = new int[wt.length+1][capacity+1];
        for(int i=1;i<=wt.length;i++){
            for(int j=0;j<=capacity;j++){
                if(wt[i-1]<=j){
                    t[i][j] = Math.max(val[i-1] + t[i-1][j-wt[i-1]],t[i-1][j]);
                }else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[wt.length][capacity]; // Placeholder return
    }

    public static void main(String[] args) {
        // Example 1
        int capacity1 = 4;
        int[] val1 = {1, 2, 3};
        int[] wt1 = {4, 5, 1};
        int result1 = knapSack(capacity1, val1, wt1);
        System.out.println("Input: capacity = " + capacity1 + ", val = " + java.util.Arrays.toString(val1) + ", wt = " + java.util.Arrays.toString(wt1));
        System.out.println("Output: " + result1);

        // Example 2
        int capacity2 = 3;
        int[] val2 = {1, 2, 3};
        int[] wt2 = {4, 5, 6};
        int result2 = knapSack(capacity2, val2, wt2);
        System.out.println("Input: capacity = " + capacity2 + ", val = " + java.util.Arrays.toString(val2) + ", wt = " + java.util.Arrays.toString(wt2));
        System.out.println("Output: " + result2);

        // Example 3
        int capacity3 = 5;
        int[] val3 = {10, 40, 30, 50};
        int[] wt3 = {5, 4, 1, 3};
        int result3 = knapSack(capacity3, val3, wt3);
        System.out.println("Input: capacity = " + capacity3 + ", val = " + java.util.Arrays.toString(val3) + ", wt = " + java.util.Arrays.toString(wt3));
        System.out.println("Output: " + result3);
    }
}

