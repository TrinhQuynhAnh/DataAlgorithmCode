package Trees;

public interface BinarySearchTreeADT<T> extends BinaryTreeADT<T> {
    public void addElement(T element) throws NonComparableElementException;
    public T removeElement(T targetElement) throws ElementNotFoundException;
    public void removeAllOccurrences(T targetElement) throws ElementNotFoundException;
    public T removeMin() throws EmptyCollectionException;
    public T removeMax() throws EmptyCollectionException;
    public T findMin();
    public T findMax();
}
