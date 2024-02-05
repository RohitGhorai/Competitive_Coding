package dsa_tutorial.sorting;

import java.util.Arrays;

public class CountSort {
    public static void main(String[] args) {
        int[] arr = {2,4,51,6,3,7,1};
        int[] ans = sort(arr);
        System.out.println(Arrays.toString(ans));
    }
    static int[] sort(int[] arr){
        int n = arr.length;
        int max = arr[0];

        for (int val : arr) max = Math.max(max, val);
        int[] freq = new int[max + 1];

        for (int val : arr) freq[val]++;

        for (int i = 1; i < freq.length; i++) freq[i] = freq[i - 1] + freq[i];

        int[] ans = new int[n];
        for (int i = n - 1; i >= 0; i--){
            int pos = freq[arr[i]];
            ans[pos - 1] = arr[i];
            freq[arr[i]]--;
        }
        return ans;
    }
}
