package geeksforgeeks;

import java.util.ArrayList;

public class SpiralMatrixTraversal {

    public ArrayList<Integer> spirallyTraverse(int[][] mat) {
        ArrayList<Integer> result = new ArrayList<>();
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        for (int i = 0; i <= mat.length / 2; i++) {
            result.addAll(visit(mat, visited, i, true));
        }

        return result;
    }

    private ArrayList<Integer> visit(int[][] mat, boolean[][] visited, int row, boolean direction) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < mat[row].length; i++) {
            if (!visited[row][i]) {
                visited[row][i] = true;
                result.add(mat[row][i]);
            }
        }
        for (int i = 0; i < mat.length; i++) {
            if (row < mat[row].length && !visited[i][mat[row].length - row - 1]) {
                visited[i][mat[row].length - row - 1] = true;
                result.add(mat[i][mat[row].length - row - 1]);
            }
        }
        for (int i = mat[row].length - 1; i >= 0; i--) {
            if (row < mat[row].length && !visited[mat.length - row - 1][i]) {
                visited[mat.length - row - 1][i] = true;
                result.add(mat[mat.length - row - 1][i]);
            }
        }
        for (int i = mat.length - 1; i >= 0; i--) {
            if (row < mat[row].length && !visited[i][row]) {
                visited[i][row] = true;
                result.add(mat[i][row]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Example usage:
        int[][] matrix1 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        int[][] matrix2 = {
                {1, 2, 3, 4, 5, 6},
                {7, 8, 9, 10, 11, 12},
                {13, 14, 15, 16, 17, 18}
        };

        int[][] matrix3 = {
                {32, 44, 27, 23},
                {54, 28, 50, 62}
        };


        int[][] matrix4 = {
                {1, 2},
                {3, 4},
                {5, 6},
                {7, 8},
                {9, 10},
                {11, 12},
                {13, 14}
        };

        SpiralMatrixTraversal solution = new SpiralMatrixTraversal();
        ArrayList<Integer> result1 = solution.spirallyTraverse(matrix1);
        ArrayList<Integer> result2 = solution.spirallyTraverse(matrix2);
        ArrayList<Integer> result3 = solution.spirallyTraverse(matrix3);
        ArrayList<Integer> result4 = solution.spirallyTraverse(matrix4);

        System.out.println("Result 1: " + result1);
        System.out.println("Result 2: " + result2);
        System.out.println("Result 3: " + result3);
        System.out.println("Result 4: " + result4);
    }
}
