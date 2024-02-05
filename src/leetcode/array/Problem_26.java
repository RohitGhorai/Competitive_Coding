package leetcode.array;

import java.util.Arrays;

// Remove duplicate element
public class Problem_26 {
    public static void main(String[] args) {
        int[] arr = {0, 3, 1, 2, 0, 5, 2, 2};
//        Arrays.sort(arr);
//        int ans = removeDuplicates(arr);
//        int ans = distinctElement(arr, 1, 1);
//        System.out.println("\n" + ans);
//        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(plusOne(new int[]{9,9, 2})));

    }
    static int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++){
            if (nums[i] != nums[j]) {
                nums[i+1] = nums[j];
                if (i == 0) System.out.print(nums[i] + " ");
                System.out.print(nums[j] + " ");
                i++;
            }
        }
        return i+1;
    }
    static int distinctElement(int[] arr, int i, int count){
        if (i == arr.length) {
            System.out.print(arr[i-1] + " ");
            return count;
        }
        if(arr[i - 1] != arr[i]) {
            arr[count] = arr[i];
            System.out.print(arr[i-1] + " ");
            return  distinctElement(arr, i + 1, count + 1);
        } else return distinctElement(arr, i + 1, count);
    }
    static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--){
            if(digits[i] == 9){
                digits[i] = 0;
            } else {
                digits[i] = digits[i] + 1;
                return digits;
            }
        }
        int[] b = new int[digits.length + 1];
        b[0] = 1;
        return b;
    }
}
