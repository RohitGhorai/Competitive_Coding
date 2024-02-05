package dsa_tutorial.dynamic_programming;

import java.util.Arrays;

public class LongestSubsequence {
    public static void main(String[] args) {
        int[] arr = {10,2,5,60,42,70,9,80,90};
//        int[] arr = {5,4,3,2,1};
//        System.out.println(method_1(arr, 0, -1, new int[arr.length][arr.length]));
        System.out.println(method_3(arr));
    }

    // Tabulation
    static int method_3(int[] arr){
        int[] dp = new int[arr.length];
        dp[0] = 1;
        int ans = 0;
        for (int i = 1; i < arr.length; i++){
            int max = 0;
            for (int j = 0; j < i; j++){
                if (arr[i] > arr[j])
                    max = Math.max(max, dp[j]);
            }
            dp[i] = max + 1;
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(Arrays.toString(dp));
        return ans;
    }

    // Memorization - 1
    static int method_1(int[] arr, int idx, int preIdx, int[][] dp){
        if (idx == arr.length)
            return 0;

        if (preIdx != -1 && dp[idx][preIdx] != 0)
            return dp[idx][preIdx];

        int f1 = method_1(arr, idx + 1, preIdx, dp);
        int f2 = 0;
        if (preIdx == -1 || arr[idx] > arr[preIdx]) f2 = 1 + method_1(arr, idx + 1, idx, dp);

        int ans = Math.max(f1, f2);
        if (preIdx != -1) dp[idx][preIdx] = ans;

        return ans;
    }

    // Memorization - 2
    static int method_2(int[] arr){
        int ans = 0;
        for (int i = 0; i < arr.length; i++){
            int len = helper(arr, i);
            ans = Math.max(ans, len);
        }
        return ans;
    }
    static int helper(int[] arr, int j){
        int max = 0;
        for (int i = 0; i < j; i++){
            if (arr[i] < arr[j]) max = Math.max(max, helper(arr, i));
        }
        return max + 1;
    }
}
