package dsa;

import java.util.*;

public class NQueens {
    public static void main(String[] args){
        List<List<String>> allBoards = nQueensSolver(4);
        for (List<String> l : allBoards){
            System.out.println(l);
        }
    }

    static void saveBoard(char[][] board, List<List<String>> allBoards){
        List<String> newBoard = new ArrayList<>();
        for (int i = 0; i < board.length; i++){
            String row = "";
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] == 'Q') row += 'Q';
                else row += '.';
            }
            newBoard.add(row);
        }
        allBoards.add(newBoard);
    }

    static boolean isSafe(char[][] board, int row, int col){
        // horizontal
        for (int i = 0; i < row; i++){
            if (board[i][col] == 'Q') return false;
        }
        // vertical
        for (int i = 0; i < col; i++){
            if (board[row][i] == 'Q') return false;
        }
        // top-right
        int r = row;
        for (int c = col; c < board.length && r >= 0; r--, c++){
            if (board[r][c] == 'Q') return false;
        }
        // top-left
        r = row;
        for (int c = col; c >= 0 && r >= 0; r--, c--){
            if (board[r][c] == 'Q') return false;
        }
        // bottom-right
        r = row;
        for (int c = col; c < board.length && r < board.length; r++, c++){
            if (board[r][c] == 'Q') return false;
        }
        // bottom-left
        r = row;
        for (int c = col; c >= 0 && r < board.length; r++, c--){
            if (board[r][c] == 'Q') return false;
        }
        return true;
    }
    static void helper(List<List<String>> allBoards, char[][] board, int col){
        if (col == board.length) {
            saveBoard(board, allBoards);
            return;
        }
        for (int i = 0; i < board.length; i++){
            if (isSafe(board, i, col)){
                board[i][col] = 'Q';
                helper(allBoards, board, col + 1);
                board[i][col] = '.';
            }
        }
    }
    static List<List<String>> nQueensSolver(int n){
        List<List<String>> allBoards = new ArrayList<>();
        char[][] board = new char[n][n];
        helper(allBoards, board, 0);
        return allBoards;
    }
}
