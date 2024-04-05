package qn;

import java.util.Arrays;

public class RotateArr {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        int k = 3;
        rotateRight(arr, arr.length, k);
        System.out.println(Arrays.toString(arr));
    }

    static void rotateLeft(int[] arr, int n, int k){
        reverse(arr, 0, n-1);
        reverse(arr, n-k, n-1);
        reverse(arr, 0, n-k-1);
    }
    static void rotateRight(int[] arr, int n, int k){
        reverse(arr, 0, n-k-1);
        reverse(arr, n-k, n-1);
        reverse(arr, 0, n-1);
    }
    static void reverse(int[] arr, int start, int end){
        while (start <= end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
