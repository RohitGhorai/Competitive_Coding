package tcs_qn.easy;

import java.util.Arrays;

// Non-repeating element
public class Problem_8 {
    public static void main(String[] args) {
        int[] arr = {-1,2,-1,3,2};
        int ans = method_1(arr);
        System.out.println(ans);
    }
    static int method_1(int[] arr){
        int[] count = new int[arr.length];
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr.length; j++){
                if (i != j && arr[i] == arr[j]) count[i]++;
            }
        }
        System.out.println(Arrays.toString(count));
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0) return arr[i];
        }
        return 0;
    }

    static int method_2(int[] arr){
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j <= arr.length; j++){
                if (j == arr.length) return arr[i];
                if (i != j && arr[i] == arr[j]) break;
            }
        }
        return 0;
    }
}
