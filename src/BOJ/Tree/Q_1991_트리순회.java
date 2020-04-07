package BOJ.Tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q_1991_트리순회 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());

        Tree t = new Tree();

        char data[];
        for(int i = 0; i < n; i++){
            data = in.readLine().replaceAll(" ", "").toCharArray();
            t.add(data[0], data[1], data[2]);
        }

        System.out.println(t.preOrder(t.root));
        System.out.println(t.inOrder(t.root));
        System.out.println(t.postOrder(t.root));
        in.close();
    }
}

/*
   1. 트리의 기초인 노드 클래스를 먼저 생성한다.
   2. 트리 클래스를 만든다. 트리 클래스는 아래의 메서드들로 구성된다.
       (1) 값을 추가하는 add() 메서드
       (2) 어느 위치에 추가할 것인지 위치를 찾아주는 search()메서드
       (3) 전위순회(preOrder), 중위순회(inOrder), 후위순회(postOrder)메서드
*/

class Tree {
    Node root;

    public void add(char data, char leftData, char rightData) {
        if (root == null) {
            if (data != '.')
                root = new Node(data);
            if (leftData != '.')
                root.left = new Node(leftData);
            if (rightData != '.')
                root.right = new Node(rightData);
        } else
            search(root, data, leftData, rightData);
    }

    private void search(Node nowNode, char data, char leftData, char rightData) {
        // 재귀를 사용하므로 도착한 노드가 삽입 위치를 찾지 못한 경우(null) 이면 종료
        if (nowNode == null)
            return;
        else if (nowNode.data == data) {
            if (leftData != '.')
                nowNode.left = new Node(leftData);
            if (rightData != '.')
                nowNode.right = new Node(rightData);
        } else {
            search(nowNode.left, data, leftData, rightData);
            search(nowNode.right, data, leftData, rightData);
        }
    }

    static StringBuilder preOrderResult = new StringBuilder();
    public StringBuilder preOrder(Node nowNode) {
        preOrderResult.append(nowNode.data);
        if (nowNode.left != null)
            preOrder(nowNode.left);
        if (nowNode.right != null)
            preOrder(nowNode.right);

        return preOrderResult;
    }

    static StringBuilder inOrderResult = new StringBuilder();
    public StringBuilder inOrder(Node nowNode) {
        if (nowNode.left != null)
            inOrder(nowNode.left);
        inOrderResult.append(nowNode.data);
        if (nowNode.right != null)
            inOrder(nowNode.right);

        return inOrderResult;
    }

    static StringBuilder postOrderResult = new StringBuilder();
    public StringBuilder postOrder(Node nowNode) {
        if (nowNode.left != null)
            postOrder(nowNode.left);
        if (nowNode.right != null)
            postOrder(nowNode.right);
        postOrderResult.append(nowNode.data);

        return postOrderResult;
    }
}

class Node{
    char data;
    Node left, right;

    public Node(char data){
        this.data = data;
    }
}
