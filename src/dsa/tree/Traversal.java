//package dsa.tree;
//
//import java.util.*;
//
//public class Traversal {
//    public static void main(String[] args) {
//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        list.add(5);
//        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
//        arr.add(list);
//        List<Integer> ans = bstTraversal(, new boolean[], new LinkedList<>());
//        System.out.println(Arrays.toString(ans.toArray()));
//    }
//    static List<Integer> bstTraversal(int[] arr, boolean[] visited, List<Integer> ans){
//        Queue<Integer> qu = new LinkedList<>();
//        for (int i = 0; i < arr.length; i++){
//            visited[i] = false;
//        }
//        visited[0] = true;
//        qu.add(0);
//
//        while (!qu.isEmpty()){
//            int cur = qu.remove();
//            for (int i = 0; i < ; i++){
//                if (!visited[i]){
//                    visited[i] = true;
//                    if(arr[i] != -1) ans.add(cur);
//                }
//            }
//        }
//        return ans;
//    }
//}
