package gfg_problems.easy.array;

public class EqilibriiumPoint {
    public static int equilibriumPoint(long arr[], int n) {
        long sum1 = 0, sum2 = 0;
        for (int i = 0; i < n; i++) sum1 += arr[i];
        for (int i = 0; i < n; i++){
            sum1 -= arr[i];
            if (sum1 == sum2) return i+1;
            sum2 += arr[i];
        }
        return -1;
    }
}
