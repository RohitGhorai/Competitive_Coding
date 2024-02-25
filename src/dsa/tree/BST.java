package dsa.tree;

public class BST {
    static class Node {
        int val;
        int height;
        Node right;
        Node left;

        Node(int val){
            this.val = val;
        }
    }
    private Node root;

    public void populated(int[] arr){
        for (int i : arr) this.insert(i);
    }
    public void insert(int val){
        root = insert(val, root);
    }
    public Node insert(int val, Node node){
        if (node == null) {
            node = new Node(val);
            return node;
        }
        if(val < node.val) node.left = insert(val, node.left);
        if (val > node.val) node.right = insert(val, node.right);

        node.height = Math.max(height(node.left), height(node.right)) + 1;

        return node;
    }

    public int height(Node node){
        if (node == null) return -1;
        return node.height;
    }

    public void display(){
        display(root);
        System.out.println(root.height);
    }
    public void display(Node node){
        if (node == null){
            return;
        }
        System.out.println(node.val + " ");
        display(node.left);
        display(node.right);
    }

    public static void main(String[] args) {
        int[] arr = {20,15,10,17,30,25};
        BST bst = new BST();
        bst.populated(arr);
        bst.display();
    }

}
