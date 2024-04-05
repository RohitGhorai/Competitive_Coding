package tcs_qn.medium;

import java.util.Scanner;

/*
Input: All the Best9, Key = 1
Output: Bmm uif Cftu0
 */
public class Problem_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your Plain Text: ");
        String s = sc.nextLine();
        System.out.print("Key: ");
        int key = sc.nextInt();
        cyphertext(s, key);
    }
    static void cyphertext(String s, int key){
        if (key <= -1) {
            System.out.println("INVALID INPUT");
            return;
        }
        if (key == 0) {
            System.out.println(s);
            return;
        }
        String[] str = s.split(" ");
        System.out.print("The encrypted text is: ");
        for (String s1 : str){
            String s2 = "";
            for (char c : s1.toCharArray()){
                if (Character.isAlphabetic(c)) s2 += (char)(c + key);
                else if (Character.isDigit(c)) {
                    if (c + key <= '9') s2 += (char)(c + key);
                    else s2 += (char)(c + key - '9' + '0' - 1);
                }
            }
            System.out.print(s2 + " ");
        }
    }
}
