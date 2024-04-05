package qn;

public class GCD {
    public static void main(String[] args) {
        int ans = gcd(3,6);
        System.out.println(ans);
    }
    static int gcd(int a, int b){
        int ans = 0;
        for (int i = 1; i <= Math.min(a,b); i++){
            if (a%i == 0 && b%i == 0) ans = i;
        }
        return ans;
    }
    static int recursion(int a, int b){
        if (b == 0) return a;
        return gcd(a, a%b);
    }
}
