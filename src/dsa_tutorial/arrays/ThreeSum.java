package dsa_tutorial.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class ThreeSum {
    public static void main(String[] args) {
//        int[] arr = {7, -6, 3, 8, -1, 8, -11};
//        int target = 0;
//        method_1(arr, target);
        ArrayList<Integer> A = new ArrayList<>();
        int[] arr = {23, 20, 0, 21, 3, 38, 35, -6, 2, 5, 4, 21};
        for (int val : arr) {
            A.add(val);
        }
        ArrayList<ArrayList<Integer>> B = fourSum(A, 29);
        for (int i = 0; i < B.size(); i++){
            System.out.println(Arrays.toString(B.get(i).toArray()));
        }
    }

    static void method_1(int[] arr, int target) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++){
            if (i == 0 || arr[i] != arr[i - 1]) {
                int j = i + 1;
                int k = arr.length - 1;
                while (j < k){
                    if (arr[j] + arr[k] == target - arr[i]) {
                        System.out.println(arr[i] + " " + arr[j] + " " + arr[k]);
                        while (j < k && arr[j] == arr[j + 1]) j++;
                        while (j < k && arr[k] == arr[k - 1]) k--;
                        j++;
                        k--;
                    } else if (arr[j] + arr[k] < target - arr[i]) {
                        j++;
                    } else k--;
                }
            }
        }
    }

    static ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> A, int target) {
        int n = A.size();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = A.get(i);
        }
        Arrays.sort(arr);
        for (int i = 0; i < n; i++){
            if (i == 0 || arr[i] != arr[i - 1]){
                for (int b = i + 1; b < arr.length; b++){
                    if (b == i + 1 || arr[b] != arr[b - 1]) {
                        int c = i + 1;
                        int d = arr.length - 1;
                        while (c < d){
                            int sum = arr[i] + arr[b] + arr[c] + arr[d];
                            if (sum == target) {
//                                saveVal(ans, new int[]{arr[i], arr[b], arr[c], arr[d]});
                                ArrayList<Integer> newA = new ArrayList<>();
                                newA.add(arr[i]);
                                newA.add(arr[b]);
                                newA.add(arr[c]);
                                newA.add(arr[d]);
//                                Collections.sort(newA);
                                ans.add(newA);
                                while (c < d && arr[c] == arr[c + 1]) c++;
                                while (c < d && arr[d] == arr[d - 1]) d--;
                                c++;
                                d--;
                            } else if (sum < target) {
                                c++;
                            } else d--;
                        }
                    }
                }
            }
        }
        return ans;
    }
//    static void saveVal(ArrayList<ArrayList<Integer>> result, int[] arr){
//        ArrayList<Integer> newA = new ArrayList<>();
//        Arrays.sort(arr);
//        for (int val : arr){
//            newA.add(val);
//        }
//        result.add(newA);
//    }
}
