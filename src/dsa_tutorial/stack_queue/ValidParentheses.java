package dsa_tutorial.stack_queue;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        String st = "[";
        System.out.println(method_1(st));
    }
    static boolean method_1(String str){
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') s.push(ch);
            else {
                if (s.size() == 0) return false;
                if (ch == ')' && s.peek() == '(') s.pop();
                else if (ch == '}' && s.peek() == '{') s.pop();
                else if (ch == ']' && s.peek() == '[') s.pop();
            }
        }
        return s.isEmpty();
    }
}
