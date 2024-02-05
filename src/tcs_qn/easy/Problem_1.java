package tcs_qn.easy;

import java.util.*;

/*
Problem Statement –

A chocolate factory is packing chocolates into the packets. The chocolate packets here represent an array  of N number of integer values.
The task is to find the empty packets(0) of chocolate and push it to the end of the conveyor belt(array).

Example 1 :

N=8 and arr = [4,5,0,1,9,0,5,0].
There are 3 empty packets in the given set. These 3 empty packets represented as O should be pushed towards the end of the array

Input :

8  – Value of N
[4,5,0,1,9,0,5,0] – Element of arr[O] to arr[N-1],While input each element is separated by newline

Output:

4 5 1 9 5 0 0 0
 */

public class Problem_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        method_1(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static void method_1(int[] arr){
        for (int j = 0; j < arr.length; j++){
            for (int i = 1; i < arr.length; i++){
                if (arr[i-1] == 0) swap(arr, i-1,i);
            }
        }
    }
}
