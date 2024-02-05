package dsa.searching;

public class BinarySearch {
    public static void main(String[] args){
        int[] arr = { 5, 7, 9, 11, 14};
        int target = 14;
        int ans = search(arr, 0, arr.length-1, target);
//        String[] str = { "Ankit", "Deepak", "Rahul", "Rohit", "Yoyo"};
//        String target = "Rohit";
//        int ans = searchString(str, 0, str.length - 1, target);
        System.out.println(ans);
    }
    static int search(int[] arr, int start, int end, int target){
        if(start > end) return -1;
        int mid = start + (end - start)/2;
        if(arr[mid] == target) return mid;
        return (arr[mid] > target) ? search(arr, start, mid-1, target) : search(arr, mid+1, end, target);
    }
    static int searchString(String[] str, int start, int end, String target){
        if(start > end) return -1;
        int mid = start + (end - start)/2;
        if(str[mid].equals(target)) return mid;
        if(str[mid].charAt(0) > target.charAt(0)) return searchString(str, start, mid-1, target);
        else return searchString(str, mid+1, end, target);
    }
}
