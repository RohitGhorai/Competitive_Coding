package tcs_qn.easy;

public class Problem_12 {
    public static void main(String[] args) {
        int n = 145;
        int ans = method(n);
        System.out.println(ans);

    }
    static int method(int n){
        int sum = 0;
        char[] ch = Integer.toString(n).toCharArray();
        for (char c : ch){
            sum = sum + factorial((int)c - '0');
        }
        return (sum == n) ? 1 : 0;
    }
    static int factorial(int num){
        if (num <= 1) return num;
        return num * factorial(num - 1);
    }
}
