package qn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountFreq {
    public static void main(String[] args) {
        int[] arr = {10,10,20,1,10,30,20,30,20};
        freq2(arr, arr.length);
    }
    static void freq(int[] arr, int n){
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i = 0; i < n; i++){
            if(mp.containsKey(arr[i])){
                mp.put(arr[i], mp.get(arr[i])+1);
            }
            else {
                mp.put(arr[i], 1);
            }
        }
        for(Map.Entry<Integer, Integer> entry : mp.entrySet()){
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
    static void freq2(int[] arr, int n){
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);

        for(int i = 0; i < n; i++){
            if(visited[i]){
                continue;
            }
            int count = 1;
            for(int j = i + 1; j < n; j++){
                if(arr[i] == arr[j]){
                    visited[j] = true;
                    count++;
                }
            }
            System.out.println(arr[i] + " = " + count);
        }
    }
    static void freq3(int[] arr){
        int[] freq = new int[1000];
        Arrays.fill(freq, 0);
        for(int i = 0; i < arr.length; i++){
            freq[arr[i]]++;
        }
        for(int i = 0; i < freq.length; i++){
            if(freq[i] != 0){
                System.out.println(i + " = " + freq[i]);
            }
        }
    }
}
