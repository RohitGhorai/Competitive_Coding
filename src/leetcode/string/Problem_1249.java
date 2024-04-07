package leetcode.string;

import java.util.Stack;

// Minimum remove to make valid parentheses
public class Problem_1249 {
    public static void main(String[] args) {
        String s = "a)b(c)d";
        String res = minRemoveToMakeValid(s);
        System.out.println(res);
    }
    static String minRemoveToMakeValid(String s){
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            System.out.println(st);
            char curr = s.charAt(i);
            if (curr == '(') st.push(i);
            else if (curr == ')'){
                if (st.isEmpty()) sb.setCharAt(i, '#');
                else st.pop();
            }
        }
        while (!st.isEmpty()) sb.setCharAt(st.pop(), '#');
        return sb.toString().replaceAll("#", "");
    }
}
