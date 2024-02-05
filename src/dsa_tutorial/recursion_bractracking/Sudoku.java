package dsa_tutorial.recursion_bractracking;

import java.util.*;

public class Sudoku {
    public static void main(String[] args) {
//        int[][] board = {
//                {3, 0, 6, 5, 0, 8, 4, 0, 0},
//                {5, 2, 0, 0, 0, 0, 0, 0, 0},
//                {0, 8, 7, 0, 0, 0, 0, 3, 1},
//                {0, 0, 3, 0, 1, 0, 0, 8, 0},
//                {9, 0, 0, 8, 6, 3, 0, 0, 5},
//                {0, 5, 0, 0, 9, 0, 6, 0, 0},
//                {1, 3, 0, 0, 0, 0, 2, 5, 0},
//                {0, 0, 0, 0, 0, 0, 0, 7, 4},
//                {0, 0, 5, 2, 0, 6, 3, 0, 0}
//        };
        int[][] board2 = {
                {0, 0, 9, 7, 4, 8, 0, 0, 0},
                {7, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 2, 0, 1, 0, 9, 0, 0, 0},
                {0, 0, 7, 0, 0, 0, 2, 4, 0},
                {0, 6, 4, 0, 1, 0, 5, 9, 0},
                {0, 9, 8, 0, 0, 0, 3, 0, 0},
                {0, 0, 0, 8, 0, 3, 0, 2, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 6},
                {0, 0, 0, 2, 7, 5, 9, 0, 0},
        };
        sudokuSolver(board2);
        for (int[] i : board2){
            System.out.println(Arrays.toString(i));
        }
    }

    static boolean isSafe(int[][] board, int row, int col, int num){
        // rows & columns
        for (int i = 0; i < board.length; i++){
            if (board[i][col] == num) return false;
            if (board[row][i] == num) return false;
        }
        // grids
        int sr = (row / 3)*3;
        int sc = (col / 3)*3;
        for (int r = sr; r < sr + 3; r++){
            for (int c = sc; c < sc + 3; c++){
                if (board[r][c] == num) return false;
            }
        }

        return true;
    }
    static boolean helper(int[][] board, int row, int col) {
        if (row == board.length) return true;

        int nrow = 0;
        int ncol = 0;

        if (col != board.length - 1){
            nrow = row;
            ncol = col + 1;
        } else {
            nrow = row + 1;
            ncol = 0;
        }
        if (board[row][col] != 0) {
            return helper(board, nrow, ncol);
        } else {
            for (int i = 1; i <= 9; i++){
                if (isSafe(board, row, col, i)) {
                    board[row][col] = i;
                    if (helper(board, nrow, ncol)) return true;
                    else board[row][col] = 0;
                }
            }
        }
        return false;
    }
    static void sudokuSolver(int[][] board) {
        helper(board, 0, 0);
    }
}
