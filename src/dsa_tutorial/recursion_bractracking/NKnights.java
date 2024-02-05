package dsa_tutorial.recursion_bractracking;

import java.util.*;

public class NKnights {
    public static void main(String[] args) {
        int n = 3;
        ArrayList<ArrayList<String>> boards = nKnightSolver(n, 5);
        for (ArrayList<String> board : boards) {
            for (int j = 0; j < n; j++) {
                System.out.println(Arrays.toString(board.get(j).toCharArray()));
            }
            System.out.println();
        }
        System.out.println(boards.size());
    }
    static void saveBoard(char[][] board, ArrayList<ArrayList<String>> allBoards){
        ArrayList<String> newBoard = new ArrayList<>();
        for (char[] i : board){
            String row = "";
            for (char val : i){
                if (val == 'K') row += 'K';
                else row += '.';
            }
            newBoard.add(row);
        }
        allBoards.add(newBoard);
    }
    static boolean isValid(char[][] board, int row, int col){
        return row >= 0 && col >= 0 && row < board.length && col < board[0].length;
    }
    static boolean isSafe(char[][] board, int row, int col){
        // top-right
        if (isValid(board, row - 1, col + 2)) {
            if (board[row - 1][col + 2] == 'K') return false;
        }
        if (isValid(board, row - 2, col + 1)) {
            if (board[row - 2][col + 1] == 'K') return false;
        }

        // top-left
        if (isValid(board, row - 2, col - 1)) {
            if (board[row - 2][col - 1] == 'K') return false;
        }
        if (isValid(board, row - 1, col - 2)) {
            if (board[row - 1][col - 2] == 'K') return false;
        }

        // bottom-right
        if (isValid(board, row + 2, col + 1)) {
            if (board[row + 2][col + 1] == 'K') return false;
        }
        if (isValid(board, row + 1, col + 2)) {
            if (board[row + 1][col + 2] == 'K') return false;
        }

        // bottom-left
        if (isValid(board, row + 1, col - 2)) {
            if (board[row + 1][col - 2] == 'K') return false;
        }
        if (isValid(board, row + 2, col - 1)) {
            if (board[row + 2][col - 1] == 'K') return false;
        }

        return true;
    }
    static void helper(ArrayList<ArrayList<String>> allBoards, char[][] board, int row, int col, int num){
        if(row == board.length){
            if (num == 0) saveBoard(board, allBoards);
            return;
        }
        if (isSafe(board, row, col)) {
            board[row][col] = 'K';
            if (col != board.length - 1) helper(allBoards, board, row, col + 1, num - 1);
            else helper(allBoards, board, row + 1, 0, num - 1);
            board[row][col] = '.';
        }
        if (col != board.length - 1) helper(allBoards, board, row, col + 1, num);
        else helper(allBoards, board, row + 1, 0, num);
    }
    static ArrayList<ArrayList<String>> nKnightSolver(int n, int knight){
        ArrayList<ArrayList<String>> allBoards = new ArrayList<>();
        char[][] board = new char[n][n];
        helper(allBoards, board, 0, 0, knight);
        return allBoards;
    }
}
