package tcs_qn.easy;

import java.util.Arrays;

// Adding two square matrix
public class Problem_13 {
    public static void main(String[] args) {
        int[][] matrix_1 = {{1,2},{3,4}};
        int[][] matrix_2 = {{4,3},{2,1}};
        int[][] ans = method(matrix_1, matrix_2);
        for (int[] i : ans) System.out.println(Arrays.toString(i));
    }

    static int[][] method(int[][] arr1, int[][] arr2){
        int[][] ans = new int[arr1.length][arr1.length];
        for (int i = 0; i < arr1.length; i++){
            for (int j = 0; j < arr1.length; j++){
                ans[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        return ans;
    }
}
