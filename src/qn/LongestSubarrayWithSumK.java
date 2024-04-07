package qn;

import java.util.*;

public class LongestSubarrayWithSumK {
    public static void main(String[] args) {
        int[] a = {-1,1,1};
        int k = 1;
        int ans = getLongestSubarray(a, k);
        System.out.println(ans);
    }
    static int getLongestSubarray(int[] nums, int k){
        Map<Integer, Integer> map = new HashMap<>();
        int maxLen = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
            if (sum == k) maxLen = Math.max(maxLen, i + 1);
            int rem = sum - k;
            if (map.containsKey(rem)) maxLen = Math.max(maxLen, i - map.get(rem));
            if (!map.containsKey(rem)) map.put(sum, i);
        }
        return maxLen;
    }

    static int method_2(int[] nums, int k){
        int maxLen = Integer.MIN_VALUE;
        int n = nums.length;
        for (int i = 0; i < n; i++){
            int sum = 0;
            for (int j = i; j < n; j++){
                sum += nums[j];
                if (sum == k) maxLen = Math.max(maxLen, j - i + 1);
            }
        }
        return maxLen;
    }
}
