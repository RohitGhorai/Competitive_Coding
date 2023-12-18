package qn;

import java.util.Arrays;

public class RemoveDuplicateElement {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countUnique(new int[]{1,1,2,2,3,4,5,5})));
    }
    static int removeDuplicate(int[] arr){
        int j = 1;
        for(int i = 1; i < arr.length; i++){
            if(arr[i] != arr[i-1]){
                arr[j] = arr[i];
                j++;
            }
        }
        return j;
    }
    static int[] countUnique(int[] nums){
        int count = 0;
        int[] freq = new int[1000];
        Arrays.fill(freq, 0);
        for (int i = 0; i < nums.length; i++){
            freq[nums[i]]++;
        }
        for (int i = 0; i < freq.length; i++){
            if(freq[i] != 0) count++;
        }
        int[] arr = new int[count];
        int index = 0;
        for (int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i-1]) {
                arr[index] = nums[i];
                index++;
                continue;
            }
//            arr[index] = nums[i];
//            if(nums[i] != nums[i-1]) {
//                arr[index] = nums[i];
//                index++;
//            }
        }
        return arr;
    }
}
