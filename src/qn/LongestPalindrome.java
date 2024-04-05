package qn;

public class LongestPalindrome {
    public static void main(String[] args) {
        String s = "abbd";
        String res = longestPalindrome(s);
        System.out.println(res);
    }
    static String longestPalindrome(String str){
        String lps = "" + str.charAt(0);
        for (int i = 1; i < str.length(); i++){
            // odd length
            String s1 = palindrome(str, i, i);
            if (lps.length() < s1.length()) lps = s1;
            // even length
            s1 = palindrome(str, i-1, i);
            if (lps.length() < s1.length()) lps = s1;
        }
        return lps;
    }
    static String palindrome(String s, int i, int j){
        while (s.charAt(i) == s.charAt(j)) {
            i--;
            j++;

            if (i == -1 || j == s.length()) break;
        }
        return s.substring(i+1, j);
    }
}
