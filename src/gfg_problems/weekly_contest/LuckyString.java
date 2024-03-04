package gfg_problems.weekly_contest;

public class LuckyString {
    public static void main(String[] args) {
        String s = "BBBCAA";
        int ans = smallestLuckySubstring(s, s.length());
        System.out.println(ans);
    }
    static int smallestLuckySubstring(String str, int n){
        for (int i = 0; i < n - 1; i++){
            if (str.charAt(i) == 'A' && str.charAt(i + 1) == 'A') return 2;
        }
        for (int i = 0; i < n - 2; i++){
            if (str.charAt(i) == 'A' && str.charAt(i + 2) == 'A') return 3;
        }
        for (int i = 0; i < n - 2; i++){
            if ((str.charAt(i) == 'A' && str.charAt(i + 2) != 'A') && (str.charAt(i) == 'A' && str.charAt(i + 3) == 'A')) return 4;
        }
        return -1;
    }
}
