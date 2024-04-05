package qn;

public class SumSubstring {
    public static void main(String[] args) {
        String s = "1234";
        long ans = sumSubstring(s);
        System.out.println(ans);
    }
    static long sumSubstring(String s){
        int mod = (int)Math.pow(10, 9) + 7;
        long prev = 0, curr = 0, sum = 0;
        for (int i = 0; i < s.length(); i++){
            curr = ((long)(s.charAt(i)-'0')*(i+1))%mod + (prev*10)%mod;
            sum = (sum + curr)%mod;
            prev = curr;
            System.out.println(curr);
        }
        return sum;
    }
}
