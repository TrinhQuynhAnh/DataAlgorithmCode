public class PostFixEvalDemo {
    public static void main(String []args) {
        PostFixEvaluator evaluator = new PostFixEvaluator();
        System.out.println("Result: " + evaluator.evaluate("5 2 + 8 3 - * 4 /"));
    }
}
