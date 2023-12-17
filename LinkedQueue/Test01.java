public class Test01 {
    public static void main(String[] args) {
        LinkedQueue<String> queue = new LinkedQueue<String>();
        queue.enqueue("A");
        queue.enqueue("B"); 
        queue.enqueue("C");
        System.out.println(queue.dequeue());
        
    }
}
