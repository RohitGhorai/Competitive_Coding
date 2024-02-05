package qn;

/*
String with additive sequence

Given a string, the task is to find whether it contains an additive sequence or not. A string contains an additive sequence
if its digits can make a sequence of numbers in which every number is addition of previous two numbers. A valid string should
contain at least three digit to make one additive sequence.

Examples:

Input : s = “235813”
Output : true
2 + 3 = 5, 3 + 5 = 8, 5 + 8 = 13

Input : s = “199100199”
Output : true
1 + 99 = 100, 99 + 100 = 199

 */


public class AdditiveSeq {
    public static void main(String[] args) {
        System.out.println(isAdditiveNumber("199100199"));
    }
    static boolean isAdditiveNumber(String str){
        for (int i = 1; i < str.length(); i++){
            for (int j = i + 1; j < str.length() - i; j++){
                String first = str.substring(0, i);
                String second = str.substring(i, j);
                if(isValid(str, j, first, second)) return true;
            }
        }
        return false;
    }

    static boolean isValid(String str, int start, String first, String second){
        if (start == str.length()) {
            return true;
        }
        if (first.charAt(0) == '0' && first.length() > 1 || second.charAt(0) == '0' && second.length() > 1) return false;
        int f = Integer.parseInt(first);
        int s = Integer.parseInt(second);
        int sum = f + s;
        String sumStr = String.valueOf(sum);
        if (start + sumStr.length() > str.length()) return false;
        if (!str.substring(start, start + sumStr.length()).equals(sumStr)) {
            return false;
        }
        return isValid(str, start + sumStr.length(), second, sumStr);
    }
}
