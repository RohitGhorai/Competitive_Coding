package dsa_tutorial.linkedlist;

import java.util.*;

public class MergeLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> l1 = new LinkedList<>();
        l1.add(2);
        l1.add(6);
        l1.add(8);
        l1.add(10);
        l1.add(12);
        LinkedList<Integer> l2 = new LinkedList<>();
        l2.add(3);
        l2.add(4);
        l2.add(6);
        l2.add(7);
        l2.add(8);
        LinkedList<Integer> list = merge(l1, l2);
        System.out.println(list);
    }
    static LinkedList<Integer> merge(LinkedList<Integer> l1, LinkedList<Integer> l2){
        LinkedList<Integer> mix = new LinkedList<>();
        int i = 0, j = 0;
        while (i < l1.size() && j < l2.size()){
            if (l1.get(i) < l2.get(j)){
                mix.add(l1.get(i));
                i++;
            } else {
                mix.add(l2.get(j));
                j++;
            }
        }
        while (i < l1.size()){
            mix.add(l1.get(i));
            i++;
        }
        while (j < l2.size()){
            mix.add(l2.get(j));
            j++;
        }
        return mix;
    }
}
