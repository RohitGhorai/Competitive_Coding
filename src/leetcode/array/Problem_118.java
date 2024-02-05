package leetcode.array;

import java.util.*;

// Pascal's triangle
public class Problem_118 {
    public static void main(String[] args) {
//        List<List<Integer>> ans = generate(5);
//        for (List<Integer> l : ans){
//            System.out.println(l);
//        }
        /*int numRow = 5;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < numRow; i++){
            ans.add(getRow(i));
        }
        for (List<Integer> l : ans){
            System.out.println(l);
        }*/
        System.out.println(getRow(4));
    }
    static List<List<Integer>> generate(int numRows){
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        l.add(1);
        ans.add(l);
        if (numRows == 1) return ans;
        recursion(1, numRows, ans);
        return ans;
    }
    static void recursion(int row, int numRows, List<List<Integer>> ans){
        if (row == numRows) return;
        List<Integer> l = new ArrayList<>();
        l.add(1);
        for (int i = 1; i < row; i++){
            l.add(ans.get(row - 1).get(i - 1) + ans.get(row - 1).get(i));
        }
        l.add(1);
        ans.add(l);
        recursion(row + 1, numRows, ans);
    }

    static List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        result.add(1);

        if(rowIndex == 0) return result;

        List<Integer> prev = getRow(rowIndex - 1);
        for(int i=0; i < prev.size()-1; i++){
            result.add(prev.get(i) + prev.get(i+1));
        }
        result.add(1);

        return result;
    }
}
