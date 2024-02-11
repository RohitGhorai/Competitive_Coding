package qn;

import java.util.*;

public class Problem_1 {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10,10};
        List<Integer> list = method(nums, 0, nums.length - 1, 10, new ArrayList<>());
        if (list.isEmpty()) {
            list.add(-1);
            list.add(-1);
        } else Collections.sort(list);
        System.out.println(Arrays.toString(list.toArray()));
    }
    static List<Integer> method(int[] nums, int s, int e, int target, List<Integer> ans){
        if (s > e || ans.size() == 2) return ans;
        int mid = s + (e - s)/2;
        if (nums[mid] == target) ans.add(mid);
        if (nums[mid] > target) {
            if (nums[s] == target) if(!ans.contains(s)) ans.add(s);
            return  method(nums, s, mid - 1, target, ans);
        } else {
            if (nums[e] == target) if(!ans.contains(e)) ans.add(e);
            return method(nums, mid + 1, e, target, ans);
        }
    }
}

