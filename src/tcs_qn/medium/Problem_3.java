package tcs_qn.medium;

public class Problem_3 {
    public static void main(String[] args) {
        String str = "nayannamantenet";
        int k = 5;
        method_1(str, k);
    }
    static boolean isPalindrome(String str, int i, int j){
        if (i == j) return true;
        if (str.charAt(i) != str.charAt(j)) return false;
        if (i < j) return isPalindrome(str, i + 1, j - 1);
        return true;
    }
    static void method_1(String str, int k){
        for (int i = 0; i <= str.length()-k; i++){
                String s = str.substring(i, i+k);
                if (isPalindrome(s, 0, s.length()-1)) System.out.println(s);
        }
    }
}
