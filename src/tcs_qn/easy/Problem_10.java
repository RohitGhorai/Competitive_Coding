package tcs_qn.easy;

public class Problem_10 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,3};
        boolean ok = method_1(arr);
        System.out.println(ok);
    }
    static boolean method_1(int[] arr){
        int i = 0;
        int j = 1;
        for (int k = 2; k < arr.length; k++){
            if (arr[i] + arr[j] == arr[k]) return true;
            i++;
            j++;
        }
        return false;
    }
}
