import java.util.Scanner;
import java.util.Stack;

public class Ex3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        decimalToBinary(n);
    }

    static void decimalToBinary(int num) {
        Stack<Integer> st = new Stack<>();
        while (num > 0) {
            st.push(num % 2);
            num /= 2;
        }
        while (!(st.isEmpty())) {
            System.out.print(st.peek());
            st.pop();
        }
    }
}
