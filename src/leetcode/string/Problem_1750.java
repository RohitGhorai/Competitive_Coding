package leetcode.string;

public class Problem_1750 {
    public static void main(String[] args) {
        String s = "cabaabac";
        int minLen = minimumStringLength(s);
        System.out.println(minLen);
    }
    static int minimumStringLength(String s){
        if (s.length() == 0) return 0;
        int left = 0;
        int right = s.length() - 1;
        while (left < right && s.charAt(left) == s.charAt(right)) {
            char curr = s.charAt(left);
            while (left <= right && s.charAt(left) == curr) left++;
            while (left <= right && s.charAt(right) == curr) right--;
        }
        return right - left + 1;
    }
}
