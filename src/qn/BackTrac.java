package qn;

import java.util.*;

public class BackTrac {
    public static void main(String[] args) {
//        List<List<String>> allBoards = solveNQueens(4);
//        System.out.println(Arrays.toString(allBoards.toArray()));
//        permutation("ACBD", "", 0);
//        char[][] board = {
//                {'3', '.', '6', '5', '.', '8', '4', '.', '.'},
//                {'5', '2', '.', '.', '.', '.', '.', '.', '.'},
//                {'.', '8', '7', '.', '.', '.', '.', '3', '1'},
//                {'.', '.', '3', '.', '1', '.', '.', '8', '.'},
//                {'9', '.', '.', '8', '6', '3', '.', '.', '5'},
//                {'.', '5', '.', '.', '9', '.', '6', '.', '.'},
//                {'1', '3', '.', '.', '.', '.', '2', '5', '.'},
//                {'.', '.', '.', '.', '.', '.', '.', '7', '4'},
//                {'.', '.', '5', '2', '.', '6', '3', '.', '.'}
//        };
//        char[][] ch = {
//                {'5','3','.','.','7','.','.','.','.'},
//                {'6','.','.','1','9','5','.','.','.'},
//                {'.','9','8','.','.','.','.','6','.'},
//                {'8','.','.','.','6','.','.','.','3'},
//                {'4','.','.','8','.','3','.','.','1'},
//                {'7','.','.','.','2','.','.','.','6'},
//                {'.','6','.','.','.','.','2','8','.'},
//                {'.','.','.','4','1','9','.','.','5'},
//                {'.','.','.','.','8','.','.','7','9'}
//        };
//        solveSudoku(board);
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board.length; j++) {
//                System.out.print(board[i][j] + " ");
//            }
//            System.out.println();
//        }
        List<List<String>> allBoards = solveNKnights(3, 5);
        for (int i = 0; i < allBoards.size(); i++){
            for (int j = 0; j < 3; j++){
                System.out.print(Arrays.toString(allBoards.get(i).get(j).toCharArray()));
                System.out.println();
            }
            System.out.println();
        }
        System.out.println(allBoards.size());
    }

    static boolean isOk(char[][] board, int row, int col){
        //upper-left
        if (isTrue(board, row-2, col-1)) {
            if (board[row-2][col-1] == 'K') return false;
        }
        if (isTrue(board, row-2, col+1)) {
            if (board[row-2][col+1] == 'K') return false;
        }
        //upper-right
        if (isTrue(board, row-1, col+2)) {
            if (board[row-1][col+2] == 'K') return false;
        }
        if (isTrue(board, row-1, col-2)) {
            if (board[row-1][col-2] == 'K') return false;
        }
        //lower-left
        if (isTrue(board, row+1, col-2)) {
            if (board[row+1][col-2] == 'K') return false;
        }
        if (isTrue(board, row+2, col-1)) {
            if (board[row+2][col-1] == 'K') return false;
        }
        //lower-right
        if (isTrue(board, row+1, col+2)) {
            if (board[row+1][col+2] == 'K') return false;
        }
        if (isTrue(board, row+2, col+1)) {
            if (board[row+2][col+1] == 'K') return false;
        }
        return true;
    }
    static boolean isTrue(char[][] board, int row, int col){
        if (row >= 0 && row < board.length && col >= 0 && col < board.length) return true;
        return false;
    }
    static void knightHelper(List<List<String>> allBoards, char[][] board, int row, int col, int num){
        if (row == board.length) {
            if (num == 0) saveBoard(board, allBoards);
            return;
        }

        if (isOk(board, row, col)){
            board[row][col] = 'K';
            if (col != board.length - 1){
                knightHelper(allBoards, board, row, col + 1, num-1);
            } else {
                knightHelper(allBoards, board, row + 1, 0, num-1);
            }
            board[row][col] = '.';
        }

        if (col != board.length - 1){
            knightHelper(allBoards, board, row, col + 1, num);
        } else {
            knightHelper(allBoards, board, row + 1, 0, num);
        }
    }
    static List<List<String>> solveNKnights(int n, int num){
        List<List<String>> allBoards = new ArrayList<>();
        char[][] board = new char[n][n];
        knightHelper(allBoards, board, 0, 0, num);
        return allBoards;
    }
    static boolean isSafe(char[][] board, int row, int col, int num){
        for (int i = 0; i < board.length; i++){
            if(board[i][col] == (char)(num + '0')) return false;
            if(board[row][i] == (char)(num + '0')) return false;
        }

        //grid
        int sr = (row/3) *3;
        int sc = (col/3) *3;
        for (int i = sr; i < sr + 3; i++){
            for (int j = sc; j < sc + 3; j++){
                if(board[i][j] == (char)(num + '0')) return false;
            }
        }
        return true;
    }
    static boolean sudokuHelper(char[][] board, int row, int col){
        if(row == board.length) return true;

        int nrow = 0;
        int ncol = 0;

        if (col != board.length - 1){
            nrow = row;
            ncol = col + 1;
        } else {
            nrow = row + 1;
            ncol = 0;
        }

        if(board[row][col] != '.') {
            if (sudokuHelper(board, nrow, ncol)) return true;
        }
        else {
            for (int i = 1; i <= 9; i++){
                if (isSafe(board, row, col, i)) {
                    board[row][col] = (char)(i + '0');
                    if(sudokuHelper(board, nrow, ncol)) return true;
                    else board[row][col] = '.';
                }
            }
        }
        return false;
    }
    static void solveSudoku(char[][] board){
        sudokuHelper(board, 0, 0);
    }
    static void saveBoard(char[][] board, List<List<String>> allBoards){
        List<String> newBoard = new ArrayList<>();
        for (char[] chars : board) {
            String row = "";
            for (int j = 0; j < board.length; j++) {
                if (chars[j] == 'K') row += 'K';
                else row += '.';
            }
            newBoard.add(row);
        }
        allBoards.add(newBoard);
    }

    static boolean isValid(char[][] board, int row, int col){
        //horizontal
        for(int i = 0; i < board.length; i++){
            if(board[row][i] == 'Q') return false;
        }

        //vertical
        for(int i = 0; i < board.length; i++){
            if(board[i][col] == 'Q') return false;
        }

        //upper-left
        int r = row;
        for(int c = col; c >= 0 && r >= 0; r--, c--){
            if(board[r][c] == 'Q') return false;
        }

        //upper-right
        r = row;
        for(int c = col; c < board.length && r >= 0; r--, c++){
            if(board[r][c] == 'Q') return false;
        }

        //lower-left
        r = row;
        for(int c = col; c >= 0 && r < board.length; r++, c--){
            if(board[r][c] == 'Q') return false;
        }

        //lower-right
        r = row;
        for (int c = col; c < board.length && r < board.length; r++, c++){
            if(board[r][c] == 'Q') return false;
        }

        return true;
    }

    static void helper(List<List<String>> allBoards, char[][] board, int col){
        if(col == board.length){
            saveBoard(board, allBoards);
            return;
        }
        for(int row = 0; row < board.length; row++){
            if(isValid(board, row, col)){
                board[row][col] = 'Q';
                helper(allBoards, board, col + 1);
                board[row][col] = '.';
            }
        }
    }
    static List<List<String>> solveNQueens(int n){
        List<List<String>> allBoards = new ArrayList<>();
        char[][] board = new char[n][n];
        helper(allBoards, board, 0);
        return allBoards;
    }

    static void permutation(String str, String perm){
        if(str.length() == 0) {
            System.out.println(perm);
            return;
        }
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            String st = str.substring(0, i) + str.substring(i+1);
            permutation(st, perm + ch);
        }
    }
}
