package qn;

public class Palindrome {
    public static void main(String[] args) {
        String st = "madam";
        String lowerCase = st.toLowerCase();
        if(isPalindrome(lowerCase, 0, st.length()-1)) System.out.println(st + " is a Palindrome");
        else System.out.println(st + " is not a Palindrome");
//        if(isPalindrome3(lowerCase)) System.out.println(st + " is a Palindrome.");
//        else System.out.println(st + " is not a Palindrome.");
    }
    //using Recursive Approach
    static boolean isPalindrome(String st, int start, int end){
        if(start == end) return true;
        if(st.charAt(start) != st.charAt(end)) return false;
        if(start < end) return isPalindrome(st, start + 1, end - 1);
        return true;
    }
    //Using reverse method
    static boolean isPalindrome2(String st){
        StringBuilder sb = new StringBuilder(st);
        String st2 = sb.reverse().toString();
        return st.equals(st2);
    }
    //Using two pointers
    static boolean isPalindrome3(String st){
        int start = 0;
        int end = st.length() - 1;
        while(start < end){
            char ch = st.charAt(start);
            char ch2 = st.charAt(end);
            if(ch != ch2) return false;
            start += 1;
            end -= 1;
        }
        return true;
    }

    static boolean isPalindrome4(int x) {
        char[] y = String.valueOf(x).toCharArray();
        char[] z = new char[y.length];
        for(int i = z.length-1; i >= 0; i--){
            z[z.length - 1 - i] = y[i];
        }
        boolean res = true;
        for(int i = 0; i < y.length; i++){
            if(y[i] == z[i]) res = true;
            else {
                res = false;
                break;
            }
        }
        return res;
    }

//    static String longestPalindrome(String str){
//        String pal = "";
//        for (int i = 0; i < str.length(); i++){
//            if (isPalindrome(str, i, str.length() - 1 - i)) {
//                pal = str.substring(i, str.length() - i);
//                return pal;
//            }
//        }
//        return pal;
//    }
}
