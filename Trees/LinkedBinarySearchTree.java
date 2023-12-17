package Trees;

import java.util.*;
import java.io.*;

public class LinkedBinarySearchTree<T extends BinaryTreeNode<T>> implements BinarySearchTreeADT<T> {
    protected BinaryTreeNode<T> root;
    protected int modCount;
    public LinkedBinarySearchTree() {
        super();
    }

    public LinkedBinarySearchTree(T element) throws NonComparableElementException {
        super(element);
        if (!(element instanceof Comparable)) {
            throw new NonComparableElementException("LinkedBinarySearchTree");
        }

    }

    public void addElement(T element) throws NonComparableElementException {
        if (!(element instanceof Comparable)) {
            throw new NonComparableElementException("LinkedBinarySearchTree");
        }
        Comparable<T> comparableElement = (Comparable<T>) element;
        if (isEmpty()) {
            root = new BinaryTreeNode<T>(element);
        } else {
            if (comparableElement.compareTo(root.getElement()) < 0) {
                if (root.getLeft() == null) {
                    this.getRootNode().setLeft(new BinaryTreeNode<T>(element));
                } else {
                    addElement(element, root.getLeft());
                }
            } else {
                if (root.getRight() == null) {
                    this.getRootNode().setRight(new BinaryTreeNode<T>(element));
                } else {
                    addElement(element, root.getRight());
                }
            }
        }
        modCount++;
    }

    private void addElement(T element, BinaryTreeNode<T> node) {
        Comparable<T> comparableElement = (Comparable<T>) element;
        if (comparableElement.compareTo(node.getElement()) < 0) {
            if (node.getLeft() == null) {
                node.setLeft(new BinaryTreeNode<T>(element));
            } else {
                addElement(element, node.getLeft());
            }
        } else {
            if (node.getRight() == null) {
                node.setRight(new BinaryTreeNode<T>(element));
            } else {
                addElement(element, node.getRight());
            }
        }
    }

    private BinaryTreeNode<T> getRootNode() {
        return root;
    }
    public T removeElement(T targetElement) throws ElementNotFoundException {
        T result = null;
        if (isEmpty()) {
            throw new ElementNotFoundException("LinkedBinarySearchTree");
        } else {
            BinaryTreeNode<T> parent = null;
            if (((Comparable<T>) targetElement).equals(root.getElement())) {
                result = root.getElement();
                BinaryTreeNode<T> temp = replacement(root);
                if (temp == null) {
                    root = null;
                } else {
                    root.setElement(temp.getElement());
                    root.setRight(temp.getRight());
                    root.setLeft(temp.getLeft());
                }
                modCount--;
            } else {
                parent = root;
                if (((Comparable) targetElement).compareTo(root.getElement()) < 0) {
                    result = removeElement(targetElement, root.getLeft(), parent);
                } else {
                    result = removeElement(targetElement, root.getRight(), parent);
                }
            }
        }
        return result;
    }
    private T removeElement(T targetElement, BinaryTreeNode<T> node, BinaryTreeNode<T> parent) throws ElementNotFoundException {
        T result = null;
        if (node == null) {
            throw new ElementNotFoundException("LinkedBinarySearchTree");
        } else {
            if (((Comparable<T>)targetElement).equals(node.getElement())) {
                result = node.element;
                BinaryTreeNode<T> temp = replacement(node);
                if (parent.right == node) {
                    parent.right = temp;
                } else {
                    parent.left = temp;
                }
                modCount--;
            } else {
                parent = node;
                if (((Comparable<T>)targetElement).compareTo(node.element) < 0) {
                    result = removeElement(targetElement, node.getLeft(), parent);
                } else {
                    result = removeElement(targetElement, node.getRight(), parent);
                }
            }
        }
        return result;
    }
    private BinaryTreeNode<T> replacement(BinaryTreeNode<T> node) {
        BinaryTreeNode<T> result = null;
        if ((node.left == null) && (node.right == null)) {
            result = null;
        } else if ((node.left != null) && (node.right == null)) {
            result = node.left;
        } else if ((node.left == null) && (node.right != null)) {
            result = node.right;
        } else {
            BinaryTreeNode<T> current = node.right;
            BinaryTreeNode<T> parent = node;
            while (current.left != null) {
                parent = current;
                current = current.left;
            }
            current.left = node.left;
            if (node.right != current) {
                parent.left = current.right;
                current.right = node.right;
            }
            result = current;
        }
        return result;
    }
    public void removeAllOccurrences(T targetElement) throws ElementNotFoundException {
        removeElement(targetElement);
        try {
            while (contains((T)targetElement)) {
                removeElement(targetElement);
            }
        } catch (ElementNotFoundException e) {
            
        }
    }
    public T removeMin() throws EmptyCollectionException {
        T result = null;
        if (isEmpty()) {
            throw new EmptyCollectionException("LinkedBinarySearchTree");
        } else {
            if (root.left == null) {
                result = root.element;
                root = root.right;
            } else {
                BinaryTreeNode<T> parent = root;
                BinaryTreeNode<T> current = root.left;
                while (current.left != null) {
                    parent = current;
                    current = current.left;
                }
                result = current.element;
                parent.left = current.right;
            }
            modCount--;
        }
        return result;
    }
    public T removeMax() throws EmptyCollectionException {
        T result = null;
        if (isEmpty()) {
            throw new EmptyCollectionException("LinkedBinarySearchTree");
        } else {
            if (root.right == null) {
                result = root.element;
                root = root.left;
            } else {
                BinaryTreeNode<T> parent = root;
                BinaryTreeNode<T> current = root.right;
                while (current.right != null) {
                    parent = current;
                    current = current.right;
                }
                result = current.element;
                parent.right = current.left;
            }
            modCount--;
        }
        return result;
    }
    public T findMin() throws EmptyCollectionException {
        T result = null;

    }
}



