package geeksforgeeks;

import java.util.Arrays;

public class CelebrityProblem {

    public int celebrity(int[][] mat) {
        if (mat.length == 1)
            return 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1 && !knows(j, i, mat) && !isNotCelebrity(j, mat) && checkAll(j, mat)) {
                    return j;
                }
            }
        }
        return -1;
    }

    private boolean checkAll(int person, int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            if (mat[i][person] == 0 && i != person) {
                return false;
            }
        }
        return true;
    }

    private boolean knows(int a, int b, int[][] mat) {
        return mat[a][b] == 1;
    }

    private boolean isNotCelebrity(int person, int[][] mat) {
        return Arrays.stream(mat[person]).filter(x -> x == 1).findAny().isPresent();
    }

    public static void main(String[] args) {
        int[][] mat1 = {{0, 1, 0}, {0, 0, 0}, {0, 1, 0}};
        int[][] mat2 = {{0, 1}, {1, 0}};
        int[][] mat3 = {{0, 0, 0, 1, 0}, {1, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {1, 0, 0, 0, 0}};

        CelebrityProblem solver = new CelebrityProblem();

        System.out.println(solver.celebrity(mat1)); // Expected Output: 1
        System.out.println(solver.celebrity(mat2)); // Expected Output: -1
        System.out.println(solver.celebrity(mat3)); // Expected Output: 0
    }
}

