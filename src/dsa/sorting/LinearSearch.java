package dsa.sorting;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {45, 4, 25, 15, 30};
        int target = 35;
        int ans = search(arr, arr.length, target);
        System.out.println(ans);
    }
    static int search(int[] arr, int len, int target){
        for(int i = 0; i < len; i++){
            if(arr[i] == target) return i;
        }
        return -1;
    }
}
