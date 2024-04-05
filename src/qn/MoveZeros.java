package qn;

import java.util.Arrays;

// {2,1,0,4,0,5,6,0,0} => {2,1,4,0,5,6,0,0} => {2,1,4,5,0,6,0,0} => {2,1,4,5,6,0,0,0,0}
// {2,1,4,5,6,0,0,0,0}

public class MoveZeros {
    public static void main(String[] args) {
        int[] nums = {2,1,0,4,0,5,6,0,0};
        moveZeros(nums, nums.length);
        System.out.println(Arrays.toString(nums));
    }
    static void moveZeros(int[] nums, int n){
        int j = 0;
        while (j < n){
            if (nums[j] == 0) break;
            j++;
        }
        for (int i = j + 1; i < n; i++){
            if (nums[i] != nums[j]) {
                swap(nums, i, j);
                j++;
            }
        }
    }
    static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
