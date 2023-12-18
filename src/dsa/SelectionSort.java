package dsa;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 13, 2, 11};
        sort3(arr, arr.length, 0, 0);
        System.out.println(Arrays.toString(arr));
    }
    // Selection Sort using recursive approach
    static void sort3(int[] arr, int r, int c, int max){
        if(r == 0) return;
        if(r > c){
            if(arr[c] > arr[max]){
                sort3(arr, r, c+1, c);
            } else {
                sort3(arr, r, c+1, max);
            }
        } else {
            int temp = arr[max];
            arr[max] = arr[r - 1];
            arr[r - 1] = temp;

            sort3(arr, r - 1, 0, 0);
        }
    }
    static int[] sort(int[] arr){
        int temp = 0;
        for(int i = 0; i < arr.length; i++){
            int min = i;
            for(int j = i + 1; j < arr.length; j++){
                if(arr[j] < arr[min]) min = j;
            }
            temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
        return arr;
    }

    static int[] sort2(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    /*
    static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
    static void selectionSort(int[] arr, int n){
        if(n == 1) return;
        for(int i = 0; i < n; i++) {
            int max = n-i-1;
            for(int j = 0; j < n - i; j++) if(arr[j] > arr[max]) max = j;
            swap(arr, max, n-i-1);
        }
    }
     */
}
