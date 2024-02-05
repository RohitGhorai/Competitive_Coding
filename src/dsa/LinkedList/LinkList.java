package dsa.LinkedList;

public class LinkList {
    private Node head;
    private int size;
    public LinkList() {
        this.size = 0;
    }

//    public void add(Node l1, Node l2){
//        Node result = new Node(0);
//        Node node = result;
//        int carry = 0;
//        while (l1 != null && l2 != null){
//            int sum = 0 + carry;
//            if(l1 != null){
//                sum += l1.val;
//                l1 = l1.next;
//            }
//            if(l2 != null){
//                sum += l2.val;
//                l2 = l2.next;
//            }
//            carry = sum / 10;
//            sum = sum % 10;
//            node = new Node(sum);
//            result.next = node;
//        }
//        if(carry == 1) result.next = new Node(1);
//    }

    public int delete(int index){
        if(index == 0) deleteFirst();
        if(index == size-1) deleteLast();
        Node node = getNode(index);
        int val = node.next.val;
        node.next = node.next.next;
        size--;
        return val;
    }
    public int deleteFirst(){
        int val = head.val;
        head = head.next;
        size--;
        return val;
    }

    public int deleteLast(){
        if(size <= 1) deleteFirst();
        Node last = getNode(size-1);
        int val = last.next.val;
        last.next = null;
        return val;
    }
    public void insert(int val, int index){
        if(index == 0) {
            insertFirst(val);
            return;
        }
        if(index == size-1) {
            insertLast(val);
        }
        Node temp = getNode(index);
        Node node = new Node(val, temp.next);
        temp.next = node;
        size++;
    }

    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;
        size++;
    }
    public void insertLast(int val){
        if(size <= 1) insertFirst(val);
        Node node = new Node(val);
        Node last = head;
        while(last.next != null) last = last.next;
        last.next = node;
        node.next = null;
        size++;
    }
    public void display(){
        Node node = head;
        while(node != null){
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println("End");
    }
    public Node getNode(int index){
        Node node = head;
        for(int i = 1; i < index; i++){
            node = node.next;
        }
        return node;
    }

    public Node findNode(int val){
        Node node = head;
        while(node != null){
            if(node.val == val) {
                return node;
            }
            node = node.next;
        }
        return null;
    }
    private class Node {
        private int val;
        private Node next;

        public Node(int val){
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
}
