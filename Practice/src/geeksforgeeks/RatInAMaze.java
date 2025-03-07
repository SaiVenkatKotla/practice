package geeksforgeeks;

import java.util.ArrayList;
import java.util.List;

public class RatInAMaze {

    private enum Direction {
        LEFT,
        RIGHT,
        UP,
        DOWN;
    }

    // Method to find all possible paths for the rat to reach the destination
    private ArrayList<String> findPath(ArrayList<ArrayList<Integer>> mat) {
        ArrayList<String> paths;
        boolean[][] visited = new boolean[mat.size()][mat.getFirst().size()];
        paths = getPaths(mat, 0, 0, visited);
        return paths;
    }


    private ArrayList<String> getPaths(ArrayList<ArrayList<Integer>> mat, int i, int j, boolean[][] visited) {
        visited[i][j] = true;
        if (i == mat.size() - 1 && j == mat.getFirst().size() - 1){
            visited[i][j] = false;
            return new ArrayList<>();
        }
        else {
            ArrayList<String> result = new ArrayList<>();
            ArrayList<String> temp;
            if (isSafe(Direction.UP, i, j, mat) && !visited[i - 1][j]) {
                temp = getPaths(mat, i - 1, j, visited);
                for (int K = 0; K < temp.size(); K++) {
                    temp.set(K, "U" + temp.get(K));
                }
                result.addAll(temp);
            }
            if (isSafe(Direction.DOWN, i, j, mat) && !visited[i + 1][j]) {
                temp = getPaths(mat, i + 1, j, visited);
                for (int K = 0; K < temp.size(); K++) {
                    temp.set(K, "D" + temp.get(K));
                }
                if (temp.isEmpty() && i + 1 == mat.size() - 1 && j == mat.getFirst().size() - 1) {
                    temp.add("D");
                }
                result.addAll(temp);
            }
            if (isSafe(Direction.RIGHT, i, j, mat) && !visited[i][j + 1]) {
                temp = getPaths(mat, i, j + 1, visited);
                for (int K = 0; K < temp.size(); K++) {
                    temp.set(K, "R" + temp.get(K));
                }
                if (temp.isEmpty() && i == mat.size() - 1 && j + 1 == mat.getFirst().size() - 1) {
                    temp.add("R");
                }
                result.addAll(temp);
            }
            if (isSafe(Direction.LEFT, i, j, mat) && !visited[i][j - 1]) {
                temp = getPaths(mat, i, j - 1, visited);
                for (int K = 0; K < temp.size(); K++) {
                    temp.set(K, "L" + temp.get(K));
                }
                result.addAll(temp);
            }
            visited[i][j] = false;
            return result;
        }
    }

    private boolean isSafe(Direction direction, int i, int j, ArrayList<ArrayList<Integer>> mat) {
        if (direction == Direction.UP && i - 1 >= 0 && mat.get(i - 1).get(j) == 1)
            return true;
        else if (direction == Direction.DOWN && i + 1 < mat.size() && mat.get(i + 1).get(j) == 1) {
            return true;
        } else if (direction == Direction.RIGHT && j + 1 < mat.getFirst().size() && mat.get(i).get(j + 1) == 1) {
            return true;
        } else if (direction == Direction.LEFT && j - 1 >= 0 && mat.get(i).get(j - 1) == 1) {
            return true;
        } else {
            return false;
        }
    }


    // Main method for testing
    public static void main(String[] args) {
        RatInAMaze ratInAMaze = new RatInAMaze();

        // Example 1
        ArrayList<ArrayList<Integer>> mat1 = new ArrayList<>();
        mat1.add(new ArrayList<>() {{
            add(1);
            add(0);
            add(0);
            add(0);
        }});
        mat1.add(new ArrayList<>() {{
            add(1);
            add(1);
            add(0);
            add(1);
        }});
        mat1.add(new ArrayList<>() {{
            add(1);
            add(1);
            add(0);
            add(0);
        }});
        mat1.add(new ArrayList<>() {{
            add(0);
            add(1);
            add(1);
            add(1);
        }});
        System.out.println(ratInAMaze.findPath(mat1)); // Expected output: ["DDRDRR", "DRDDRR"]

        // Example 2
        ArrayList<ArrayList<Integer>> mat2 = new ArrayList<>();
        mat2.add(new ArrayList<>() {{
            add(1);
            add(0);
        }});
        mat2.add(new ArrayList<>() {{
            add(1);
            add(0);
        }});
        System.out.println(ratInAMaze.findPath(mat2)); // Expected output: []

        // Example 3
        ArrayList<ArrayList<Integer>> mat3 = new ArrayList<>();
        mat3.add(new ArrayList<>() {{
            add(1);
            add(1);
            add(1);
        }});
        mat3.add(new ArrayList<>() {{
            add(1);
            add(0);
            add(1);
        }});
        mat3.add(new ArrayList<>() {{
            add(1);
            add(1);
            add(1);
        }});
        System.out.println(ratInAMaze.findPath(mat3)); // Expected output: ["DDRR", "RRDD"]


        ArrayList<ArrayList<Integer>> mat4 = new ArrayList<>();
        mat4.add(new ArrayList<>(){{
            add(1);
            add(0);
            add(0);
            add(0);
            add(0);
            add(0);
            add(0);
        }});
        mat4.add(new ArrayList<>(){{
            add(1);
            add(0);
            add(1);
            add(1);
            add(1);
            add(0);
            add(1);
        }});
        mat4.add(new ArrayList<>(){{
            add(1);
            add(1);
            add(1);
            add(0);
            add(1);
            add(1);
            add(1);
        }});
        System.out.println(ratInAMaze.findPath(mat4));

        ArrayList<ArrayList<Integer>> mat5 = new ArrayList<>();
        mat5.add(new ArrayList<>(){{
            add(1);
            add(0);
            add(0);
            add(0);
            add(0);
            add(0);
            add(0);
            add(0);
            add(0);
            add(0);
        }});
        mat5.add(new ArrayList<>(){{
            add(1);
            add(0);
            add(1);
            add(1);
            add(1);
            add(1);
            add(1);
            add(1);
            add(1);
            add(0);
        }});
        mat5.add(new ArrayList<>(){{
            add(1);
            add(0);
            add(1);
            add(0);
            add(0);
            add(0);
            add(0);
            add(0);
            add(1);
            add(0);
        }});
        mat5.add(new ArrayList<>(){{
            add(1);
            add(0);
            add(1);
            add(1);
            add(1);
            add(0);
            add(1);
            add(1);
            add(1);
            add(0);
        }});
        mat5.add(new ArrayList<>(){{
            add(1);
            add(0);
            add(0);
            add(0);
            add(1);
            add(0);
            add(1);
            add(0);
            add(0);
            add(0);
        }});
        mat5.add(new ArrayList<>(){{
            add(1);
            add(1);
            add(1);
            add(1);
            add(1);
            add(0);
            add(1);
            add(1);
            add(1);
            add(1);
        }});
        System.out.println(ratInAMaze.findPath(mat5));

    }
}
