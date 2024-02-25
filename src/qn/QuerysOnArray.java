package qn;

import java.util.*;

public class QuerysOnArray {
    public static void main(String[] args) {
        int n = 5;
        int k = method_1(new int[][]{
                { 0, 1, 100 },
                { 1, 4, 100 },
                { 2, 3, 100 }
        }, new int[n], 0);
        System.out.println(k);
    }
    static int method_1(int[][] arr, int[] ans, int l){
        for (int[] val : arr) {
            for (int k = val[0]; k <= val[1]; k++) {
                if (k < ans.length) {
                    ans[k] += val[2];
                }
            }
        }
        for (int i : ans) l = Math.max(l, i);
        return l;
    }
}
