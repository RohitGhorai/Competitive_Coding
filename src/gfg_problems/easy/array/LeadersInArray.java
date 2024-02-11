package gfg_problems.easy.array;

import java.util.*;

public class LeadersInArray {
    public static void main(String[] args) {
        int[] arr = {16,17,3,4,5,2};
        List<Integer> ans = method(arr, new ArrayList<Integer>());
        System.out.println(Arrays.toString(ans.toArray()));
    }
    static List<Integer> method(int[] arr, List<Integer> ans){
        int max = 0;
        for (int i = arr.length - 1; i >= 0; i--){
            if (max < arr[i]){
                max = arr[i];
                ans.add(max);
            }
        }
        Collections.reverse(ans);
        return ans;
    }
}
