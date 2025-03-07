package Algorithms;

public class GridPathChecker {
    private int[][] grid; // The grid representation

    // Constructor to initialize the grid
    public GridPathChecker(int[][] grid) {
        this.grid = grid;
    }

    // Method to check if a path exists between start and end points
    public boolean doesPathExist(int startRow, int startCol, int endRow, int endCol) {
        boolean flag = false;
        if(grid[startRow][startCol] == 1 && startRow == endRow && startCol == endCol )
            return true;
        if (grid[startRow][startCol] == 1 ) {
            if(startCol + 1 <=endCol)
                flag = flag || doesPathExist(startRow, startCol + 1, endRow, endCol);
            if(startRow +1 <=endRow)
                flag = flag || doesPathExist(startRow + 1, startCol, endRow, endCol);
        }
        return flag;
    }

    public static void main(String[] args) {
        // Example 1: Simple Path in Open Grid
        int[][] grid1 = {
                {1, 1, 1, 1},
                {0, 0, 0, 1},
                {1, 1, 1, 1}
        };
        GridPathChecker checker1 = new GridPathChecker(grid1);
        System.out.println("Example 1: " + checker1.doesPathExist(0, 0, 2, 3));

        // Example 2: No Path Due to Obstacles
        int[][] grid2 = {
                {1, 1, 1, 0},
                {0, 0, 1, 0},
                {1, 1, 1, 0}
        };
        GridPathChecker checker2 = new GridPathChecker(grid2);
        System.out.println("Example 2: " + checker2.doesPathExist(0, 0, 2, 3));

        // Example 3: Single Cell Grid
        int[][] grid3 = {
                {1}
        };
        GridPathChecker checker3 = new GridPathChecker(grid3);
        System.out.println("Example 3: " + checker3.doesPathExist(0, 0, 0, 0));

        // Example 4: Grid with Multiple Paths
        int[][] grid4 = {
                {1, 1, 0, 1},
                {1, 0, 1, 1},
                {1, 1, 1, 1}
        };
        GridPathChecker checker4 = new GridPathChecker(grid4);
        System.out.println("Example 4: " + checker4.doesPathExist(0, 0, 2, 3));

        // Example 5: Grid with Dead Ends
        int[][] grid5 = {
                {1, 1, 0, 0},
                {0, 1, 1, 0},
                {1, 0, 1, 1},
                {1, 1, 1, 1}
        };
        GridPathChecker checker5 = new GridPathChecker(grid5);
        System.out.println("Example 5: " + checker5.doesPathExist(0, 0, 3, 3));

        // Example 6: Large Grid with Blocked Middle
        int[][] grid6 = {
                {1, 1, 1, 1, 1},
                {1, 0, 0, 0, 1},
                {1, 1, 1, 1, 1}
        };
        GridPathChecker checker6 = new GridPathChecker(grid6);
        System.out.println("Example 6: " + checker6.doesPathExist(0, 0, 2, 4));

        // Example 7: No Start Point
        int[][] grid7 = {
                {0, 0, 0, 0},
                {0, 1, 1, 1},
                {1, 1, 1, 1}
        };
        GridPathChecker checker7 = new GridPathChecker(grid7);
        System.out.println("Example 7: " + checker7.doesPathExist(0, 0, 2, 3));

        // Example 8: Full Grid
        int[][] grid8 = {
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        };
        GridPathChecker checker8 = new GridPathChecker(grid8);
        System.out.println("Example 8: " + checker8.doesPathExist(0, 0, 2, 2));

        // Example 9: Path Along Edges
        int[][] grid9 = {
                {1, 0, 0},
                {1, 0, 1},
                {1, 1, 1}
        };
        GridPathChecker checker9 = new GridPathChecker(grid9);
        System.out.println("Example 9: " + checker9.doesPathExist(0, 0, 2, 2));

        // Example 10: Diagonal Blockage
        int[][] grid10 = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        GridPathChecker checker10 = new GridPathChecker(grid10);
        System.out.println("Example 10: " + checker10.doesPathExist(0, 0, 2, 2));
    }
}

