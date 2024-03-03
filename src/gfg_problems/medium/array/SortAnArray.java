package gfg_problems.medium.array;

import java.util.Arrays;

public class SortAnArray {
    public static void main(String[] args) {
        int[] arr = {0,2,1,2,0,1};
        sort012(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
    static void sort012(int a[], int n) {
        int low = 0, mid = 0, high = n - 1;

        while (mid <= high) {
            switch (a[mid]) {
                case 0:
                    swap(a, low, mid);
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(a, mid, high);
                    high--;
                    break;
            }
        }
    }

    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
