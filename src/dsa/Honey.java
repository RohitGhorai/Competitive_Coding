package dsa;

import java.util.Arrays;

public class Honey {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        insertion(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void pattern1(int r, int c){
        if(r == 0) return;
        int num = c;
        while(num > 0){
            System.out.print("*");
            num--;
        }
        System.out.println();
        pattern1(r-1, c+1);
    }
    static void pattern2(int r, int c){
        if(r == 0) return;
        if(r > c){
            System.out.print("*");
            pattern2(r, c+1);
        } else {
            System.out.println();
            pattern2(r-1, 0);
        }
    }
    static void bubble(int[] arr, int r, int c){
        if(r == 0) return;
        if(r > c){
            if(arr[c] > arr[c+1]){
                swap(arr, c, c+1);
            }
            bubble(arr, r, c+1);
        } else {
            bubble(arr, r-1, 0);
        }
    }
    static void selection(int[] arr, int r, int c, int max){
        if(r == 0) return;
        if(r > c){
            if(arr[c] > arr[max]) selection(arr, r, c+1, c);
            else selection(arr, r, c+1, max);
        } else {
            swap(arr, max, r-1);
            selection(arr, r-1, 0, 0);
        }
    }
    static void insertion(int[] arr){
        for(int i = 1; i < arr.length; i++){
            int j = i - 1;
            int temp = arr[i];
            while(j >= 0 && temp < arr[j]){
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }
    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static int[] mergeSort(int[] arr){
        if(arr.length == 1) return arr;
        int mid = arr.length/2;

        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left, right);
    }
    static int[] merge(int[] first, int[] second){
        int[] mix = new int[first.length + second.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while(i < first.length && j < second.length){
            if(first[i] > second[j]){
                mix[k] = second[j];
                j++;
            } else {
                mix[k] = first[i];
                i++;
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
    static void quickSort(int[] arr, int li, int hi){
        if(li >= hi) return;
        int start = li;
        int end = hi;
        int mid = start + (end - start)/2;
        int pivot = arr[mid];
        while(start <= end){
            while(arr[start] < pivot) start++;
            while(arr[end] > pivot) end--;
            if(start <= end){
                swap(arr, start, end);
                start++;
                end--;
            }
        }
        quickSort(arr, start, hi);
        quickSort(arr, li, end);
    }
}
