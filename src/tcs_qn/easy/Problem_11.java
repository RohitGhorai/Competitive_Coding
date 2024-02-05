package tcs_qn.easy;

// Array Subset of another array
public class Problem_11 {
    public static void main(String[] args) {
        int[] arr_1 = {1,2,3,4,4,5,6};
        int[] arr_2 = {1,2,4};
        boolean ok = method_1(arr_1, arr_2);
        System.out.println(ok);
    }
    static boolean method_1(int[] arr_1, int[] arr_2){
        boolean ok = false;
        for (int i : arr_2) {
            for (int j : arr_1){
                if (i == j) {
                    ok = true;
                    break;
                } else ok = false;
            }
        }
        return ok;
    }
}
