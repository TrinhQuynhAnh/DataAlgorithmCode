import java.util.*;
public class Ex2 {
    public static void main(String[] args) {
        LinkedStack<Character> stack1 = new LinkedStack<Character>();
        LinkedStack<Character> stack2 = new LinkedStack<Character>();
        String input = "abccba";
        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            stack1.push(chars[i]);
        }
        for (int i = chars.length - 1; i >= chars.length / 2; i--) {
            stack2.push(chars[i]);
        }
        if (sameStack(stack1, stack2)) {
            System.out.println("The string is balanced.");
        } else {
            System.out.println("The string is not balanced.");
        }
    }
    static boolean sameStack(LinkedStack<Character> stack1, LinkedStack<Character> stack2) {
        boolean flag = true;
        if (stack1.size() != stack2.size()) {
            flag = false;
            return flag;
        }
        while (!stack1.isEmpty()) {
            if (stack1.peek() != stack2.peek()) {
                flag = false;
                break;
            } else {
                stack1.pop();
                stack2.pop();
            }
        }
        return flag;
    }
}
