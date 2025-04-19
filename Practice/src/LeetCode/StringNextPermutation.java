package LeetCode;

public class StringNextPermutation {

    public static void main(String[] args) {
        String num = "5489355142";
        for(int i = 0; i<4;i++)
        {
            String next = nextPermutation(num);
            num = next;
            System.out.println("Next lexicographical permutation: " + next);
        }
    }

    private static String nextPermutation(String num) {
        char[] arr = num.toCharArray();
        int n = arr.length;

        int i = n - 2;
        while(i >=0 && arr[i] >= arr[i+1]){
            i--;
        }

        if(i>=0){
            int j= n -1;
            while(arr[j] <= arr[i]){
                j--;
            }

            swap(arr,i,j);
        }

        reverseChars(arr, i+1, n-1);

        return new String(arr);
    }

    private static void swap(char[] arr, int i ,int j ){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void reverseChars(char[] arr, int start , int end){
        while(start < end){
            swap(arr, start++, end--);
        }
    }
}
