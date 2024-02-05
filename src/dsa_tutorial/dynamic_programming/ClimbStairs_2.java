package dsa_tutorial.dynamic_programming;

public class ClimbStairs_2 {
    public static void main(String[] args) {
        int[] arr = {1,2,4,3,6,5,2,7,1};
        int n = arr.length;
        System.out.println(method_1(arr, n, new int[n + 1]));
    }

    // Memorization
    static int method_1(int[] arr, int n, int[] dp){
        if (n == 1) return arr[0];
        if (n == 2) return arr[0] + arr[1];

        if (dp[n] != 0) return dp[n];

        int p1 = method_1(arr, n - 1, dp);
        int p2 = method_1(arr, n - 2, dp);

        int ans = Math.min(p1, p2) + arr[n - 1];
        dp[n] = ans;

        return ans;
    }

    // Tabulation
    static int method_2(int[] arr){
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        dp[1] = arr[0] + arr[1];

        for (int i = 2; i < arr.length; i++){
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + arr[i];
        }
        return dp[dp.length - 1];
    }
}
