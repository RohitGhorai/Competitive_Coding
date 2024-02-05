package dsa;

import java.util.Arrays;

public class Sudoku {
    public static void main(String[] args) {
        int[][] board = {
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };
        sudokuSolver(board);
        for (int[] i : board){
            System.out.println(Arrays.toString(i));
        }
    }

    static boolean isSafe(int[][] board, int row, int col, int num){
        for (int i = 0; i < board.length; i++){
            if (board[i][col] == num) return false;
            if (board[row][i] == num) return false;
        }
        int sr = (row/3)*3;
        int sc = (col/3)*3;
        for (int i = sr; i < sr + 3; i++){
            for (int j = sc; j < sc + 3; j++){
                if (board[i][j] == num) return false;
            }
        }
        return true;
    }
    static boolean helper(int[][] board, int row, int col){
        if (row == board.length) return true;
        int nrow = 0;
        int ncol = 0;
        if (col != board.length - 1) {
            nrow = row;
            ncol = col + 1;
        } else {
            nrow = row + 1;
            ncol = 0;
        }
        if (board[row][col] != 0) {
            return  helper(board, nrow, ncol);
        } else {
            for (int i = 1; i <= 9; i++){
                if (isSafe(board, row, col, i)){
                    board[row][col] = i;
                    if (helper(board, nrow, ncol)) return true;
                    else board[row][col] = 0;
                }
            }
        }
        return false;
    }
    static void sudokuSolver(int[][] board){
        helper(board, 0, 0);
    }
}
