package qn;

import java.util.Arrays;

public class LCS {
    public static void main(String[] args) {
        String s1 = "GeeksForGeek";
        String s2 = "spGees";
        String s3 = "orGe";
        int ans = method_1(s1, s2);
//        String res = s2.substring(s2.length() - ans - 2, s2.length() - 2);
//        System.out.println(res);
        System.out.println(ans);
    }

    // Longest Common Subsequence from two string
    static int method_1(String s1, String s2){
        int max = 0;
        int row = 0;
        int col = 0;
        StringBuilder sb = new StringBuilder();
        int[][] arr = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 1; i <= s1.length(); i++){
            for (int j = 1; j <= s2.length(); j++){
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    arr[i][j] = 1 + arr[i - 1][j - 1];
                    if (max < arr[i][j]) {
                        max = arr[i][j];
                        row = i;
                        col = j;
                    }
                }
            }
        }
//        while (row >= 1 && col >= 1){
//            if (s1.charAt(row - 1) == s2.charAt(col - 1)){
//                sb.append(s1.charAt(row - 1));
//                row--;
//                col--;
//            }
//            if (sb.length() == max) break;
//        }
        while (arr[row][col] >= 1 && s1.charAt(row - 1) == s2.charAt(col - 1)) {
                sb.append(s1.charAt(row - 1));
                row--;
                col--;
        }
        System.out.println(sb.reverse());
        for (int[] i : arr) System.out.println(Arrays.toString(i));
        return max;
    }
    
    // Longest Common Subsequence from three string
    static int method_1(String s1, String s2, String s3){
        int max = 0;
        int[][][] arr = new int[s1.length() + 1][s2.length() + 1][s2.length() + 1];
        for (int i = 1; i <= s1.length(); i++){
            for (int j = 1; j <= s2.length(); j++){
                for (int k = 1; k <= s3.length(); k++){
                    if (s1.charAt(i - 1) == s2.charAt(j - 1) && s1.charAt(i - 1) == s3.charAt(k - 1)) {
                        arr[i][j][k] = 1 + arr[i - 1][j - 1][k - 1];
                        max = Math.max(max, arr[i][j][k]);
                    }
                }
            }
        }
        for (int[][] i : arr){
            for (int[] j : i){
                System.out.println(Arrays.toString(j));
            }
        }
        return max;
    }
}
