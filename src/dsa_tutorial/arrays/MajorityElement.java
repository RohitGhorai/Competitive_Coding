package dsa_tutorial.arrays;

import java.util.Arrays;

public class MajorityElement {
    public static void main(String[] args) {
        int[] arr = {3,2,3};
        int majorElement = method_1(arr, arr.length);
        System.out.println(majorElement);
    }

    // Moore's voting algorithm
    static int method_1(int[] arr, int n){
//        Arrays.sort(arr);
        int candidate = arr[0];
        int count = 1;
        for (int i = 1; i < n; i++){
            if (arr[i] == candidate) count++;
            else count--;

            if (count == 0) {
                candidate = arr[i];
                count++;
            }
        }
        // Checking if majority candidate occurs more than n / 2 times
        count = 0;
        for (int val : arr) {
            if (val == candidate) count++;
        }
        if (count > n/2) return candidate;
        else return -1;
    }
    static int method_2(int[] nums){
        int count = 0;
        int candidate = recursion(nums, 1, nums[0], 1);
        for (int val : nums)
            if (val == candidate) count++;
        if (count > nums.length/2) return candidate;
        return -1;
    }
    static int recursion(int[] arr, int count, int candidate, int idx){
        if (idx == arr.length) return candidate;
        if (arr[idx] == candidate) count++;
        else count--;
        if (count == 0){
            candidate = arr[idx];
            count++;
        }
        return recursion(arr, count, candidate, idx + 1);
    }
}
