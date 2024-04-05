package leetcode.string;

import java.util.Stack;

// Make the string great
public class Problem_1544 {
    public static void main(String[] args) {
        String s = "leEeetcode";
        String res = solution_2(s);
        System.out.println(res);
    }

    // recursion
    static String makeGood(String s){
        for (int i = 0; i < s.length() - 1; i++){
            if (Math.abs(s.charAt(i) - s.charAt(i + 1)) == 32) return makeGood(s.substring(0, i) + s.substring(i + 2));
        }
        return s;
    }

    static String solution_2(String s){
        if (s.length() <= 1) return s;
        Stack<Character> st = new Stack<>();
        st.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++){
            char ch = s.charAt(i);
            if (st.isEmpty()) {
                st.push(ch);
                continue;
            }
            if (Character.isUpperCase(ch) && st.peek() - ch == 32) st.pop();
            else if (Character.isLowerCase(ch) && ch - st.peek() == 32) st.pop();
            else st.push(ch);
        }
        if (st.isEmpty()) return "";
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) sb.insert(0, st.pop());
        return sb.toString();
    }
}
