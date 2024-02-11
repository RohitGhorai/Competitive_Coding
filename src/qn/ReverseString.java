package qn;

import java.util.*;
import java.util.Stack;
import java.util.stream.Collectors;

public class ReverseString {
    public static void main(String[] args) {
        String s = "Hello World!";
        String res = method_4(s);
        System.out.println(res);
    }

    // reverse single string
    static String reverse(String str){
        if (str.length() == 0) return str;
        else return reverse(str.substring(1)) + str.charAt(0);
    }
    static String method_4(String str){
        StringBuilder result = new StringBuilder();
        String[] st = str.split(" ");
        for (String s : st){
            StringBuilder sb = new StringBuilder(s);
            String str2 = sb.reverse().toString();
            if (!s.equals(st[st.length - 1])) str2 = str2.concat(" ");
            result.append(str2);
        }
        return result.toString();
    }
    static String method_3(String str){
        String result = Arrays.asList(str.split(" "))
                .stream()
                .map(s -> new StringBuilder(s).reverse().toString())
                .collect(Collectors.joining(" "));
        return result;
    }
    static void method_2(String str){
        String s = "";
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) != ' ') st.push(str.charAt(i));
            else {
                while (!st.isEmpty()) System.out.print(st.pop());
                System.out.print(" ");
            }
        }
        while (!st.isEmpty()) System.out.print(st.pop());
    }
    static void method_1(String str){
        String s = "";
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) != ' ') {
                s += str.charAt(i);
                if (i != str.length() - 1) continue;
            }
            StringBuilder sb = new StringBuilder(s);
            String res = sb.reverse().toString();
            System.out.print(res + " ");
            s = "";
        }
    }
}
