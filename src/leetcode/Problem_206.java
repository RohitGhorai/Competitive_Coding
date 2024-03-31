package leetcode;

// Leetcode; https://leetcode.com/problems/reverse-linked-list/

public class Problem_206 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        Problem_206 p = new Problem_206();
        ListNode l1 = p.buildNode(arr);
        display(l1);
        ListNode ans = reverse(l1);
        display(ans);
    }

    static ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null){
            ListNode node = curr.next;
            curr.next = prev;
            prev = curr;
            curr = node;
        }
        return prev;
    }

    static void display(ListNode node){
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println("null");
    }

    ListNode buildNode(int[] arr){
        if (arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode node = head;
        for (int i = 1; i < arr.length; i++) {
            node.next = new ListNode(arr[i]);
            node = node.next;
        }
        return head;
    }
    class ListNode{
        int val;
        ListNode next;
        ListNode(){};
        ListNode(int val) {
            this.val = val;
        }
    }

}
