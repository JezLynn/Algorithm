package de.jez_lynn.algorithm.util;

import java.util.LinkedList;

public class BinaryTree<E extends Comparable> {
    private Node root;

    public BinaryTree(E[] data) {
        for (E c : data) {
            if (addNode(c)) ;
        }
    }

    public boolean addNode(E key) {
        Node newNode = new Node(key);

        if (root == null) {
            root = newNode;
        } else {
            Node focused = root;
            Node parent;
            while (true) {
                parent = focused;
                if (key.compareTo(focused.key) <= 0) {
                    focused = focused.leftChild;
                    if (focused == null) {
                        parent.leftChild = newNode;
                        return true;
                    }
                } else {
                    focused = focused.rightChild;
                    if (focused == null) {
                        parent.rightChild = newNode;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public Comparable[] toArray() {
        LinkedList<Comparable> result = new LinkedList<>();
        if (root != null) {
            inOrderTraverseTree(root, result);
        }
        return result.toArray(new Comparable[result.size()]);
    }

    private void inOrderTraverseTree(Node focusNode, LinkedList<Comparable> result) {
        if (focusNode != null) {
            inOrderTraverseTree(focusNode.leftChild, result);
            result.addLast(focusNode.key);
            inOrderTraverseTree(focusNode.rightChild, result);
        }
    }

    private class Node<E extends Comparable> {
        E key;

        Node leftChild, rightChild;

        Node(E key) {
            this.key = key;
        }
    }
}
