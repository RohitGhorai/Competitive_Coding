package leetcode.array;

// https://leetcode.com/problems/determine-the-minimum-sum-of-a-k-avoiding-array/description/

import java.util.HashSet;
import java.util.Set;

public class Problem_2829 {
    public static void main(String[] args) {
        int n = 5;
        int k = 4;
        int ans = minimumSum(n, k);
        System.out.println(ans);
    }
    static int minimumSum(int n, int k){
        int curr = 1;
        int sum = 0;
        Set<Integer> set = new HashSet<>();
        while (set.size() != n){
            if (set.contains(k - curr)) {
                curr++;
                continue;
            }
            sum += curr;
            set.add(curr);
            curr++;
        }
        System.out.println(set);
        return sum;
    }
}
