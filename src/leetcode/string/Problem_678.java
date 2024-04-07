package leetcode.string;

public class Problem_678 {
    public static void main(String[] args) {
        String s = "(*))";
        boolean res = checkValidString(s);
        System.out.println(res);
    }
    static boolean checkValidString(String str){
        int omin = 0, omax = 0;
        for (char ch : str.toCharArray()){
            switch (ch) {
                case '(' -> {
                    omin++;
                    omax++;
                }
                case ')' -> {
                    omin--;
                    omax--;
                }
                default -> {
                    omin--;
                    omax++;
                }
            }
            if (omax < 0) return false;
            if (omin < 0) omin = 0;
        }
        return omin == 0;
    }
}
