package qn;

/*
You are given a sorted array consisting of only integers where every element appears exactly twice,
except for one element which appears exactly once. Find this single element that appears only once.
 */
public class Problem_2 {
    public static void main(String[] args) {
        int[] arr = {1,1,2,3,3,8,8};
        int ans = singleElement(arr);
        System.out.println(ans);
    }
    static int singleElement(int[] arr){
        for (int i = 1; i < arr.length; i += 2){
            if (i == arr.length - 2 && arr[i] != arr[i + 1]) return arr[i + 1];
            if (arr[i - 1] != arr[i]) return arr[i - 1];
        }
        return -1;
    }
}
