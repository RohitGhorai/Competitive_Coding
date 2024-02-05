package dsa_tutorial.dynamic_programming;

public class MaxSubArraySum_2 {
    public static void main(String[] args) {
//        int[] arr = {1,-4,-3,2};
        int[] arr = {-1,4,3,-2};
        int ans = maxSum(arr, 3);
        System.out.println(ans);
    }
    static int maxSum(int[] arr, int k){
        if (k == 1) return kadane(arr, 1);
        else {
            int sum = 0;
            for (int val : arr) sum += val;

            if (sum > 0) return (k - 2)*sum + kadane(arr, 2);
            else return kadane(arr, 2);
        }
    }

    // Kadane's Algorithm
    static int kadane(int[] arr, int m){
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length * m; i++){
            currSum = Math.max(currSum + arr[i % arr.length], arr[i % arr.length]);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
}
