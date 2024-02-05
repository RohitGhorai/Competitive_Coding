package dsa_tutorial.arrays;

public class SmallestNumber {
    public static void main(String[] args) {
        int n = 100;
        int ans = method_1(n);
        System.out.println(ans);
    }
    static int method_1(int n) {
        String ans = "";
        for (int i = 9; i >= 2; i--){
            while (n % i == 0){
                n = n / i;
                ans = i + ans;
            }
        }
        if (n != 1) {
            return -1;
        } else return Integer.parseInt(ans);
    }
}
