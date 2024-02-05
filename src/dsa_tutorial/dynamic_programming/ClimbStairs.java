package dsa_tutorial.dynamic_programming;

public class ClimbStairs {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(method_1(n, new int[n + 1]));
    }

    // Memorization
    static int method_1(int n, int[] arr){
        if (n == 0) return 1;
        if (n < 0) return 0;

        if (arr[n] != 0) return arr[n];

        int p1 = method_1(n - 1, arr);
        int p2 = method_1(n - 2, arr);
        int p3 = method_1(n - 3, arr);
        int ans = p1 + p2 + p3;
        arr[n] = ans;

        return ans;
    }

    // Tabulation
    static int method_2(int n){
        int[] arr = new int[n + 1];
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i <= n; i++){
            arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3];
        }
        return arr[n];
    }
}
