package guı_version_3;

import java.util.ArrayList;

public class Tree {

    Node node;
    ArrayList<Integer> list ;
    
    Tree(int id, int value) {
        node = new Node(id, value);
        list = new ArrayList<Integer>();
    }

    public Node insert(Node node, int id, int value) {
        if (node == null) {
            return new Node(id, value);
        }
        if (value < node.value) {
            node.left = insert(node.left, id, value);
        } else if (value > node.value) {
            node.right = insert(node.right, id, value);
        }
        return node;
    }

    public ArrayList<Integer> inOrder(Node node) {

        if (node != null) {
            inOrder(node.left);
            if (node.value != 0) {
                list.add(node.value);
            }
            inOrder(node.right);
        }
        return list;
    }

    public ArrayList<Integer> inOrderDesc(Node node) {

        if (node != null) {
            inOrderDesc(node.right);
            if (node.value != 0) {
                list.add(node.value);
            }
            inOrderDesc(node.left);
        }
        return list;
    }

    public ArrayList<Integer> betweenOrder(Node node, int start, int finish) {
        
        if (start != finish && start > finish) {
            int t = finish;
            finish = start;
            start = t;
        }
        if (node != null) {
            inOrderDesc(node.right);
            if (node.value != 0 && node.value >= start && node.value <= finish) {
                list.add(node.value);
            }
            inOrderDesc(node.left);
        }
        return list;
    }

}
