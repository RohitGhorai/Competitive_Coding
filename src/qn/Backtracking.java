package qn;

import java.util.*;
import java.util.stream.Collectors;

public class Backtracking {
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
//        sudokuSolver(board);
//        for (int[] num : board)
//            System.out.println(Arrays.toString(num));
//        List<List<String>> allBoards = nQueensSolover(4);
//        System.out.println(Arrays.toString(allBoards.toArray()));
//        List<List<String>> boards = nKnightSolver(3, 5);
//        for (int i = 0; i < boards.size(); i++){
//            for (int j = 0; j < 3; j++){
//                System.out.println(Arrays.toString(boards.get(i).get(j).toCharArray()));
//            }
//            System.out.println();
//        }
//        int[][] board = new int[][]{
//                {1, 1, 1},
//                {1, 0, 0},
//                {1, 1, 1},
//        };
//        mazeSolver(board);
    }

    static void mazeHelper(String path, int[][] board, int row, int col, List<List<String>> allPaths){
        if (row == board.length-1 && col == board[0].length-1){
            System.out.println(path);
            return;
        }
        if (board[row][col] == 0) return;
        if (col != board.length - 1) mazeHelper(path+'R', board, row, col + 1, allPaths);
        if (row != board.length - 1) mazeHelper(path+'D', board, row + 1, col, allPaths);
    }

    static boolean isValid(int[][] path, int row, int col){
        if (row >= 0 && col >= 0 && row < path.length && col < path.length) return true;
        return false;
    }

    static void mazeSolver(int[][] board){
        List<List<String>> allPaths = new ArrayList<>();
        mazeHelper("", board, 0, 0, allPaths);
    }

    static void saveKnightBoard(char[][] board, List<List<String>> allBoards){
        List<String> newBoard = new ArrayList<>();
        for (int i = 0; i < board.length; i++){
            String row = "";
            for (int j = 0; j < board.length; j++){
                if (board[i][j] == 'K') row += 'K';
                else row += '.';
            }
            newBoard.add(row);
        }
        allBoards.add(newBoard);
     }

     static boolean isSafeForKnight(char[][] board, int row, int col){

        // top-left
        if (isOk(board, row-2, col-1)){
            if (board[row-2][col-1] == 'K') return false;
        }
        if (isOk(board, row-1, col-2)){
            if (board[row-1][col-2] == 'K') return false;
        }

        // top-right
        if (isOk(board, row-2, col+1)){
            if (board[row-2][col+1] == 'K') return false;
        }
        if (isOk(board, row-1, col+2)){
            if (board[row-1][col+2] == 'K') return false;
        }

        // bottom-left
        if (isOk(board, row+1, col-2)){
            if (board[row+1][col-2] == 'K') return false;
        }
        if (isOk(board, row+2, col-1)){
            if (board[row+2][col-1] == 'K') return false;
        }

        // bottom-right
        if (isOk(board, row+2, col+1)){
             if (board[row+2][col+1] == 'K') return false;
        }
        if (isOk(board, row+1, col+2)){
             if (board[row+1][col+2] == 'K') return false;
        }

        return true;
     }

     static boolean isOk(char[][] board, int row, int col){
        if (row >= 0 && row < board.length && col >= 0 && col < board.length) return true;
        return false;
     }
    static void knightHelper(List<List<String>> allBoards, char[][] board, int row, int col, int num){
        if (row == board.length){
            if (num == 0) saveKnightBoard(board, allBoards);
            return;
        }

        if (isSafeForKnight(board, row, col)) {
            board[row][col] = 'K';
            if (col != board.length - 1){
                knightHelper(allBoards, board, row, col + 1, num - 1);
            } else {
                knightHelper(allBoards, board, row + 1, 0, num - 1);
            }
            board[row][col] = '.';
        }

        if (col != board.length - 1){
            knightHelper(allBoards, board, row, col + 1, num);
        } else {
            knightHelper(allBoards, board, row + 1, 0, num);
        }

    }

    static List<List<String>> nKnightSolver(int n, int knight){
        List<List<String>> allBoards = new ArrayList<>();
        char[][] board = new char[n][n];
        knightHelper(allBoards, board, 0, 0, knight);
        return allBoards;
    }
    static void saveQueenBoard(char[][] board, List<List<String>> allBoards){
        List<String> newBoard = new ArrayList<>();
        for (int i = 0; i < board.length; i++){
            String row = "";
            for (int j = 0; j < board.length; j++){
                if (board[i][j] == 'Q') row += 'Q';
                else row += '.';
            }
            newBoard.add(row);
        }
        allBoards.add(newBoard);
    }
    static boolean isSafeForQueen(char[][] board, int row, int col){
        // horizontal
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }
        // vertical
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 'Q') return false;
        }
        // top-right
        int r = row;
        for (int c = col; c < board.length && r >= 0; r--, c++) {
            if (board[r][c] == 'Q') return false;
        }
        // top-left
        r = row;
        for (int c = col; c >= 0 && r >= 0; r--, c--) {
            if (board[r][c] == 'Q') return false;
        }
        // bottom-right
        r = row;
        for (int c = col; c < board.length && r < board.length; r++, c++) {
            if (board[r][c] == 'Q') return false;
        }
        // bottom-left
        r = row;
        for (int c = col; c >= 0 && r < board.length; r++, c--) {
            if (board[r][c] == 'Q') return false;
        }

        return true;
    }
    static void queensHelper(List<List<String>> allBoards, char[][] board, int col){
        if (col == board.length){
            saveQueenBoard(board, allBoards);
            return;
        }
        for (int row = 0; row < board.length; row++){
            if (isSafeForQueen(board, row, col)){
                board[row][col] = 'Q';
                queensHelper(allBoards, board, col + 1);
                board[row][col] = '.';
            }
        }
    }

    static List<List<String>> nQueensSolover(int n){
        List<List<String>> allBoards = new ArrayList<>();
        char[][] board = new char[n][n];
        queensHelper(allBoards, board, 0);
        return allBoards;
    }
    static boolean isSafe(int[][] board, int row, int col, int num){
        for (int i = 0; i < board.length; i++){
            if (board[row][i] == num) return false;
            if (board[i][col] == num) return false;
        }
        int sr = (row/3) * 3;
        int sc = (col/3) * 3;
        for (int i = sr; i < sr + 3; i++){
            for (int j = sc; j < sc + 3; j++){
                if (board[i][j] == num) return false;
            }
        }
        return true;
    }
    static boolean sudokuHelper(int[][] board, int row, int col){
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
            if (sudokuHelper(board, nrow, ncol)) return true;
        } else {
            for (int i = 1; i <= 9; i++){
                if(isSafe(board, row, col, i)){
                    board[row][col] = i;
                    if (sudokuHelper(board, nrow, ncol)) return true;
                    else board[row][col] = 0;
                }
            }
        }
        return false;
    }
    static void sudokuSolver(int[][] board){
        sudokuHelper(board, 0, 0);
    }
}
