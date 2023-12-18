package leetcode;

import java.util.Arrays;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower", "float", "frozen"};
        System.out.println(longestPrefix(strs));
    }
    //Using sorting
    static String longestPrefix(String[] strs){
        int n = strs.length;
        if(n == 0) return "";
        if(n == 1) return strs[0];
        Arrays.sort(strs);
        int end = Math.min(strs[0].length(), strs[n - 1].length());
        int i = 0;
        while(i < end && strs[0].charAt(i) == strs[n-1].charAt(i)) i++;
        return  (i == 0) ? "" : strs[0].substring(0, i);
    }

    static String approach2(String[] s){
        int n = s.length;
        String result = s[0];
        for(int i = 1; i < n; i++){
            while(s[i].indexOf(result) != 0) result = result.substring(0, result.length() - 1);
        }
        if(result.isEmpty()) return "";
        return result;
    }
}
