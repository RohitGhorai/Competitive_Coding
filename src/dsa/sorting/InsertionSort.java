package dsa.sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {5,4,9,2,1,8};
        int[] ans = insertionSort(arr);
        System.out.println(Arrays.toString(ans));
    }
    static int[] insertionSort(int[] arr){
        for (int i = 1; i < arr.length; i++){
            int j = i;
            while (j > 0 && arr[j-1] > arr[j]){
                int temp = arr[j-1];
                arr[j-1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }
        return arr;
    }
}
