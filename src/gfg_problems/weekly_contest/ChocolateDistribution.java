package gfg_problems.weekly_contest;


import java.util.Arrays;

public class ChocolateDistribution {
    public static void main(String[] args) {
        int[] arr = {2,3};
        int[] brr = {1,2,1,2,1,4,2,2};
        int ans = satisfiedChildren(arr.length, brr.length, arr, brr);
        System.out.println(ans);
    }
    static int satisfiedChildren(int n, int c, int[] arr, int[] brr){
        if (arr.length == 0 || brr.length == 0) return 0;
        Arrays.sort(arr);
        Arrays.sort(brr);
        int satisfied = 0;
        int chocolateIndex = 0;
        while (satisfied < n && chocolateIndex < c){
            if (arr[satisfied] <= brr[chocolateIndex]){
                satisfied++;
                chocolateIndex++;
            } else chocolateIndex++;
        }
        return satisfied;
    }
}
