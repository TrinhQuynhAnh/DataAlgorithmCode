package Trees;
import java.util.*;
import java.io.*;
public class DecisionTree {
    private LinkedBinaryTree<String> tree;
    public DecisionTree(String filename) throws FileNotFoundException {
        File inputFile = new File(filename);
        Scanner sc = new Scanner(inputFile);
        int numNodes = sc.nextInt();
        sc.nextLine();
        int root = 0, left, right;
        List<LinkedBinaryTree<String>> nodes = new ArrayList<LinkedBinaryTree<String>>();
        for (int i = 0; i < numNodes; i++) {
            nodes.add(i, new LinkedBinaryTree<String>(sc.nextLine()));
        }
        while (sc.hasNext()) {
            root = sc.nextInt();
            left = sc.nextInt();
            right = sc.nextInt();
            sc.nextLine();
            nodes.set(root, new LinkedBinaryTree<String>((nodes.get(root)).getRootElement(), nodes.get(left), nodes.get(right)));
        }
        tree = nodes.get(root);
    }
    public void evaluate() {
        LinkedBinaryTree<String> current = tree;
        Scanner scan = new Scanner(System.in);
        while (current.size() > 1) {
            System.out.println(current.getRootElement());
            if (scan.nextLine().equalsIgnoreCase("N")) {
                current = current.getLeft(null);
            } else {
                current = current.getLeft(null);
            }
        }
        System.out.println(current.getRootElement());
    }
}
