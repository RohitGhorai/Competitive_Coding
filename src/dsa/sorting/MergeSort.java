package dsa.sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args){
        int[] arr = {45, 34, 32, 24, 40, 45};
        int[] ans = mergeSort(arr);
        System.out.println(Arrays.toString(ans));
    }

    static int[] mergeSort(int[] arr){
        if(arr.length == 1) return arr;

        int mid = arr.length / 2;

        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));
        return merge(left, right);

        /*
        int[] left = new int[mid];
        for(int i = 0; i < left.length; i++){
            left[i] = arr[i];
        }
        int[] first = mergeSort(left);
        int[] right = new int[arr.length - mid];
        for(int i = 0; i < right.length; i++){
            right[i] = arr[mid + i];
        }
        int[] second = mergeSort(right);

        return merge(first, second);
        */
    }

    static int[] merge(int[] first, int[] second){
        int[] mix = new int[first.length + second.length];
        int i = 0;
        int j = 0;
        int k = 0;

        while(i < first.length && j < second.length){
            if(first[i] < second[j]){
                mix[k] = first[i];
                i++;
            } else {
                mix[k] = second[j];
                j++;
            }
            k++;
        }

        while(i < first.length){
            mix[k] = first[i];
            i++;
            k++;
        }
        while(j < second.length){
            mix[k] = second[j];
            j++;
            k++;
        }

        return mix;
    }
}

