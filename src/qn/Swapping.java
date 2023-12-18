package qn;

import java.util.Arrays;

public class Swapping {
    public static void main(String[] args) {
        int[] arr = {2, 3};
        swap(arr, 0, 1);
        System.out.println(Arrays.toString(arr));
    }
    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
