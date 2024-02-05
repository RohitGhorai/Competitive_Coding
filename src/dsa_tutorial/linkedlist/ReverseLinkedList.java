package dsa_tutorial.linkedlist;

import java.util.*;

public class ReverseLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(list);
        LinkedList<Integer> res = reverse(list);
        System.out.println(res);
//        ReverseLinkedList list = new ReverseLinkedList();
//        list.addFirst(1);
//        list.addFirst(2);
//        list.addFirst(3);
//        list.addFirst(4);
//        list.print();
//        list.reverse_2();
//        list.print();
    }
    static LinkedList<Integer> reverse(LinkedList<Integer> list){
        LinkedList<Integer> ll = new LinkedList<>();
        int n = list.size();
        while (n > 0){
            ll.add(list.get(n-1));
            n--;
        }
        return ll;
    }
    /*Node head;
    int size;
    public void addFirst(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;
        size++;
    }
    public void addLast(int val){
        if (head == null) addFirst(val);
        Node node = new Node(val);
        Node secondLast = head;
        while (secondLast.next != null){
            secondLast = secondLast.next;
        }
        secondLast.next = node;
        node.next = null;
        size++;
    }
    public void print(){
        Node list = head;
        while (list != null){
            System.out.print(list.val + " --> ");
            list = list.next;
        }
        System.out.println("null");
    }
    public void reverse_2(){
        if (head == null || head.next == null) return;
        Node prev = head;
        Node curr = prev.next;
        while (curr != null){
            Node nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        head.next = null;
        head = prev;
    }
    class Node {
        private int val;
        private Node next;
        public Node(int val){
            this.val = val;
        }
        public Node(int val, Node next){
            this.val = val;
            this.next = next;
        }
    }*/
}
