package tcs_qn.medium;

import java.util.*;

public class Problem_4 {
//    public static void main(String[] args) {
//        int[] set = {4,5};
//        int count = 0;
//        printAllPossible(set, "", set.length, 3, new HashMap<String>(), count);
//        System.out.println(count);
//    }
//    static void printAllPossible(int[] set, String str, int n, int k, List<String> list, int count){
//        if (k == 0) {
//            list.add(str)
//            return;
//        }
//        for (int j = set[0]; j <= set[set.length - 1]; j++){
//            for (int i = 0; i < n; i++){
//                printAllPossible(set, str + j, n, k - 1, list, count);
//            }
//        }
//    }
public static void main(String[] args) {
    String str = "><^v";
//    String str = "<<^<v>>";
    System.out.println(method_1(str));
}
    static int method_1(String str){
        Stack<Integer> s = new Stack<>();
        s.add(0);
        for (int i = 1; i < str.length(); i++){
            if ((str.charAt(i) == '<' && str.charAt(s.peek()) == '>') || (str.charAt(i) == '>' && str.charAt(s.peek()) == '>')) s.pop();
            else s.push(i);
        }
        System.out.println(s);
        return s.size();
    }
}
