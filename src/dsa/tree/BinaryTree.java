package dsa.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    static class Tree{
        static int i = -1;
        static Node buildTree(int[] node){
            i++;
            if(node[i] == -1) return null;
            Node newNode = new Node(node[i]);
            newNode.left = buildTree(node);
            newNode.right = buildTree(node);
            return newNode;
        }
    }
    static class TreeDiam{
        int ht;
        int diam;
        TreeDiam(int ht, int diam){
            this.ht = ht;
            this.diam = diam;
        }
    }

    static TreeDiam diameter2(Node root){
        if(root == null) return new TreeDiam(0, 0);
        TreeDiam left = diameter2(root.left);
        TreeDiam right = diameter2(root.right);
        int height = Math.max(left.ht, right.ht) + 1;

        int diam1 = left.diam;
        int diam2 = right.diam;
        int diam3 = diam1 + diam2 + 1;
        int diameter = Math.max(Math.max(diam1, diam2), diam3);
        TreeDiam treeDiam = new TreeDiam(height, diameter);
        return treeDiam;
    }
    static void preOrderTree(Node root){
        if(root == null) return;
        System.out.print(root.data + " ");
        preOrderTree(root.left);
        preOrderTree(root.right);
    }

    static void inOrder(Node root){
        if(root == null) return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    static void postOrder(Node root){
        if(root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    static void levelOrder(Node root){
        if(root == null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            Node currentNode = q.remove();
            if(currentNode == null) {
                System.out.println();
                if(q.isEmpty()) break;
                else q.add(null);
            }
            else {
                System.out.print(currentNode.data + " ");
                if(currentNode.left != null) q.add(currentNode.left);
                if(currentNode.right != null) q.add(currentNode.right);
            }
        }
    }
    static int countOfNode(Node root){
        if(root == null) return 0;
        int leftNode = countOfNode(root.left);
        int rightNode = countOfNode(root.right);

        return leftNode + rightNode + 1;
    }

    static int sumOfNode(Node root){
        if(root == null) return 0;
        int leftNode = sumOfNode(root.left);
        int rightNode = sumOfNode(root.right);

        return leftNode + rightNode + root.data;
    }

    static int heightOfTree(Node root){
        if(root == null) return 0;
        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.right);
        int height = Math.max(leftHeight, rightHeight) + 1;
        return height;
    }
    static int diameter(Node root){
        if(root == null) return 0;
        int diam1 = diameter(root.left);
        int diam2 = diameter(root.right);
        int diam3 = heightOfTree(root.left) + heightOfTree(root.right) + 1;
        return Math.max(Math.max(diam1, diam2), diam3);
    }
    public static void main(String[] args) {
       int[] nodes = {5, 4, -1, -1, 3, 6, -1, -1, -1};
       Node root = Tree.buildTree(nodes);
//       System.out.println(root.data);
//       levelOrder(root);
        System.out.println(diameter2(root).ht);
    }
}

