package qn;

public class CheckArmstrong {
    public static void main(String[] args) {
        int n = 1634;
        System.out.println(isCheck(n));
    }
    static boolean isCheck(int n){
        int count = 0;
        int temp = n;
        while (temp != 0){
            count++;
            temp /= 10;
        }
        int num = 0;
        int t = n;
        while (t != 0){
            int x = t%10;
            num += Math.pow(x, count);
            t = t/10;
        }
        return num == n;
    }
}
