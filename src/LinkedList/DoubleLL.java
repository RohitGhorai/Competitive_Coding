package LinkedList;

public class DoubleLL {
    private Node head;
    private int size;

    public DoubleLL() {
        this.size = 0;
    }

//    public int delete(int index){
//        Node node = getNode(index);
//        int val = node.next.value;
//        node.prev = node.next.prev.prev;
//        node.next = node.next.next;
//        size--;
//        return val;
//    }

    public int deleteFirst(){
        if(head == null) return -1;
        int val = head.value;
        head = head.next;
        head.prev = null;
        if(head.next != null) head.next.prev = head;
        size--;
        return val;
    }

    public int deleteLast(){
        if(size <= 1) deleteFirst();
        Node last = getNode(size-1);
        int val = last.next.value;
        last.next = null;
        size--;
        return val;
    }
    public void insert(int val, int index){
        if(index == 0) insertFirst(val);
        if(index == size-1) insertLast(val);
        Node node = new Node(val);
        Node p = getNode(index);
        node.next = p.next;
        p.next = node;
        node.prev = p;
        if(node.next != null){
            node.next.prev = node;
        }
        size++;
    }
    public void insertFirst(int val){
        Node node = new Node(val);
        node.prev = null;
        node.next = head;
        if(head != null) head.prev = node;
        head = node;
        size++;
    }

    public void insertLast(int val){
        if(size <= 1) insertFirst(val);
        Node node = new Node(val);
        node.next = null;
        if(head == null){
            node.prev = null;
            head = node;
            return;
        }
        Node last = head;
        while(last.next != null){
            last = last.next;
        }
        last.next = node;
        node.prev = last;
        size++;
    }
    public Node getNode(int index){
        Node node = head;
        for(int i = 1; i < index; i++){
            node = node.next;
        }
        return node;
    }
    public void display(){
        Node node = head;
        Node last = null;
        while(node != null){
            System.out.print(node.value + " -> ");
            last = node;
            node = node.next;
        }
        System.out.println("End");
        while(last != null){
            System.out.print(last.value + " -> ");
            last = last.prev;
        }
        System.out.println("Start");
    }

    private class Node {
        private int value;
        private Node next;
        private Node prev;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
}
