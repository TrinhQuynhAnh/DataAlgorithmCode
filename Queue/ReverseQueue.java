package Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ReverseQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.add(sc.nextInt());
        }
        int k = sc.nextInt();
        for (int i = 0; i < k; i++) {
            queue.add(queue.poll());
        }
        for (Integer i : queue) {
            System.out.printf(i + " ");
        }
    }
}
