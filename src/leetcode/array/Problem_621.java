package leetcode.array;

import java.util.Arrays;

public class Problem_621 {
    public static void main(String[] args) {
        char[] tasks = {'A','A','A','B','B','B'};
        int interval = 3;
        int ans = leastInterval(tasks, interval);
        System.out.println(ans);
    }

    static int leastInterval(char[] ch, int n){
        int[] freq = new int[26];
        for (char c : ch) freq[c - 'A']++;
        Arrays.sort(freq);
        int i = 25;
        while (i >= 0 && freq[i] == freq[25]) i--;
        return Math.max(ch.length, (freq[25] - 1)*(n + 1) + 25 - i);
    }
}
