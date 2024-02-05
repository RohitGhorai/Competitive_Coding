package dsa;

import java.util.*;

class Solution {
    public static void main(String[] args) {
//        List<List<Integer>> all = permute(new int[]{1,2,3});
//        for (List<Integer> l : all){
//            System.out.println(l);
//        }
//        System.out.println(all.size());
        int[] ans = nextGreaterElement2(new int[]{50,40,60,80,40});
        System.out.println(Arrays.toString(ans));
    }
    static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
//        permutation(0, nums, result);
        method_3(nums, new ArrayList<>(), result);
        return result;
    }
    static void permutation(int i, int[] nums, List<List<Integer>> result) {
        if (i == nums.length - 1) {
            List<Integer> list = new ArrayList<>();
            for (int n : nums) list.add(n);
            result.add(list);
        } else {
            for (int j = i; j < nums.length; j++) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                permutation(i + 1, nums, result);
                temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
        }
    }
    /*static void method_2(int[] arr, int i, List<List<Integer>> result){
        if (i == arr.length){
            List<Integer> list = new ArrayList<>();
            for (int val : arr) list.add(val);
            result.add(list);
            return;
        }
        for (int j = i; j < arr.length; j++){
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
            method_2(arr, i + 1, result);
            temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }
    }*/

    static void method_3(int[] nums, List<Integer> templist, List<List<Integer>> result){
        if (templist.size() == nums.length){
            result.add(new ArrayList<>(templist));
            return;
        }
        for (int val : nums){
            if (templist.contains(val)) continue;
            // Add the new element
            templist.add(val);
            // Go back try to another element
            method_3(nums, templist, result);
            // Remove the element
            templist.remove(templist.size() - 1 );
        }
    }
    static int[] nextGreaterElement(int[] nums){
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[nums.length];
        st.push(0);
        for (int i = 1; i < nums.length; i++){
            // remove all smaller element
            while(st.size() > 0 && nums[st.peek()] < nums[i]) {
                ans[st.peek()] = nums[i];
                st.pop();
            }
            st.push(i);
        }
        while (st.size() > 0) ans[st.pop()] = -1;
        return ans;
    }
    static int[] nextGreaterElement2(int[] nums){
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--){
            // pop all smaller element
            while (st.size() > 0 && st.peek() < nums[i]) st.pop();
            // update the element
            if (st.size() == 0) ans[i] = -1;
            else ans[i] = st.peek();
            st.push(nums[i]);
        }
        return ans;
    }
}
