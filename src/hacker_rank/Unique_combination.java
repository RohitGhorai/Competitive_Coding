package hacker_rank;

import java.util.ArrayList;

public class Unique_combination {
    public static void main(String[] args) {
        System.out.println(list_unique_combination("2 1 4 6 3", 6));
    }
    static int list_unique_combination(String str, int k){
        char[] ch = str.toCharArray();
        String s = "";
        for(int i = 0; i < ch.length; i++){
            if(ch[i] != ' ') s += ch[i];
        }
        int[] num = new int[s.length()];
        for(int i = 0; i < num.length; i++){
            num[i] = Integer.parseInt(String.valueOf(s.charAt(i)));
        }

        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        subSequenceSum(ans, 0, num, k, new ArrayList<>());

        // Loop to print the subsequences
        for (int i = 0; i < ans.size(); i++){
            for (int j = 0; j < ans.get(i).size(); j++){
                System.out.print(ans.get(i).get(j) + " ");
            }
            System.out.println();
        }

        int count = ans.size();

        return count;
    }
    static void subSequenceSum(ArrayList<ArrayList<Integer>> ans, int start, int[] a, int k, ArrayList<Integer> temp){
        if(start > a.length || k < 0) return;
        if(k == 0){
            ans.add(new ArrayList<Integer>(temp));
            return;
        } else {
            for(int i = start; i < a.length; i++){

                // Adding a new element into temp
                temp.add(a[i]);

                // After selecting an element from the array we subtract K by that value
                subSequenceSum(ans, i + 1, a, k - a[i], temp);

                // Remove the lastly added element
                temp.remove(temp.size() - 1);
            }
        }
    }
}
