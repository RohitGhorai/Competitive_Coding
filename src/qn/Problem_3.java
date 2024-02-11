package qn;

public class Problem_3 {
    public static void main(String[] args) {
        String s = "1234";
        int ans = stringToInt(s, 0, 0);
        System.out.println(ans);
    }

    // String to Integer
    static int stringToInt(String s, int len, int ans){
        if (len == s.length()) return ans/10;
        ans = ans + (int)(s.charAt(len) - '0');
        return stringToInt(s, len+1, ans*10);
    }
}
