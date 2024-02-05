package dsa.LinkedList;

public class Main {
    public static void main(String[] args) {
//        LinkList ll = new LinkList();
//        ll.insertFirst(20);
//        ll.insertFirst(30);
//        ll.insertFirst(40);
//        ll.insertFirst(50);
//        ll.insertLast(60);
//        ll.insertLast(70);
//        ll.insertLast(80);
//        ll.display();
//        ll.insert(70, 2);
//        ll.display();
//        System.out.println(ll.deleteFirst());
//        ll.display();
//        System.out.println(ll.deleteLast());
//        ll.display();
//        System.out.println(ll.delete(2));
//        ll.display();
//        System.out.println(ll.findNode(20));

        DoubleLL dll = new DoubleLL();
        dll.insertFirst(20);
        dll.insertFirst(30);
        dll.insertFirst(40);
        dll.insertFirst(50);
        dll.insertLast(60);
        dll.insertLast(70);
        dll.insertLast(80);
        dll.insert(45, 4);
        System.out.println(dll.deleteFirst());
//        System.out.println(dll.deleteLast());
//        System.out.println(dll.delete(4));
        dll.display();
    }
}
