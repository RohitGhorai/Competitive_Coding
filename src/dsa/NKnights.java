package dsa;

import java.util.*;

public class NKnights {
    public static void main(String[] args) {
        List<List<String>> allBoards = knightSolver(3, 5);
        for (List<String> st : allBoards) System.out.println(st);
    }

    static void saveBoard(List<List<String>> allBoards, char[][] board){
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
    static boolean isSafe(char[][] board, int row, int col){
        // top-right
        if (isValid(board, row - 1, col + 2)){
            if (board[row - 1][col + 2] == 'K') return false;
        }
        if (isValid(board, row - 2, col + 1)){
            if (board[row - 2][col + 1] == 'K') return false;
        }
        // top-left
        if (isValid(board, row - 1, col - 2)){
            if (board[row - 1][col - 2] == 'K') return false;
        }
        if (isValid(board, row - 2, col - 1)){
            if (board[row - 2][col - 1] == 'K') return false;
        }
        // bottom-right
        if (isValid(board, row + 1, col + 2)){
            if (board[row + 1][col + 2] == 'K') return false;
        }
        if (isValid(board, row + 2, col + 1)){
            if (board[row + 2][col + 1] == 'K') return false;
        }
        // bottom-left
        if (isValid(board, row - 2, col - 1)){
            if (board[row - 2][col - 1] == 'K') return false;
        }
        if (isValid(board, row - 1, col - 2)){
            if (board[row - 1][col - 2] == 'K') return false;
        }
        return true;
    }
    static boolean isValid(char[][] board, int row, int col){
        return row >= 0 && col >= 0 && row < board.length && col < board.length;
    }
    static void helper(List<List<String>> allBoards, char[][] board, int row, int col, int num){
        if (row == board.length) {
            if (num == 0) saveBoard(allBoards, board);
            return;
        }
        if (isSafe(board, row, col)){
            board[row][col] = 'K';
            if (col != board.length - 1) helper(allBoards, board, row, col + 1, num - 1);
            else helper(allBoards, board, row + 1, 0, num - 1);
            board[row][col] = '.';
        }
        if (col != board.length - 1) helper(allBoards, board, row, col + 1, num);
        else helper(allBoards, board, row + 1, 0, num);
    }

    static List<List<String>> knightSolver(int n, int knight){
        List<List<String>> allBoards = new ArrayList<>();
        char[][] board = new char[n][n];
        helper(allBoards, board, 0, 0, knight);
        return allBoards;
    }
}
