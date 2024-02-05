package dsa_tutorial.arrays;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {11, 3, 7, 14, 9, 2};
        int target = 14;
        int[] ans = method_1(arr, target);
        System.out.println(Arrays.toString(ans));
    }

    static int[] method_1(int[] arr, int target){
        int[] ans = new int[2];

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++){
            int sn = target - arr[i];
            if (map.containsKey(sn)){
                ans[0] = map.get(sn);
                ans[1] = i;
                break;
            }
            map.put(arr[i], i);
        }

        return ans;
    }

    static int[] method_2(int[] arr, int target){
        int[] ans = new int[2];
        for (int i = 0; i < arr.length; i++){
            for (int j = i + 1; j < arr.length; j++){
                if (arr[i] + arr[j] == target && arr[i] != arr[j]) {
                    ans = new int[]{i, j};
                    break;
                }
            }
        }
        return ans;
    }
}
