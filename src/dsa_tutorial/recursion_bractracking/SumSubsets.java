package dsa_tutorial.recursion_bractracking;

import java.util.ArrayList;

public class SumSubsets {
    public static void main(String[] args) {
        int[] arr = {10, 20, 25, 5, 30, 40, 50};
        int target = 50;
        method_1(arr, 0, target, new ArrayList<Integer>());
//        permutation(new int[]{1, 2, 3}, 0, new boolean[]{false, false, false}, new ArrayList<>());
//        permut("123", "");
    }
    static void method_1(int[] arr, int i, int target, ArrayList<Integer> ans) {
        if (target < 0) return;
        if (i == arr.length) {
            if (target == 0) System.out.println(ans);
            return;
        }
        ans.add(arr[i]);
        method_1(arr, i + 1, target - arr[i], ans);
        ans.remove(ans.size() - 1);
        method_1(arr, i + 1, target, ans);
    }
    static void permutation(int[] arr, int pos, boolean[] selected, ArrayList<Integer> ans){
        if (pos == arr.length) {
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < arr.length; i++){
            if (!selected[i]){
                selected[i] = true;
                ans.add(arr[i]);
                permutation(arr, pos + 1, selected, ans);
                selected[i] = false;
                ans.remove(ans.size() - 1);
            }
        }
    }
    static void permut(String str, String s){
        if (str.length() == 0) {
            System.out.println(s);
            return;
        }
        for (int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            String str2 = str.substring(0, i) + str.substring(i+1);
            permut(str2, s + ch);
        }
    }
}
