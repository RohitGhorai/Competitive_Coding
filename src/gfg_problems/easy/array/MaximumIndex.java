package gfg_problems.easy.array;

import java.util.Arrays;

public class MaximumIndex {
    public static void main(String[] args) {
        int[] arr = {34, 8, 10, 3, 2, 80, 30, 33, 1};
        int n = arr.length;
        int ans = maxIndex(arr, n);
        System.out.println(ans);
    }
    static int maxIndex(int[] arr, int n){
        if (n == 1) return 0;

        int[] leftMin = new int[n];
        int[] rightMax = new int[n];

        leftMin[0] = arr[0];
        for (int i = 1; i < n; i++) leftMin[i] = Math.min(leftMin[i-1], arr[i]);

        rightMax[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) rightMax[i] = Math.max(rightMax[i+1], arr[i]);

        //System.out.println(Arrays.toString(leftMin));
        //System.out.println(Arrays.toString(rightMax));

        int maxDiff = -1;
        int i = 0, j = 0;
        while (i < n && j < n){
            if (leftMin[i] <= rightMax[j]) {
                maxDiff = Math.max(maxDiff, j - i);
                j++;
            }
            else i++;
        }
        return maxDiff;
    }
}
