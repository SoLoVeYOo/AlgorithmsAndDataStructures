package hw_lesson4;

import java.util.Stack;

public class MyBinaryColorTree<T extends Comparable<T>>{
    private Node root;


    public boolean addNode(T value) {
        Node node = new Node(value);
        if (root == null) {
            root = node;
            root.color = Color.BLACK;
        } else if (tryAdd(node)) {
            root = reBalance(root);
        } else return false;
        return true;
    }

    private boolean tryAdd(Node newNode) {
        Stack<Node> stack = new Stack<>();
        Node temp = root;
        stack.add(temp);
        boolean flag = false;
        while (!flag) {
            int difference = temp.value.compareTo(newNode.value);
            if (difference != 0) {
                if (difference > 0) {
                    if (temp.left != null) {
                        stack.add(temp.left);
                        temp = temp.left;
                    } else {
                        temp.left = newNode;
                        flag = true;
                    }
                } else {
                    if (temp.right != null) {
                        stack.add(temp.right);
                        temp = temp.right;
                    } else {
                        temp.right = newNode;
                        flag = true;
                    }
                }
            } else {
                stack.clear();
                return false;
            }
        }
        Node lowerMostHave;
        while (!stack.isEmpty()) {
            lowerMostHave = stack.pop();
            if (lowerMostHave.left != null) lowerMostHave.left = reBalance(lowerMostHave.left);
            if (lowerMostHave.right != null) lowerMostHave.right = reBalance(lowerMostHave.right);

        }
        return flag;
    }

    private Node reBalance(Node node) {
        if (node.right != null && node.right.color == Color.RED &&
                (node.left == null || node.left.color == Color.BLACK)) {
            node = rightSwap(node);
        } else if (node.left != null && node.left.color == Color.RED &&
                node.left.left != null && node.left.left.color == Color.RED) {
            node = leftSwap(node);
        } else if (node.left != null && node.left.color == Color.RED &&
                node.right != null && node.right.color == Color.RED) {
            colorSwap(node);
        }
        return node;
    }

    private Node rightSwap(Node node) {
        Node rightChild = node.right;
        Node betweenChild = rightChild.left;
        rightChild.left = node;
        node.right = betweenChild;
        rightChild.color = node.color;
        node.color = Color.RED;
        return rightChild;
    }

    private Node leftSwap(Node node) {
        Node leftChild = node.left;
        Node betweenChild = leftChild.right;
        leftChild.right = node;
        node.left = betweenChild;
        leftChild.color = node.color;
        node.color = Color.RED;
        return leftChild;
    }

    private void colorSwap(Node node){
        node.right.color = Color.BLACK;
        node.left.color = Color.BLACK;
        node.color = Color.RED;
    }

    public void printTreeUpperMost() {
        if (root == null) System.out.println("Tree is empty");
        else if (root.left == null) System.out.println("Left is null");
        else if (root.right == null) System.out.println("Right is null");
        else {
            System.out.printf("root: %s(%s), left: %s(%s), right: %s(%s)\n",
                    root.value, root.color, root.left.value, root.left.color, root.right.value, root.right.color);
        }
    }
}
