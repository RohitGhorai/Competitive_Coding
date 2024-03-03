package gfg_problems.medium.array;

import java.util.*;

public class MajorityElement {
    public static void main(String[] args) {
        int[] arr = {2,3,1,2,3,3,};
        int n = arr.length;
        int ans = (majorityElement(arr, n));
        System.out.println(ans);
    }
    static int majorityElement(int arr[], int size) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i : arr){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int max = Integer.MIN_VALUE;
        int maxElement = -1;
        for (Map.Entry<Integer, Integer> i : map.entrySet()){
            if (i.getValue() > max){
                max = i.getValue();
                maxElement = i.getKey();
            }
        }
        if (max > size/2) return maxElement;
        else return -1;
    }
}
