package gfg_problems.easy.strings;

public class Main {
    public static void main(String[] args) {
        int n = 17;
        String s = decimalToBinary(n);
        System.out.println(s);
        int ans = binaryToDecimal(s);
        System.out.println(ans);
    }
    static String decimalToBinary(int n){
        //return Integer.toBinaryString(n);
        StringBuilder sb = new StringBuilder();
        while (n > 0){
            if (n % 2 == 0) sb.append(0);
            else sb.append(1);
            n = n / 2;
        }
        return sb.reverse().toString();
    }

    static String decimalToBinary(int n, StringBuilder sb){
        if (n <= 0) return sb.reverse().toString();
        if (n % 2 == 0) sb.append(0);
        else sb.append(1);
        return decimalToBinary(n / 2, sb);
    }

    static int binaryToDecimal(String s){
        //return Integer.parseInt(s, 2);
        int ans = 0;
        for (int i = 0; i < s.length(); i++){
            ans += Math.pow(2, i)*(int)(s.charAt(i) - '0');
        }
        return ans;
    }
    static int binaryToDecimal(String s, int i, int ans){
        if (s.length() == 0) return 0;
        if (i == s.length()) return ans;
        ans += Math.pow(2, i)*(int)(s.charAt(i) - '0');
        return binaryToDecimal(s, i + 1, ans);
    }
}
