package dsa_tutorial.stack_queue;

import java.util.*;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] arr = {{1, 4}, {2, 5}, {1, 7}, {8, 12}, {10, 15}, {11, 20}};
        int[][] ans = merge(arr);
        for (int[] val : ans){
            System.out.println(Arrays.toString(val));
        }
    }
    static int[][] merge(int[][] intervals){
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        Stack<int[]> st = new Stack<>();

        st.push(intervals[0]);
        for (int i = 1; i < intervals.length; i++){
            if (st.peek()[1] >= intervals[i][0]) {
                st.peek()[1] = Math.max(st.peek()[1], intervals[i][1]);
            }
            else st.push(intervals[i]);
        }
        int[][] ans = new int[st.size()][2];
        for (int i = ans.length - 1; i >= 0; i--){
            ans[i][0] = st.peek()[0];
            ans[i][1] = st.peek()[1];
            st.pop();
        }
        return ans;
    }
}
