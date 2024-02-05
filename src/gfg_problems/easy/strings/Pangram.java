package gfg_problems.easy.strings;

import java.util.ArrayList;
import java.util.List;

public class Pangram {
    public static void main(String[] args) {
        String s = "Abcdefghijklmnopqrstuvwxyz12";
        boolean res = method_2(s);
        System.out.println(res);
    }
    static boolean method_1(String str){
        str = str.toLowerCase();
        boolean[] alphebetics = new boolean[26];
        int idx = 0;
        for (int i = 0; i < str.length(); i++) {
            // Instead of -> if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') idx = str.charAt(i) - 'a';
            // we can use Character class to check char is alphabet or not.
            if (Character.isAlphabetic(str.charAt(i))) idx = str.charAt(i) - 'a';
            alphebetics[idx] = true;
        }
        for (boolean res : alphebetics){
            if (!res) return false;
        }
        return true;
    }
    static boolean method_2(String str){
        str = str.toLowerCase();
        List<Character> list = new ArrayList<>();
        for (char ch = 'a'; ch <= 'z'; ch++) list.add(ch);
        for (int i = 0; i < str.length(); i++){
            if (Character.isAlphabetic(str.charAt(i))) {
                if (list.contains(str.charAt(i))) list.remove((Character) str.charAt(i));
            }
        }
        return list.isEmpty();
    }
}
