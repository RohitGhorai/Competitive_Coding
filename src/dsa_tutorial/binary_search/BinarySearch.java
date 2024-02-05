package dsa_tutorial.binary_search;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,2,3,3,3,5,6};
        int[] ans = method_2(arr, 3);
        System.out.println(Arrays.toString(ans));
    }

    static int[] method_2(int[] arr, int target){
        int s = 0;
        int e = arr.length - 1;
        int first = -1;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (arr[mid] == target) {
                first = mid;
                e = mid - 1;
            }
            else if (arr[mid] < target) s = mid + 1;
            else e = mid - 1;
        }
        s = 0;
        e = arr.length - 1;
        int last = -1;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (arr[mid] == target) {
                last = mid;
                s = mid + 1;
            }
            else if (arr[mid] < target) s = mid + 1;
            else e = mid - 1;
        }
        return new int[]{first, last};
    }
    static int method_1(int[] arr, int s, int e, int target){
        if (s > e) return -1;
        int mid = s + (e - s) / 2;
        if (arr[mid] == target) return mid;
        return  (arr[mid] < target) ? method_1(arr, mid + 1, e, target) : method_1(arr, s, mid - 1, target);
    }
}
