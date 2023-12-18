package qn;

import java.util.*;

public class BrackTrac {
    public static void main(String[] args) {
        String str = "]";
        if(isValid(str)) System.out.println("Balanced.");
        else System.out.println("Not Balanced.");
    }
    static boolean isValid(String str){
        Deque<Character> stack = new ArrayDeque<>();
        for(int i = 0; i < str.length(); i++){
            char x = str.charAt(i);
            if(x == '(' || x == '{' || x == '['){
                stack.push(x);
                continue;
            }
            if(stack.isEmpty()) return false;
            char check;
            switch (x){
                case ')' :
                    check = stack.pop();
                    if(check == '{' || check == '[') return false;
                    break;
                case '}' :
                    check = stack.pop();
                    if(check == '(' || check == '[') return false;
                    break;
                case ']' :
                    check = stack.pop();
                    if(check == '(' || check == '{') return false;
                    break;
            }
        }
        return stack.isEmpty();
    }
}
