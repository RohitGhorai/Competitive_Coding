package tcs_qn.easy;

/*
Problem Statement –

Joseph is learning digital logic subject which will be for his next semester. He usually tries to solve unit assignment problems
before the lecture. Today he got one tricky question. The problem statement is “A positive integer has been given as an input.
Convert decimal value to binary representation. Toggle all bits of it after the most significant bit including the most significant bit.
Print the positive integer value after toggling all bits”.

Constrains-

1<=N<=100

Example 1:

Input :

10  -> Integer

Output :

5    -> result- Integer

Explanation:

Binary representation of 10 is 1010. After toggling the bits(1010), will get 0101 which represents “5”. Hence output will print “5”.
 */

import java.util.*;

public class Problem_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        int ans = method_1(n);
        System.out.println(ans);
    }
    static int method_1(int n){
        String binary = Integer.toBinaryString(n);
        String row = "";
        for (int i = 0; i < binary.length(); i++){
            if (binary.charAt(i) == '0') row += '1';
            else row += '0';
        }
        int ans = Integer.parseInt(row, 2);
        return ans;
    }
}
