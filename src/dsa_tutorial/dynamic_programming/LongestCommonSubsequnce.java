package dsa_tutorial.dynamic_programming;

public class LongestCommonSubsequnce {
    public static void main(String[] args) {
        String s1 = "abbcdgf";
        String s2 = "bbadcgf";
        int ans = method_1(s1, s2, 0, 0, new int[s1.length()][s2.length()]);
        System.out.println(ans);
//        System.out.println(method_2(s1, s2));
    }

    // Tabulation    [Time Complexity = O(n*m) & Space Complexity = O(n*m)]
    static int method_2(String s1, String s2){
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = dp.length - 2; i >= 0; i--){
            for (int j = dp[0].length - 2; j >= 0; j--){
                if (s1.charAt(i) == s2.charAt(j)) dp[i][j] = 1 + dp[i + 1][j + 1];
                else dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
            }
        }
        return dp[0][0];
    }

    // Memorization
    static int method_1(String s1, String s2, int i, int j, int[][] dp){
        if (i == s1.length() || j == s2.length()) return 0;
        if (dp[i][j] != 0) return dp[i][j];
        int ans = 0;
        if (s1.charAt(i) == s2.charAt(j)) {
            ans = 1 + method_1(s1, s2, i + 1, j + 1, dp);
        } else {
            ans = Math.max(method_1(s1, s2, i + 1, j, dp), method_1(s1, s2, i, j + 1, dp));
        }
        dp[i][j] = ans;
        return ans;
    }
}
