package Heap;

import Trees.BinaryTreeNode;

public class HeapNode<T> extends BinaryTreeNode<T> {
    protected HeapNode<T> parent;
    protected HeapNode<T> root;
    public HeapNode(T obj) {
        super(obj);
        parent = null;
    }
    public HeapNode<T> getParent() {
        return parent;
    }
    public void setElement(T obj) {
        element = obj;
    }
    public void setParent(HeapNode<T> node) {
        parent = node;
    }
    public void addElement(T obj) {
        HeapNode<T> node = new HeapNode<T>(obj);
        if (root == null) {
            root = node;
        } else {
            HeapNode<T> next_parent = getNextParentAdd();
            if (next_parent.getLeft() == null) {
                next_parent.setLeft(node);
            } else {
                next_parent.setRight(node);
            }
            node.setParent(next_parent);
        }
    }
    
}
