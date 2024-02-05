package tcs_qn.easy;

import java.util.Arrays;

// Rotate array
public class Problem_9 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int[] ans = method_1(arr, 2);
        System.out.println(Arrays.toString(ans));
    }
    static int[] method_1(int[] arr, int d){
        int[] ans = new int[arr.length];
        int j = 0;
        for (int i = d; i < arr.length * 2; i++){
            ans[j] = arr[i % arr.length];
            j++;
            if (j == ans.length) break;
        }
        return ans;
    }
}
