import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Calculate {
    public static void main(String[] args) {
//        int[] arr = {41,10,74,14,32,50};
//        bubble(arr, arr.length-1, 0);
//        insertionSort(arr);
//        System.out.println(Arrays.toString(arr));
//        String s = "ABC";
//        System.out.println(isPalindrome(s.toLowerCase(), 0, s.length() - 1));
//        permutation(s.toLowerCase(), "", 0);
//        List<List<String>> allBoards = solveNQueens(4);
//        System.out.println(allBoards);
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
//        solveSudoku(board);
//        for (int i = 0; i < board.length; i++){
//            System.out.println(Arrays.toString(board[i]));
//        }
//        int ans = factorial(5);
//        System.out.println(ans);
    }

    static int factorial(int n){
        if (n <= 1){
            return n;
        } else {
            return n * factorial(n - 1);
        }
    }
    static void bubble(int[] arr, int r, int c){
        if(r == 0) return;
        if(r > c) {
            System.out.print(Arrays.toString(arr) + " --> ");
            if(arr[c+1] < arr[c]) swap(arr, c+1, c);
            bubble(arr, r, c+1);
        } else {
            System.out.println(Arrays.toString(arr));
            bubble(arr, r-1, 0);
        }
    }
    static void triangle(int r, int c){
        if(r == 0) return;
        if(r > c) {
            System.out.print(r);
            triangle(r, c+1);
        } else {
            System.out.println();
            triangle(r-1, 0);
        }
    }
    static void triangle2(int n){
        for (int i = 0; i < n; i+=2){
            for (int j = 0; j < n-i; j+=2){
                System.out.print(" ");
            }
            for (int j = 0; j < i+1; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static void insertionSort(int[] arr){
        for(int i = 1; i < arr.length; i++){
            int j = i - 1;
            int temp = arr[i];
            while(j >= 0 && temp < arr[j]){
                System.out.print(Arrays.toString(arr) + " --> ");
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;
            System.out.println(Arrays.toString(arr));
        }
    }
    static void selectionSort(int[] arr){
        for (int i = 0; i < arr.length; i++){
            int min = i;
            for (int j = i + 1; j < arr.length; j++){
                if (arr[min] > arr[j]) min = j;
            }
            System.out.print(Arrays.toString(arr) + " --> ");
            swap(arr, i, min);
            System.out.println(Arrays.toString(arr));
        }
    }
    static void bubbleSort(int[] arr){
        for (int i = 0; i < arr.length; i++){
            for (int j = 1; j < arr.length - i; j++){
                if(arr[j-1] > arr[j]) {
                    System.out.print(Arrays.toString(arr) + " ---> ");
                    swap(arr, j - 1, j);
                    System.out.println(Arrays.toString(arr));
                }
            }
        }
    }

    static boolean isPalindrome(String str, int start, int end){
        if(start == end) return true;
        if(str.charAt(start) == str.charAt(end)) return isPalindrome(str, start + 1, end - 1);
        return false;
    }
    static boolean isPalindrome2(String str){
        StringBuilder s2 = new StringBuilder(str);
        String str2 = s2.reverse().toString();
        return str.equals(str2);
    }

    static boolean isPalindrome3(String str){
        int start = 0;
        int end = str.length() - 1;
        boolean ok = false;
        while(str.charAt(start) == str.charAt(end) && start <= end){
            ok = true;
            start++;
            end--;
        }
        return ok;
    }

    static boolean validParentheses(String str){
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char x = str.charAt(i);
            if(x == '(' || x == '{' || x == '['){
                st.push(str.charAt(i));
                continue;
            }
            if (st.isEmpty()) return false;
            switch (x) {
                case ')' -> {
                    char b = st.pop();
                    if (b != '(') return false;
                    break;
                }
                case '}' -> {
                    char b = st.pop();
                    if (b != '{') return false;
                    break;
                }
                case ']' -> {
                    char b = st.pop();
                    if (b != '[') return false;
                    break;
                }
            }
        }
        return st.isEmpty();
    }

    static boolean isValid(int[][] board, int row, int col, int num){
        for(int i = 0; i < board.length; i++){
            if (board[i][col] == num) return false;
            if (board[row][i] == num) return false;
        }
        int sr = (row/3)*3;
        int sc = (col/3)*3;
        for(int r = sr; r < sr + 3; r++){
            for (int c = sc; c < sc + 3; c++){
                if (board[r][c] == num) return false;
            }
        }
        return true;
    }
    static boolean sudoKuHelper(int[][] board, int row, int col){
        if(row == board.length) return true;
        int nrow = 0;
        int ncol = 0;
        if (col != board.length - 1){
            ncol = col + 1;
            nrow = row;
        } else {
            nrow = row + 1;
            ncol = 0;
        }

        if(board[row][col] != 0){
            if (sudoKuHelper(board, nrow, ncol)) return true;
        } else {
            for (int i = 1; i <= 9; i++){
                if (isValid(board, row, col, i)){
                    board[row][col] = i;
                    if (sudoKuHelper(board, nrow, ncol)) return true;
                    board[row][col] = 0;
                }
            }
        }
        return false;
    }
    static void solveSudoku(int[][] board){
        sudoKuHelper(board, 0, 0);
    }

    static void saveBoard(List<List<String>> allBoards, char[][] board){
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
    static boolean isSafe(char[][] board, int row, int col){
        //horizontal & vertical
        for (int i = 0; i < board.length; i++){
            if (board[i][col] == 'Q') return false;
            if (board[row][i] == 'Q') return false;
        }
        //upper-right
        int r = row;
        for (int c = col; c < board.length && r >= 0; r--, c++){
            if(board[r][c] == 'Q') return false;
        }
        //upper-left
        r = row;
        for (int c = col; c >= 0 && r >= 0; r--, c--){
            if(board[r][c] == 'Q') return false;
        }
        //lower-right
        r = row;
        for (int c = col; c >= 0 && r < board.length; r++, c--){
            if(board[r][c] == 'Q') return false;
        }
        //lower-left
        r = row;
        for (int c = col; c < board.length && r < board.length; r++, c++){
            if(board[r][c] == 'Q') return false;
        }
        return true;
    }

    static void helper(List<List<String>> allBoards, char[][] board, int col){
        if (col == board.length) {
            saveBoard(allBoards, board);
            return;
        }
        for(int row = 0; row < board.length; row++){
            if (isSafe(board, row, col)){
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

    static void permutation(String str, String perm, int ind){
        if(str.length() == 0) {
            System.out.println(perm);
            return;
        }
        for (int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            String str2 = str.substring(0, i) + str.substring(i + 1);
            permutation(str2, perm + ch, ind + 1);
        }
    }
}
