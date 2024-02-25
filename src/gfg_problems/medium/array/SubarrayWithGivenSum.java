package gfg_problems.medium.array;

import java.util.ArrayList;

/*
Given an unsorted array A of size N that contains only non negative integers, find a continuous sub-array that adds to a given number S and return the left and right index(1-based indexing) of that subarray.

In case of multiple subarrays, return the subarray indexes which come first on moving from left to right.

Note:- You have to return an ArrayList consisting of two elements left and right. In case no such subarray exists return an array consisting of element -1.

Example 1:

Input:
N = 5, S = 12
A[] = {1,2,3,7,5}
Output: 2 4
Explanation: The sum of elements
from 2nd position to 4th position
is 12.
Example 2:

Input:
N = 10, S = 15
A[] = {1,2,3,4,5,6,7,8,9,10}
Output: 1 5
Explanation: The sum of elements
from 1st position to 5th position
is 15.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)
 */
public class SubarrayWithGivenSum {
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        ArrayList<Integer> ans = new ArrayList<>();
        int start = 0, sum = arr[0];
        for (int i = 1; i <= n; i++) {
            while (s < sum && start < i - 1) {
                sum -= arr[start];
                start++;
            }
            if (sum == s)  {
                ans.add(start + 1);
                ans.add(i);
                return ans;
            }
            if (i < n) sum += arr[i];
        }
        ans.add(-1);
        return ans;
    }
}
