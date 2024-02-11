import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {4,1,2,8,5,3};
        System.out.println(Arrays.toString(arr));
    }
    /*
    static void sort(int[] arr){
        for (int i = 0; i < arr.length; i++){
            int min = i;
            for (int j = i + 1; j < arr.length; j++){
                if (arr[j] < arr[min]) min = j;
            }
            swap(arr, i, min);
        }
    }
    static void swap(int[] arr, int i, int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
    static void bubbleSort(int[] arr){
        for (int i = 0; i < arr.length; i++){
            for (int j = 1; j < arr.length - i; j++){
                if (arr[j - 1] > arr[j]){
                    swap(arr, j-1, j);
                }
            }
        }
    }
    static void insertionSort(int[] arr){
        for (int i = 1; i < arr.length; i++){
            int j = i - 1;
            int t = arr[i];
            while (j >= 0 && t < arr[j]){
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = t;
        }
    }
    static void quickSort(int[] arr, int l, int h){
        if (l >= h) return;
        int s = l;
        int e = h;
        int m = s + (e - s)/2;
        int p = arr[m];
        if (s < e) {
            while (arr[s] < p) s++;
            while (arr[e] > p) e--;
            if (s <= e){
                int t = arr[s];
                arr[s] = arr[e];
                arr[e] = t;
                s++;
                e--;
            }
        }
        quickSort(arr, s, h);
        quickSort(arr, l, e);
    }
     */
}
