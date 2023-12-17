import java.util.Scanner;
import java.util.Stack;
public class characterCountInStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        str = str + "@";
        Stack<Character> st = new Stack<>();
        int index = 0, count = 0;
        while (index < str.length()) {
            if (st.isEmpty()) {
                st.push(str.charAt(index++));
                count = 1;
            } else if(st.peek() != str.charAt(index)) {
                System.out.printf(st.pop() + "" + count);
            } else {
                count++;
                index++;
            }
        }
        sc.close();
    }
}
