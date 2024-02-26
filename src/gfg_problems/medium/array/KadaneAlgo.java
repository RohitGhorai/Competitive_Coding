package gfg_problems.medium.array;

public class KadaneAlgo {
    public static void main(String[] args) {
        int[] arr = {1,2,3,-2,5};
        long ans = maxSubarraySum(arr, arr.length);
        System.out.println(ans);
    }
    static long maxSubarraySum(int[] arr, int n){
        long maxEnding = arr[0];
        long maxSoFar = arr[0];
        for (int i = 1; i < n; i++){
            maxEnding = Math.max(arr[i], maxEnding + arr[i]);
            maxSoFar = Math.max(maxSoFar, maxEnding);
        }
        return maxSoFar;
    }
}
