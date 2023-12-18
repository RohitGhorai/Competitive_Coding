package hacker_rank;

/*
    Given an array arr[] of N integers and an integer K, our task is to find the length of the longest
    subarray such that for all possible pairs in the subarray absolute difference between elements is
    less than or equal to K.
*/

public class MaxSubArrayLength {
    public static void main(String[] args) {
        int ans = method1(new int[]{1,3,3,4,5,6}, 1);
        System.out.println(ans);
    }
    static int method1(int[] arr, int k){
        int maxLength = 0;
        for(int i = 0; i < arr.length; i++){
            int minOfSub = arr[i];
            int maxOfSub = arr[i];

            for(int j = i + 1; j < arr.length; j++){

                if(minOfSub > arr[j]) minOfSub = arr[j];
                if(maxOfSub < arr[j]) maxOfSub = arr[j];

                if((maxOfSub - minOfSub) <= k){
                    int currentLength = j - i + 1;
                    if(maxLength < currentLength) maxLength = currentLength;
                }
            }
        }
        return maxLength;
    }

    // Hacker Rank problem's solution using array frequencies
    static int method2(int[] arr, int k){
        int[] freq = new int[100];
        for (int j : arr) freq[j]++;
        int maxLengthOfArr = 0;
        for(int i = 0; i < freq.length - 1; i++){
            maxLengthOfArr = Math.max(maxLengthOfArr, freq[i] + freq[i+1]);
        }
        return maxLengthOfArr;
    }
}
