package dsa_tutorial.dynamic_programming;

public class MaximumSubarraySum {
    public static void main(String[] args) {
        int[] arr = {2,-3,5,-2,6,-8,2,1,9,-6,4};
        System.out.println(method_1(arr));
    }

    // Kadane's Algorithm      [ Time Complexity = O(n) & Space Complexity = O(1) ]
    static int method_1(int[] arr){
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++){
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
}
