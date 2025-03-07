package geeksforgeeks;

import java.util.*;

public class CommonElementsFinder {

    /**
     * Finds the common elements in three sorted arrays.
     *
     * @param arr1 The first sorted array.
     * @param arr2 The second sorted array.
     * @param arr3 The third sorted array.
     * @return A list of common elements. If no common elements are found, returns [-1].
     */
    public static List<Integer> commonElements(List<Integer> arr1, List<Integer> arr2, List<Integer> arr3) {
        ArrayList<Integer> result = new ArrayList<>();
        int one = 0, two = 0, three = 0;
        while (one < arr1.size() && two < arr2.size() && three < arr3.size()) {
            if (arr1.get(one) == arr2.get(two) && arr2.get(two) == arr3.get(three) ) {
                if( result.isEmpty() || !result.get(result.size()-1).equals(arr1.get(one))) {
                    result.add(arr1.get(one));
                }
                one++;
                two++;
                three++;
            } else if (arr1.get(one) < arr2.get(two) ) {
                one++;
            } else if ( arr2.get(two) < arr3.get(three)) {
                two++;
            } else  {
                three++;
            }
        }
        return !result.isEmpty() ? result : Arrays.asList(-1); // Placeholder return value.
    }

    // Main method to test the commonElements function with examples.
    public static void main(String[] args) {
        // Test cases
        List<Integer> arr1 = List.of(1, 5, 10, 20, 40, 80);
        List<Integer> arr2 = List.of(6, 7, 20, 80, 100);
        List<Integer> arr3 = List.of(3, 4, 15, 20, 30, 70, 80, 120);

        List<Integer> result1 = commonElements(arr1, arr2, arr3);
        System.out.println("Input: arr1 = [1, 5, 10, 20, 40, 80], arr2 = [6, 7, 20, 80, 100], arr3 = [3, 4, 15, 20, 30, 70, 80, 120]");
        System.out.println("Output: " + result1);
        System.out.println();

        List<Integer> arr4 = List.of(1, 2, 3, 4, 5);
        List<Integer> arr5 = List.of(6, 7);
        List<Integer> arr6 = List.of(8, 9, 10);

        List<Integer> result2 = commonElements(arr4, arr5, arr6);
        System.out.println("Input: arr1 = [1, 2, 3, 4, 5], arr2 = [6, 7], arr3 = [8, 9, 10]");
        System.out.println("Output: " + result2);
        System.out.println();

        List<Integer> arr7 = List.of(1, 1, 1, 2, 2, 2);
        List<Integer> arr8 = List.of(1, 1, 2, 2, 2);
        List<Integer> arr9 = List.of(1, 1, 1, 1, 2, 2, 2, 2);

        List<Integer> result3 = commonElements(arr7, arr8, arr9);
        System.out.println("Input: arr1 = [1, 1, 1, 2, 2, 2], arr2 = [1, 1, 2, 2, 2], arr3 = [1, 1, 1, 1, 2, 2, 2, 2]");
        System.out.println("Output: " + result3);
    }
}