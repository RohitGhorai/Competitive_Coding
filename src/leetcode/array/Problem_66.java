package leetcode.array;

import java.util.Arrays;

public class Problem_66 {
    public static void main(String[] args) {
        int[] arr = {9,9};
        int[] ans = plusOne_2(arr);
        System.out.println(Arrays.toString(ans));
    }

    static int[] plusOne_2(int[] nums){
        for (int i = nums.length - 1; i >= 0; i--){
            if (nums[i] == 9) nums[i] = 0;
            else if (nums[i] >= 0) {
                nums[i] = nums[i] + 1;
                return nums;
            }
        }
        int[] b = new int[nums.length + 1];
        b[0] = 1;
        return b;
    }

    // Using recursion
    static int[] plusOne(int[] nums){
        helper(nums, nums.length - 1);
        if (nums[0] == 0){
            nums = new int[nums.length + 1];
            nums[0] = 1;
        }
        return nums;
    }
    static void helper(int[] arr, int i){
        if (i < 0) return;
        if (arr[i] == 9){
            arr[i] = 0;
        } else {
            arr[i] = arr[i] + 1;
            return;
        }
        helper(arr, i - 1);
    }
}
