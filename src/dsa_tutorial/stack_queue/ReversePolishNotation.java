package dsa_tutorial.stack_queue;

import java.util.Stack;

public class ReversePolishNotation {
    public static void main(String[] args) {
        String[] st = {"2", "3", "*","4","+"};
        int ans = calculate(st);
        System.out.println(ans);
    }
    static int calculate(String[] str){
        Stack<Integer> s = new Stack<>();
        for (String a : str) {
            if (a.equals("+") || a.equals("-") || a.equals("*") || a.equals("/")) {
                int pop1 = s.pop();
                int pop2 = s.pop();
                s.push(solve(pop1, pop2, a));
            } else {
                s.push(Integer.parseInt(a));
            }
        }
        return s.pop();
    }
    static int solve(int pop1, int pop2, String str){
        if (str.equals("+")) return pop2 + pop1;
        else if (str.equals("-")) return pop2 - pop1;
        else if (str.equals("*")) return pop2 * pop1;
        else return pop2 / pop1;
    }
}
