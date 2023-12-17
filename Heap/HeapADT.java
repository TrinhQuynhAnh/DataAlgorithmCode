package Heap;

import Trees.BinaryTreeADT;

public interface HeapADT<T> extends BinaryTreeADT<T> {
    public void addElement(T obj);
    public T removeMin();
    public T findMin();
}
