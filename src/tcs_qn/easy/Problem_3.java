package tcs_qn.easy;

/*
Given an integer array Arr of size N the task is to find the count of elements whose value is greater than all of its prior elements.

Note : 1st element of the array should be considered in the count of the result.

For example,

Arr[]={7,4,8,2,9}

As 7 is the first element, it will consider in the result.

8 and 9 are also the elements that are greater than all of its previous elements.

Since total of  3 elements is present in the array that meets the condition.

Hence the output = 3.

 Example 1:

Input

5 -> Value of N, represents size of Arr

7-> Value of Arr[0]

4 -> Value of Arr[1]

8-> Value of Arr[2]

2-> Value of Arr[3]

9-> Value of Arr[4]

Output :

3
 */
import java.util.*;

public class Problem_3 {
    public static void main(String[] args) {
        int[] arr = {3,4,5,8,9};
        int ans = method_1(arr);
        System.out.println(ans);
    }
    static int method_1(int[] arr){
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--){
            // pop all the smaller element
            while (st.size() > 0 && st.peek() < arr[i]) st.pop();
            // update the element
            if (st.size() == 0) ans[i] = -1;
            else ans[i] = st.peek();
            // add in stack
            st.push(arr[i]);
        }
        return st.size();
    }
}
