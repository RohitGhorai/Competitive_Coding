package tcs_ipa.IPA47;

import java.util.*;

public class IPA47 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        ArrayList<Integer> list = findValidScores(arr);
        if (list.isEmpty()) System.out.println("No valid score found");
        else System.out.println("Valid Scores = " + Arrays.toString(list.toArray()));
    }
    static boolean validateScore(int num){
        return num <= 100 && num > 0;
    }
    static ArrayList<Integer> findValidScores(int[] nums){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : nums) if (validateScore(i)) list.add(i);
        return list;
    }
}
