package qn;

public class FiboNacci {
    public static void main(String[] args) {
        for(int i = 0; i < 10; i++){
            int ans = fibo(i);
            System.out.print(ans + " ");
        }
    }
    static int fibo(int n){
        if(n < 2) return n;
        else return fibo(n - 1) + fibo(n - 2);
    }
}
