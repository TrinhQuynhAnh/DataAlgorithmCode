import java.util.Scanner;
public class Ex1 {
    public static void main(String[] args) {
        LinkedStack<String> stack = new LinkedStack<String>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i) + "");
        }
        System.out.print("The reverse string is: ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}
