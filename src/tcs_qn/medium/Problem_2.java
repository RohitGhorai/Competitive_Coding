package tcs_qn.medium;

public class Problem_2 {
    public static void main(String[] args) {
        System.out.println(method_1(101, 200));
    }
    static int method_1(int n1, int n2){
        int ans = 0;
        for (int i = n1; i <= n2; i++){
            String st = Integer.toString(i);
            boolean ok = true;
            for (int j = 0; j < st.length(); j++){
                for (int k = j + 1; k < st.length(); k++){
                    if (st.charAt(j) == st.charAt(k)) {
                        ok = false;
                        break;
                    }
                }
            }
            if (ok) ans++;
        }
        return ans;
    }
}
