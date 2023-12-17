package Trees;

import java.util.*;
import java.io.*;


public class LinkedBinaryTree<T> implements BinaryTreeADT<T>, Iterable<T> {
    protected BinaryTreeNode<T> root;
    protected int modCount;
    public LinkedBinaryTree() {
        root = null;
    }
    public LinkedBinaryTree(T element) {
        root = new BinaryTreeNode<T>(element);
    }

    public LinkedBinaryTree(T element, LinkedBinaryTree<T> left, LinkedBinaryTree<T> right) {
        root = new BinaryTreeNode<>(element);
        if (left != null) {
            root.setLeft(left.root);
        }
        if (right != null) {
            root.setRight(right.root);
        }
    }
    public T find(T targetElement) throws Exception {
        BinaryTreeNode<T> current = findNode(targetElement, root);
        if (current == null) {
            throw new Exception("LinkedBinaryTree");
        }
        return (current.getElement());  
    }
    private BinaryTreeNode<T> findNode(T targetElement, BinaryTreeNode<T> next) {
        if (next == null) {
            return null;
        }
        if (next.getElement().equals(targetElement)) {
            return next;
        }
        BinaryTreeNode<T> temp = findNode(targetElement, next.getLeft());
        if (temp == null) {
            temp = findNode(targetElement, next.getRight());
        }
        return temp;
    }
    public Iterator<T> iteratorInOrder() {
        ArrayList<T> tempList = new ArrayList<T>();
        inOrder(root, tempList);
        return tempList.iterator();
    }
    private void inOrder(BinaryTreeNode<T> node, ArrayList<T> tempList) {
        if (node != null) {
            inOrder(node.getLeft(), tempList);
            tempList.add(node.getElement());
            inOrder(node.getRight(), tempList);
        }
    }
    public Iterator<T> iteratorPreOrder() {
        ArrayList<T> tempList = new ArrayList<T>();
        preOrder(root, tempList);
        return tempList.iterator();
    }
    private void preOrder(BinaryTreeNode<T> node, ArrayList<T> tempList) {
        if (node != null) {
            tempList.add(node.getElement());
            preOrder(node.getLeft(), tempList);
            preOrder(node.getRight(), tempList);
        }
    }
    public Iterator<T> iteratorPostOrder() {
        ArrayList<T> tempList = new ArrayList<T>();
        postOrder(root, tempList);
        return tempList.iterator();
    }
    private void postOrder(BinaryTreeNode<T> node, ArrayList<T> tempList) {
        if (node != null) {
            preOrder(node.getLeft(), tempList);
            preOrder(node.getRight(), tempList);
            tempList.add(node.getElement());
        }
    }
    public Iterator<T> iteratorLevelOrder() {
        Queue<T> tempQueue = new LinkedList<T>();
        levelOrder(root, tempQueue);
        return tempQueue.iterator();
    }
    private void levelOrder(BinaryTreeNode<T> node, Queue<T> tempQueue) {
        if (node != null) {
            tempQueue.poll();
            tempQueue.add(node.getElement());
            levelOrder(node.getLeft(), tempQueue);
            levelOrder(node.getRight(), tempQueue);
        }
    }
    public BinaryTreeNode<T> getRootNode() throws EmptyCollectionException {
        if (root == null) {
            throw new EmptyCollectionException("tree");
        }
        return root;
    }
    public T getRootElement() {
        return root.getElement();
    }
    public boolean contains(T targetElement) {
        boolean found = true;
        try {
            T temp = find(targetElement);
            found = true;
        } catch (Exception ElementNotFoundException) {
            found = false;
        }
        return found;
    }
    public boolean isEmpty() {
        return (root == null);
    }
    public Iterator<T> iterator() {
        return iteratorInOrder();
    }
    public int size() {
        int count = 0;
        if (root != null) {
            count = 1 + root.numChildren();
        }
        return count;
    }
    public String toString() {
        ArrayList<T> tempList = new ArrayList<T>();
        inOrder(root, tempList);
        return tempList.toString();
    }
    
}
