package LeetCode;

public class WordSearch {

    public boolean exist(char[][] board, String word) {
        boolean result = false;
        result = checkForWord(board, word, 0, 0);
        return result;
    }

    private boolean checkForWord(char[][] board, String word, int row, int col) {
        boolean result = false;
        if (row == board.length || col == board[0].length) {
            return false;
        }
        if (word.isEmpty()) {
            return true;
        }

        for (int i = row; i < board.length && i >= 0; i++) {
            for (int j = col; j < board[i].length && j >= 0; j++) {
                if (board[i][j] == word.charAt(0)) {

                    result =
                            checkForWord(board, word.substring(1), row, col + 1)
                                    || checkForWord(board, word.substring(1), row + 1, col)
                                    || checkForWord(board, word.substring(1), row - 1, col)
                                    || checkForWord(board, word.substring(1), row, col - 1);
                }

            }
        }
        return result;
    }

    public static void main(String[] args) {
        WordSearch ws = new WordSearch();

        // Example 1
        char[][] board1 = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word1 = "ABCCED";
        System.out.println(ws.exist(board1, word1)); // Expected: true

        // Example 2
        String word2 = "SEE";
        System.out.println(ws.exist(board1, word2)); // Expected: true

        // Example 3
        String word3 = "ABCB";
        System.out.println(ws.exist(board1, word3)); // Expected: false
    }
}
