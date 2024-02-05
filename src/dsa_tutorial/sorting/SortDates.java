package dsa_tutorial.sorting;

import java.util.Arrays;

public class SortDates {
    public static void main(String[] args) {
        String[] s1 = {"05121968","17121996","05061997","11081972","11081990"};
        sort(s1);
        System.out.println(Arrays.toString(s1));
    }
    static void sort(String[] str){
       countSort(str, 31, 1000000, 100);
       countSort(str, 12, 10000, 100);
       countSort(str, 2500, 1, 10000);
    }
    static void countSort(String[] str, int range, int div, int mod){
        int n = str.length;
        int[] freq = new int[range + 1];
        for (String val : str) freq[(Integer.parseInt(val) / div) % mod]++;

        for (int i = 1; i < freq.length; i++) freq[i] = freq[i - 1] + freq[i];

        String[] ans = new String[n];
        for (int i = n - 1; i >= 0; i--){
            int pos = freq[(Integer.parseInt(str[i]) / div) % mod];
            ans[pos - 1] = str[i];
            freq[(Integer.parseInt(str[i]) / div) % mod]--;
        }
        for (int i = 0; i < n; i++) str[i] = ans[i];
    }
}
