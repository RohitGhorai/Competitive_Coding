package dsa_tutorial;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        int[] arr = new int[]{2,2,1};
//        int[] ans = sort(arr);
//        System.out.println(Arrays.toString(ans));
//        quickSort(arr, 0, arr.length - 1);
//        bubbleSort(arr);
//        selectionSort(arr);
//        int ans = binarySearch(arr, 0, arr.length - 1, 9);
//        System.out.println(ans);
//        System.out.println(Arrays.toString(sort_2(arr)));
//        System.out.println(BinaryNumbers("001"));
    }

    static  int BinaryNumbers(String s) {
        int one = 0, wait = 0, ans = 0;
        for(int i = 0; i < s.length(); i++) {
            char it = s.charAt(i);
            if(it=='1') {
                one++;
                if(wait > 0) wait--;
            } else {
                if(one > 0) {
                    ans = Math.max(ans, one + wait);
                    wait++;
                }
            }
        }
        return ans;
    }


    static int[] sort_2(int[] arr){
        if (arr.length == 1) return arr;

        int max = arr[0];
        for (int val : arr) max = Math.max(max, val);

        int[] freq = new int[max + 1];
        for (int val : arr) freq[val]++;

        int j = 0;
        for (int i = 0; i < freq.length; i++){
            if (freq[i] != 0){
                arr[j] = i;
                j++;
                if (freq[i] > 1){
                    for (int k = 1; k < freq[i]; k++){
                        arr[j] = i;
                        j++;
                    }
                }
            }
        }
        return arr;
    }
    static int[] sort(int[] arr){
        if (arr.length == 1) return arr;
        int mid = arr.length / 2;
        int[] left = sort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = sort(Arrays.copyOfRange(arr, mid, arr.length));
//        int[] left = new int[mid];
//        for (int i = 0; i < left.length; i++){
//            left[i] = arr[i];
//        }
//        left = sort(left);
//        int[] right = new int[arr.length - mid];
//        for (int i = 0; i < right.length; i++){
//            right[i] = arr[mid + i];
//        }
//        right = sort(right);
        return merge(left, right);
    }
    static int[] merge(int[] first, int[] second){
        int[] mix = new int[first.length + second.length];
        int i = 0, j = 0, k = 0;
        while (i < first.length && j < second.length){
            if (first[i] < second[j]) {
                mix[k] = first[i];
                i++;
            } else {
                mix[k] = second[j];
                j++;
            }
            k++;
        }
        while (i < first.length){
            mix[k] = first[i];
            i++;
            k++;
        }
        while (j < second.length){
            mix[k] = second[j];
            j++;
            k++;
        }
        return mix;
    }

    static void quickSort(int[] arr, int low, int high){
        if (low >= high) return;
        int start = low;
        int end = high;
        int mid = start + (end - start)/2;
        int pivot = arr[mid];
        while (start <= end){
            while (arr[start] < pivot) start++;
            while (arr[end] > pivot) end--;
            if (start <= end){
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }
        quickSort(arr, start, high);
        quickSort(arr, low, end);
    }

    static void bubbleSort(int[] arr){
        for (int i = 0; i < arr.length; i++){
            for (int j = 1; j < arr.length - i; j++){
                if (arr[j - 1] > arr[j]){
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    static void selectionSort(int[] arr){
        for (int i = 0; i < arr.length; i++){
            int min = i;
            for (int j = i + 1; j < arr.length; j++){
                if (arr[j] < arr[min]) min = j;
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }
    static void swap(int[] arr, int first, int sec){
        int temp = arr[first];
        arr[first] = arr[sec];
        arr[sec] = temp;
    }

    static int binarySearch(int[] arr, int start, int end, int target){
        if (start > end) return -1;
        int mid = start + (end - start)/2;
        if (arr[mid] == target) return mid;
        return (arr[mid] > target) ? binarySearch(arr, start, mid - 1, target) : binarySearch(arr, mid + 1, end, target);
    }
}
