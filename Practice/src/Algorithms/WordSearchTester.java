package Algorithms;

public class WordSearchTester {

    public static void main(String[] args) {
        // Example 1: Simple Horizontal Word
        char[][] grid1 = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word1 = "SEE";
        System.out.println("Example 1: " + doesWordExist(grid1, word1)); // Expected: true

        // Example 2: Simple Vertical Word
        char[][] grid2 = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word2 = "BCE";
        System.out.println("Example 2: " + doesWordExist(grid2, word2)); // Expected: true

        // Example 3: Word Diagonally
        char[][] grid3 = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word3 = "ACE";
        System.out.println("Example 3: " + doesWordExist(grid3, word3)); // Expected: false

        // Example 4: Backtracking is Needed
        char[][] grid4 = {
                {'A', 'B', 'A', 'B'},
                {'C', 'D', 'C', 'D'},
                {'B', 'A', 'B', 'A'}
        };
        String word4 = "ABAB";
        System.out.println("Example 4: " + doesWordExist(grid4, word4)); // Expected: true

        // Example 5: Word Not Present
        char[][] grid5 = {
                {'H', 'A', 'P', 'P', 'Y'},
                {'T', 'R', 'A', 'I', 'N'},
                {'E', 'D', 'U', 'C', 'A'}
        };
        String word5 = "SMART";
        System.out.println("Example 5: " + doesWordExist(grid5, word5)); // Expected: false

        // Example 6: Large Grid
        char[][] grid6 = {
                {'A', 'B', 'C', 'D', 'E', 'F'},
                {'G', 'H', 'I', 'J', 'K', 'L'},
                {'M', 'N', 'O', 'P', 'Q', 'R'},
                {'S', 'T', 'U', 'V', 'W', 'X'},
                {'Y', 'Z', 'A', 'B', 'C', 'D'}
        };
        String word6 = "NOPQRST";
        System.out.println("Example 6: " + doesWordExist(grid6, word6)); // Expected: true

        // Example 7: Entire Grid Traversal Not Needed
        char[][] grid7 = {
                {'T', 'H', 'I', 'S'},
                {'I', 'S', 'A', 'T'},
                {'E', 'S', 'T', 'H'},
                {'E', 'G', 'R', 'I'}
        };
        String word7 = "THIS";
        System.out.println("Example 7: " + doesWordExist(grid7, word7)); // Expected: true

        // Example 8: Complex Path
        char[][] grid8 = {
                {'E', 'A', 'R', 'T', 'H'},
                {'A', 'I', 'R', 'W', 'A'},
                {'T', 'H', 'E', 'R', 'E'},
                {'H', 'O', 'P', 'E', 'S'}
        };
        String word8 = "AIRWATER";
        System.out.println("Example 8: " + doesWordExist(grid8, word8)); // Expected: true

        // Example 9: Single Letter Word
        char[][] grid9 = {
                {'A', 'B', 'C'},
                {'D', 'E', 'F'},
                {'G', 'H', 'I'}
        };
        String word9 = "E";
        System.out.println("Example 9: " + doesWordExist(grid9, word9)); // Expected: true

        // Example 10: Word Larger Than Grid
        char[][] grid10 = {
                {'A', 'B', 'C'},
                {'D', 'E', 'F'},
                {'G', 'H', 'I'}
        };
        String word10 = "ABCDEFGHIJ";
        System.out.println("Example 10: " + doesWordExist(grid10, word10)); // Expected: false
    }

    /**
     * Placeholder method for checking if the word exists in the grid.
     * @param grid 2D character grid
     * @param word Word to search for
     * @return true if the word exists in the grid, false otherwise
     */
    public static boolean doesWordExist(char[][] grid, String word) {
        // Logic to be implemented here.
        return false;
    }
}

