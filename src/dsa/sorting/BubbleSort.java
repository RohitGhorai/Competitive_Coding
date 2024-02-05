package dsa.sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 13, 2, 1};
        bubble(arr, arr.length - 1, 0);
        System.out.println(Arrays.toString(arr));
    }
    static int[] sort(int[] arr){
        int temp = 0;
        for(int j = 0; j < arr.length; j++){
            for(int i = 1; i < arr.length-j; i++){
                if(arr[i-1] > arr[i]){
                    temp = arr[i-1];
                    arr[i-1] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        return arr;
    }
    // Bubble Sort using recursive approach
    static void bubble(int[] arr, int r, int c){
        if(r == 0) return;
        if(r > c){
            if(arr[c] > arr[c + 1]){
                int temp = arr[c];
                arr[c] = arr[c + 1];
                arr[c + 1] = temp;
            }
            bubble(arr, r, c + 1);
        } else {
            bubble(arr, r - 1, 0);
        }
    }
    /*static void pattern(int r, int c){
        if(r == 0) return;
        if(r > c){
            System.out.print("*");
            pattern(r, c+1);
        } else {
            System.out.println();
            pattern(r-1, 0);
        }
    }
    static void pattern2(int r, int c){
        if(r == 0) return;
        int num = c;
        while(num > 0){
            System.out.print("*");
            num--;
        }
        System.out.println();
        pattern2(r-1, c+1);
    }*/
}
