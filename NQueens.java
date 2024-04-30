import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        solveNQueensUtil(board, 0, result);
        return result;
    }

    private void solveNQueensUtil(char[][] board, int col, List<List<String>> result) {
        if (col == board.length) {
            result.add(constructBoard(board));
            return;
        }
        for (int i = 0; i < board.length; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 'Q';
                solveNQueensUtil(board, col + 1, result);
                board[i][col] = '.';
            }
        }
    }

    private boolean isSafe(char[][] board, int row, int col) {
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 'Q') {
                return false;
            }
        }
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = row, j = col; i < board.length && j >= 0; i++, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    private List<String> constructBoard(char[][] board) {
        List<String> result = new ArrayList<>();
        for (char[] row : board) {
            result.add(new String(row));
        }
        return result;
    }

    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        List<List<String>> solutions = nQueens.solveNQueens(4);
        for (List<String> solution : solutions) {
            for (String row : solution) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
}
