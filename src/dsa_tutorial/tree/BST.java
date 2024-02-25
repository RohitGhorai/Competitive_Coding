package dsa_tutorial.tree;

import java.util.*;

public class BST {

    public static void main(String[] args) {
        int[] arr = {20,15,10,17,30,25};
        BST bst = new BST();
        bst.populated(arr);
        bst.display();
        System.out.println(bst.valid());
        bst.topView();
    }
    private Node root;

    public void display(){
        display(root);
        System.out.println("\nMax height of tree : " + root.height);
    }
    public void display(Node node){
        if (node == null) return;
        display(node.left);
        System.out.print(node.val + " ");
        display(node.right);
    }

    public void populated(int[] arr){
        for (int i : arr) root = insert(i, root);
    }

    public int height(Node node){
        if (node == null) return -1;
        return node.height;
    }
    public Node insert(int val, Node node){
        if (node == null) {
            node = new Node(val);
            return node;
        }
        if (val < node.val) node.left = insert(val, node.left);
        if (val > node.val) node.right = insert(val, node.right);

        node.height = Math.max(height(node.left), height(node.right)) + 1;

        return node;
    }
    public void topView(){
        topView(root);
    }
    public void topView(Node root){
        if (root == null);
        Map<Integer, Integer> map = new HashMap<>();
        Queue<NodeWithLevel> q = new LinkedList<>();
        q.add(new NodeWithLevel(0, root));
        while (!q.isEmpty()){
            NodeWithLevel cur = q.poll();
            int level = cur.level;
            Node node = cur.node;
            if (!map.containsKey(level)) map.put(level, node.val);
            if (node.left != null) q.add(new NodeWithLevel(level - 1, node.left));
            if (node.right != null) q.add(new NodeWithLevel(level + 1, node.right));
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) System.out.println(entry.getValue() + " " + entry.getKey());
        for (int key : map.keySet()) System.out.print(key + " ");
    }
    private class NodeWithLevel{
        int level;
        Node node;
        NodeWithLevel(int level, Node node){
            this.level = level;
            this.node = node;
        }
    }
    public boolean valid(){
        return isValidBST(root, null, null);
    }
    public boolean isValidBST(Node root, Integer lower, Integer upper) {
        if (root == null) return true;
        if (lower != null && root.val <= lower) return false;
        if (upper != null && root.val >= upper) return false;
        return isValidBST(root.left, lower, root.val) && isValidBST(root.right, root.val, upper);
    }
    private class Node{
        int val;
        int height;
        Node right;
        Node left;
        Node(int val) {
            this.val = val;
        }
    }
}
