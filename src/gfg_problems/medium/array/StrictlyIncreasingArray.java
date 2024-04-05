package gfg_problems.medium.array;

import java.util.Arrays;

public class StrictlyIncreasingArray {
    public static void main(String[] args) {
        int[] nums = {1,2,10,9};
        int ans = solution(nums);
        System.out.println(ans);
    }
    static int solution(int[] nums){
        int n = nums.length;
        int maxI = 1;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++){
            for (int j = 0; j < i; j++){
                if (nums[i] > nums[j] && nums[i] - nums[j] >= j - i){
                    dp[i] = Math.max(1 + dp[j], dp[i]);
                    maxI = Math.max(maxI, dp[i]);
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return n - maxI;
    }
}
