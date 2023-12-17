
import java.util.*;
import java.io.*;

public class LinkedBinarySearchTree<T extends Comparable<T>> extends LinkedBinaryTree<T>
        implements BinarySearchTreeADT<T> {
    protected BinaryTreeNode<T> root;

    public LinkedBinarySearchTree() {
        super();
    }

    public LinkedBinarySearchTree(T element) {
        super(element, null, null);
    }

    public void addElement(T element) {
        BinaryTreeNode<T> temp = new BinaryTreeNode<T>(element);
        if (isEmpty()) {
            root = temp;
        } else {
            BinaryTreeNode<T> current = root;
            boolean added = false;

            while (!added) {
                if (current.element.compareTo(element) > 0) {
                    if (current.left == null) {
                        current.left = temp;
                        added = true;
                    } else
                        current = current.left;
                } else {
                    if (current.right == null) {
                        current.right = temp;
                        added = true;
                    } else
                        current = current.right;
                }
            }
        }
        count++;
    }

    public T removeElement(T element) {
        T result = null;
        if (!isEmpty()) {
            if (element.equals(root.element)) {
                result = root.element;
                root = replacement(root);
                count--;
            } else {
                BinaryTreeNode<T> current, parent = root;
                boolean found = false;

                if (element.compareTo(root.element) < 0)
                    current = root.left;
                else
                    current = root.right;

                while (current != null && !found) {
                    if (element.equals(current.element)) {
                        result = current.element;
                        found = true;
                        count--;
                        if (parent.left == current)
                            parent.left = replacement(current);
                        else if (parent.right == current)
                            parent.right = replacement(current);
                    } else {
                        parent = current;
                        if (element.compareTo(current.element) < 0)
                            current = current.left;
                        else
                            current = current.right;
                    }
                }
                if (!found)
                    throw new ElementNotFoundException("Linked Binary Search Tree");
            }
        }

        return result;
    }

    public BinaryTreeNode<T> replacement(BinaryTreeNode<T> node) {
        BinaryTreeNode<T> result = null;
        if (node.left == null && node.right == null)
            result = null;
        else if (node.left != null && node.right == null)
            result = node.left;
        else if (node.left == null && node.right != null)
            result = node.right;
        else {
            BinaryTreeNode<T> current = node.right;
            BinaryTreeNode<T> parent = node;

            while (current.left != null) {
                current = current.left;
                parent = current;
            }

            if (node.right == current)
                current.left = node.left;
            else {
                parent.left = current.right;
                current.left = node.left;
                current.right = node.right;
            }

            result = current;
        }

        return result;
    }

    @Override
    public void removeAllOccurences(T element) throws ElementNotFoundException {
        removeElement(element);
        Comparable<T> comparableElement = (Comparable<T>) element;
        Iterator<T> iterator = iteratorInOrder();
        int n = 0;
        while (iterator.hasNext()) {
            if (comparableElement.compareTo(iterator.next()) == 0) {
                removeElement(element);
                n++;
            }
        }
        for (int i = 0; i < n; i++) {
            removeElement(element);
        }
    }

    @Override
    public T removeMin() throws EmptyCollectionException {
        T result = null;
        if (isEmpty())
            throw new EmptyCollectionException("LinkedBinarySearchTree");
        else {
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
            count--;
        }
        return result;
    }

    @Override
    public T removeMax() {
        T result = null;
        if (isEmpty())
            throw new EmptyCollectionException("LinkedBinarySearchTree");
        else {
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
            count--;
        }
        return result;
    }

    @Override
    public T findMin() {
        if (isEmpty())
            throw new EmptyCollectionException("LinkedBinarySearchTree");
        else {
            BinaryTreeNode<T> current = root;
            while (current.left != null) {
                current = current.left;
            }
            return current.element;
        }
    }

    @Override
    public T findMax() {
        if (isEmpty())
            throw new EmptyCollectionException("LinkedBinarySearchTree");
        else {
            BinaryTreeNode<T> current = root;
            while (current.right != null) {
                current = current.right;
            }
            return current.element;
        }
    }
}
