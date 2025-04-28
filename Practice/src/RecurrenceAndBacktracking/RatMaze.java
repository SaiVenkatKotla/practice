package RecurrenceAndBacktracking;

public class RatMaze {

    static boolean isSafe(int[][] maze, int x, int y) {
        return (x >= 0 && x < maze.length && y >= 0 && y < maze.length && maze[x][y] == 1);
    }

    static boolean solveMaze(int[][] maze, int x, int y, int[][] sol) {
        if (x == maze.length - 1 && y == maze.length - 1) {
            sol[x][y] = 1;
            return true;
        }

        if (isSafe(maze, x, y)) {
            sol[x][y] = 1;

            // move right
            if (solveMaze(maze, x + 1, y, sol)) return true;

            // move down
            if (solveMaze(maze, x, y + 1, sol)) return true;

            // backtrack
            sol[x][y] = 0;
            return false;
        }

        return false;
    }

    static void solve(int[][] maze) {
        int n = maze.length;
        int[][] sol = new int[n][n];

        if (!solveMaze(maze, 0, 0, sol)) {
            System.out.println("No solution found");
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(sol[i][j] + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] maze = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}
        };
        solve(maze);
    }
}

