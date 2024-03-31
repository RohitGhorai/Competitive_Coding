package leetcode.array;
import java.util.*;

// Leetcode: https://leetcode.com/problems/subarrays-with-k-different-integers/

public class Problem_992 {
    public static void main(String[] args) {
        int[] nums = {1,2,1,2,3};
        int k = 2;
        int ans = subarraysWithKDistinct(nums, k);
        System.out.println(ans);
    }
    static int subarraysWithKDistinct(int[] nums, int k){
        return solve(nums, k) - solve(nums, k-1);
    }
    static int solve(int[] nums, int k){
        int res = 0;
        int right = 0;
        int left = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (right < nums.length) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while (map.size() > k){
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) map.remove(nums[left]);
                left++;
            }
            if (map.size() <= k) res += right - left + 1;
            right++;
        }
        return res;
    }
}
