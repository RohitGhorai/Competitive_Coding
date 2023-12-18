package dsa;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {5,4,1,2,4,8,7};
        sort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static int partition(int[] arr, int low, int high){
        int start = low;
        int end = high;
        int pivot = arr[high];
        while(start <= end){
            while(arr[start] < pivot) start++;
            while(arr[end] > pivot) end--;
            if(start <= end){
                swap(arr, start, end);
                start++;
                end--;
            }
        }
        swap(arr, low, end);
        return end;
    }
    static void sort(int[] arr, int low, int high){
        if(low < high){
            int pivot = partition(arr, low, high);
            sort(arr, low, pivot);
            sort(arr, pivot+1, high);
        }
    }

//    static void sort(int[] arr, int li, int hi){
//        if(li >= hi) return;
//        int start = li;
//        int end = hi;
//        int mid = start + (end - start)/2;
//        int pivot = arr[mid];
//
//        while(start <= end){
//            while(arr[start] < pivot) start++;
//            while(arr[end] > pivot) end--;
//            if(start <= end){
//                int temp = arr[start];
//                arr[start] = arr[end];
//                arr[end] = temp;
//                start++;
//                end--;
//            }
//        }
//        sort(arr, li, end);
//        sort(arr, start, hi);
//    }
}
