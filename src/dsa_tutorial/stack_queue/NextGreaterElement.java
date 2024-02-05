package dsa_tutorial.stack_queue;

import java.util.*;

public class NextGreaterElement {
    public static void main(String[] args) {
        int[] arr = {5,9,21,11,17,3,30,12,60,50};
        int[] ans = method_2(arr);
        System.out.println(Arrays.toString(ans));
    }
    static int[] method_1(int[] arr){
        Stack<Integer> s = new Stack<>();
        int[] ans = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--){
            // pop all smaller elements
            while (s.size() > 0 && s.peek() < arr[i]) s.pop();
            // update ans
            if (s.size() == 0) ans[i] = -1;
            else ans[i] = s.peek();
            // add current element in the stack
            s.push(arr[i]);
        }
        return ans;
    }

    static int[] method_2(int[] arr){
        Stack<Integer> s = new Stack<>();
        int[] ans = new int[arr.length];
        s.push(0);
        for (int i = 1; i < arr.length; i++){
            // pop all smaller elements
            while (s.size() > 0 && arr[s.peek()] < arr[i]) {
                ans[s.peek()] = arr[i];
                s.pop();
            }
            s.push(i);
        }
        while (s.size() > 0) ans[s.pop()] = -1;

        return ans;
    }

    static int[] method_3(int[] arr){
        for (int i = 0; i < arr.length; i++){
            for (int j = i + 1; j < arr.length; j++){
                if (arr[i] < arr[j]) {
                    arr[i] = arr[j];
                    break;
                }
            }
        }
        return arr;
    }
}
