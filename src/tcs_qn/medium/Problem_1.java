package tcs_qn.medium;

/*
Given an array Arr[] of N integers and a positive integer K. The task is to cyclically rotate the array clockwise by K.
 */

import java.util.*;

public class Problem_1 {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40};
        int k = 2;
        method_1(arr, k);
        System.out.println(Arrays.toString(arr));
    }
    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static void method_1(int[] arr, int j){
        int n = arr.length;
        for (int i = 0; i < 2*arr.length+j; i++){
            swap(arr, i % n, (i + j) % n);
        }
    }

    /*
    static List<Integer> rotate(int[] arr, int k){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length*2; i++){
            if (list.size() == arr.length) return list;
            list.add(arr[(arr.length - k + i)%arr.length]);
        }
        return list;
    }
     */

    static int[] method_2(int[] arr, int d){
        int[] ans = new int[arr.length];
        int j = 0;
        for (int i = arr.length - d; i < arr.length * 2; i++){
            ans[j] = arr[i % arr.length];
            j++;
            if (j == ans.length) break;
        }
        return ans;
    }
}
