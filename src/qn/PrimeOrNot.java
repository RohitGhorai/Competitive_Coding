package qn;

import java.util.Scanner;

public class PrimeOrNot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        if (isPrime(n)) System.out.println(n + " is a prime number.");
        else System.out.println(n + " is not a prime number.");
    }
    static boolean isPrime(int n){
        if(n <= 1) return false;
        for(int i = 2; i <= n/2; i++){
            if(n % i == 0) return false;
        }
        return true;
    }
}