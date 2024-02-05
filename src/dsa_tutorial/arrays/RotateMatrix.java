package dsa_tutorial.arrays;

// https://www.scaler.com/topics/course/dsa-interviews-java/video/589/

import java.util.Arrays;

public class RotateMatrix {
    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        method(arr);
        for (int[] sol : arr){
            System.out.println(Arrays.toString(sol));
        }
    }
    static void method(int[][] arr){
        for (int i = 0; i < arr.length; i++){
            for (int j = i + 1; j < arr[0].length; j++){
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }

        // swapping matrix columns
        int left = 0, right = arr[0].length - 1;
        while (left < right) {
            for (int i = 0; i < arr.length; i++){
                int temp = arr[i][left];
                arr[i][left] = arr[i][right];
                arr[i][right] = temp;
            }
            left++;
            right--;
        }
    }
}
