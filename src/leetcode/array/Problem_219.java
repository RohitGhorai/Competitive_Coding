package leetcode.array;

import java.util.*;

public class Problem_219 {
    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2));
    }
    static boolean containsNearbyDuplicate(int[] nums, int k){
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++){
            if (i > k) set.remove(nums[i-k-1]);
            if (!set.add(nums[i])) return true;
        }
        return false;
    }
}
