package BOJ.Tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q_5639_이진검색트리 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Tree2 t = new Tree2();

        while(true) {
            String input = in.readLine();
            if(input == null || input.isEmpty()) {
                break;
            }
            t.makeTree(Integer.parseInt(input));
        }
        t.postOrder(t.node);
    }
}

class Tree2{
    static Node2 node;
    static int preNode;
    public static Node2 makeTree(int data){
        if(node == null){
            node = new Node2(data);
        }else {
            if(preNode > data || (node.left == null && node.data > data))
                insertLeft(node, data);
            else if(preNode < data || (node.right == null && node.data < data))
                insertRight(node, data);
        }
        preNode = data;

        return node;
    }

    public static void insertLeft(Node2 nowNode, int data){
        if (nowNode == null)
            return;
        if(nowNode.left != null)
            insertLeft(nowNode.left, data);
        else {
            if(nowNode.data > data)
                nowNode.left = new Node2(data);
            else
                insertRight(node, data);
        }
    }

    public static void insertRight(Node2 nowNode, int data){
        if (nowNode == null)
            return;
        if(nowNode.data < data && nowNode.right == null)
            nowNode.right = new Node2(data);
        if(nowNode.data > data && nowNode.left == null)
            nowNode.left = new Node2(data);
        if(nowNode.data > data && nowNode.left != null)
            insertRight(nowNode.left, data);
        else
            insertRight(nowNode.right, data);
    }

    public void postOrder(Node2 nowNode) {
        if (nowNode.left != null)
            postOrder(nowNode.left);
        if (nowNode.right != null)
            postOrder(nowNode.right);

        System.out.println(nowNode.data);
    }
}

class Node2{
    int data;
    Node2 left, right;

    public Node2(int data){
        this.data = data;
    }
}
