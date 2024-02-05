package dsa_tutorial.recursion_bractracking;

import java.util.*;

public class NQueens {
    public static void main(String[] args) {
        ArrayList<ArrayList<String>> boards = nQueensSolver(4);
        System.out.println(Arrays.toString(boards.toArray()));
    }

    static void saveBoard(char[][] board, ArrayList<ArrayList<String>> allBoards){
        ArrayList<String> newBoard = new ArrayList<>();
        for (char[] i : board){
            String row = "";
            for (char val : i){
                if (val == 'Q') row += 'Q';
                else row += '.';
            }
            newBoard.add(row);
        }
        allBoards.add(newBoard);
    }
    static boolean isSafe(char[][] board, int row, int col){
        // horizontal
        for (int i = 0; i <= row; i++){
            if (board[i][col] == 'Q') return false;
        }

        //vertical
        for (int i = 0; i <= col; i++){
            if(board[row][i] == 'Q') return false;
        }

        // top-right
        int r = row;
        for (int c = col; c < board[0].length && r >= 0; c++, r--){
            if (board[r][c] == 'Q') return false;
        }

        // top-left
        r = row;
        for (int c = col; c >= 0 && r >= 0; c--, r--){
            if (board[r][c] == 'Q') return false;
        }

        // bottom-right
        r = row;
        for (int c = col; c < board.length && r < board.length; c++, r++){
            if (board[r][c] == 'Q') return false;
        }
        // bottom-left
        r = row;
        for (int c = col; c >= 0 && r < board.length; c--, r++){
            if (board[r][c] == 'Q') return false;
        }

        return true;
    }
    static void helper(char[][] board, int col, ArrayList<ArrayList<String>> allBoards){
        if (col == board.length) {
            saveBoard(board, allBoards);
            return;
        }
        for (int i = 0; i < board.length; i++){
            if (isSafe(board, i, col)) {
                board[i][col] = 'Q';
                helper(board, col + 1, allBoards);
                board[i][col] = '.';
            }

        }
    }

    static ArrayList<ArrayList<String>> nQueensSolver(int n){
        ArrayList<ArrayList<String>> allBoards = new ArrayList<>();
        char[][] board = new char[n][n];
        helper(board, 0, allBoards);
        return allBoards;
    }
}
