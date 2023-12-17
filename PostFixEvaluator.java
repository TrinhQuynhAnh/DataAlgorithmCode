import java.util.*;
public class PostFixEvaluator {
    private static final char ADD = '+';
    private static final char SUB = '-';
    private static final char MUL = '*';
    private static final char DIV = '/';
    private Stack<Integer> stack;
    public PostFixEvaluator() {
        stack = new Stack<Integer>();
    }
    public int evaluate(String exp) {
        int op1, op2, result = 0;
        Scanner sc = new Scanner(exp);
        while(sc.hasNext()) {
            String token = sc.next();
            if(isOperator(token)) {
                op2 = stack.pop().intValue();
                op1 = stack.pop().intValue();
                result = evalSingleOp(token.charAt(0), op1, op2);
                stack.push(result);
            } else {
                stack.push(Integer.valueOf(Integer.parseInt(token)));
            }
        }
        sc.close();
        return result;
    }
    private boolean isOperator(String token) {
        return(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/"));
    }
    private int evalSingleOp(char operation, int op1, int op2) {
        int result = 0;
        switch(operation) {
            case ADD:
                result = op1 + op2;
                break;
            case SUB:
                result = op1 - op2;
                break;
            case MUL:
                result = op1 * op2;
                break;
            case DIV:
                result = op1 / op2;
                break;
        }
        return result;
    }

}
