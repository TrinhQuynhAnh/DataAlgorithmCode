public class ArrayQueue<T> implements QueueADT<T> {
    private final static int DEFAULT_CAPACITY = 100;
    private int front, rear, count;
    private T[] queue;
    public ArrayQueue(int initialCapacity) {
        front = rear = count = 0;
        queue = (T[]) (new Object[initialCapacity]);
    }
    public ArrayQueue() {
        this(DEFAULT_CAPACITY);
    }
    public void enqueue(T element) {
        if (size() == queue.length) {
            expandCapacity();
        }
        queue[rear] = element;
        rear = (rear + 1) % queue.length;   
    }
    private void expandCapacity() {
        T[] larger = (T[]) (new Object[queue.length * 2]);
        for (int scan = 0; scan < count; scan++) {
            larger[scan] = queue[front];
            front = (front + 1) % queue.length;
        }
        front = 0;
        rear = count;
        queue = larger;
    }
    public T dequeue() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("queue");
        }
        T result = queue[front];
        queue[front] = null;
        front = (front + 1) % queue.length;
        count--;
        return result;
    }
    public boolean isEmpty() {
        return (count == 0);
    }
    public int size() {
        return count;
    }
    public T first() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("queue");
        }
        return queue[front];
    }
}
