package dsa;

import java.util.Arrays;

public class Practice {
    public static void main(String[] args) {
//        if(!isPrime2(29)) System.out.println("is a prime number.");
//        else System.out.println("is not a prime number.");
        int[] arr = {6,4,3,7,2,1};
//        quickSort(arr, 0, arr.length-1);
//        System.out.println(Arrays.toString(arr));
//        selection2(arr, arr.length, 0, 0);
        bubble(arr, arr.length, 1);
        System.out.println(Arrays.toString(arr));
    }
    static boolean isPrime(int n){
        for(int i = 2; i <= n/2; i++) if (n % i == 0) return true;
        return false;
    }
    static boolean isPrime2(int n){
        int i = 2;
        while(n > i) {
            if (n % i == 0) return true;
            if(i == n/2 && n % i != 0) return false;
            i++;
        }
        return false;
    }
    static int binarySearch(int[] arr, int start, int end, int target){
        if(start > end) return -1;
        int mid = start + (end - start)/2;
        if(target == arr[mid]) return mid;
        return ((arr[mid] > target) ? binarySearch(arr, 0, mid-1, target) : binarySearch(arr, mid + 1, end, target));
    }
    static void insertionSort(int[] arr){
        for(int i = 1; i < arr.length; i++){
            int j = i - 1;
            int temp = arr[i];
            while (j >= 0 && temp < arr[j]){
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }
    static void selectionSort(int[] arr){
        for(int i = 0; i < arr.length; i++){
            int min = i;
            for (int j = i + 1; j < arr.length; j++){
                if(arr[j] < arr[min]) min = j;
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }
    //Using recursion approach
    static void selection2(int[] arr, int row, int col, int max){
        if(row == 0) return;
        if(row > col){
            if (arr[max] < arr[col]) max = col;
            selection2(arr, row, col + 1, max);
        } else {
            int temp = arr[max];
            arr[max] = arr[row-1];
            arr[row-1] = temp;
            selection2(arr, row - 1, 0, 0);
        }
    }
    static void bubbleSort(int[] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 1; j < arr.length - i; j++){
                if(arr[j] < arr[j - 1]){
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }
    //Using recursion approach
    static void bubble(int[] arr, int row, int col){
        if(row == 0) return;
        if(row > col){
            if (arr[col] < arr[col - 1]){
                int temp = arr[col - 1];
                arr[col - 1] = arr[col];
                arr[col] = temp;
            }
            bubble(arr, row, col + 1);
        } else bubble(arr, row - 1, 1);
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
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }
        quickSort(arr, start, hi);
        quickSort(arr, li, end);
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
        int i = 0, j = 0, k = 0;
        while (i < first.length && j < second.length){
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
