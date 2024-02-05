package qn;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] arr = {5,6,2,3,4};
        int ans = method_1(arr);
        System.out.println(ans);
//        LinkedList<Integer> l1 = new LinkedList<>();
//        l1.add(5);
//        l1.add(6);
//        l1.add(3);
//        LinkedList<Integer> l2 = new LinkedList<>();
//        l2.add(8);
//        l2.add(4);
//        l2.add(2);
//        LinkedList<Integer> ans = add(l1, l2, new LinkedList<>(), 0);
//        while(!ans.isEmpty())System.out.print(ans.removeLast());
    }
    /*
    Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
    Input :  [3, 4, 5, 1, 2]
    Output : 1

    Time : O(logn)
     */
    static int findMinValue(int[] arr){
        int start = 0, end = arr.length - 1;
        if (arr[start] < arr[end]) return arr[start];
        while ((end - start) > 1){
            int mid = (end + start)/2;
            if (arr[mid] < arr[end]) end = mid;
            else start = mid;
        }
        return arr[end];
    }
    static int method_1(int[] arr){
        int i = 1, j = arr.length - 1;
        int pivot = arr[0];
        if (pivot < arr[j]) return arr[i];
        while (pivot < arr[i]) i++;
        return arr[i];
    }

    static LinkedList<Integer> add(LinkedList<Integer> l1, LinkedList<Integer> l2, LinkedList<Integer> ans, int carry){
        if (l1.isEmpty() && l2.isEmpty() && carry == 0) {
            return ans;
        }
        int sum = 0;
        sum = (l1.isEmpty() ? 0 : l1.removeLast()) + (l2.isEmpty() ? 0 : l2.removeLast()) + carry;
        System.out.println(sum);
        carry = sum / 10;
        sum = sum % 10;
        ans.add(sum);
        return add(l1, l2, ans, carry);
    }
}
