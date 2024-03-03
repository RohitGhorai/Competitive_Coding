package gfg_problems.medium.array;

import java.util.ArrayList;
import java.util.*;

public class FindDuplicate {
    public static void main(String[] args) {
        int[] arr = {1,8,4,5,8,1,3};
        List<Integer> ans = duplicateElements(arr);
        System.out.println(ans);
    }

    // Time Complexity : O(n*logn)
    // Space Complexity : O(2n)
    static List<Integer> duplicateElements(int arr[]) {
        List<Integer> duplicate = new ArrayList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i : arr){
            // if (!map.containsKey(i)) map.put(i, 1);
            // else map.put(i, map.get(i) + 1);
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> i : map.entrySet()){
            if (i.getValue() > 1) duplicate.add(i.getKey());
        }
        if (duplicate.size() == 0) duplicate.add(-1);
        return duplicate;
    }
}
