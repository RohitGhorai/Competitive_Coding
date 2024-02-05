package dsa_tutorial.dynamic_programming;

public class FiboNacci {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(method_2(n, new int[n + 1]));
    }

    // Top-Down Approach [ Memorization ]
    static int method_1(int n, int[] arr){
        if (n < 2) return n;
        if (arr[n] != 0) return arr[n];
        int fn = method_1(n - 1, arr) + method_1(n - 2, arr);
        arr[n] = fn;
        return fn;
    }

    // Bottom-Up Approach [ Tabulation ]
    static int method_2(int n, int[] arr){
        if (n < 2) return n;
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i < arr.length; i++){
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }
}


// Time Complexity = O(n)
// Space Complexity = O(n)