import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String s = "FThusvhusdc YVUdcsdgjdsi SDgy";
        method(s);
    }
    static void method(String s){
        int n = s.length();
        int words = 0;
        int c = 0;
        for (int i = 0; i < n; i++){
            if (Character.isAlphabetic(s.charAt(i))) words++;
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                c++;
            }
        }
        int p = (c * 100)/words;
        System.out.println(p);
    }
}
