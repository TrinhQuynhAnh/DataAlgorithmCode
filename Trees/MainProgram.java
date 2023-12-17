package Trees;

import java.util.Iterator;

public class MainProgram {
    public static void main(String[] args) throws EmptyCollectionException {
        LinkedBinaryTree<String> nodeE =  new LinkedBinaryTree<>("E", null, null);
        LinkedBinaryTree<String> nodeD =  new LinkedBinaryTree<>("D", null, null);
        LinkedBinaryTree<String> nodeB =  new LinkedBinaryTree<>("B",nodeD, nodeE);
        LinkedBinaryTree<String> nodeC =  new LinkedBinaryTree<>("C", null, null);
        LinkedBinaryTree<String> tree =  new LinkedBinaryTree<>("A", nodeB, nodeC);
        Iterator<String> it = tree.iteratorInOrder();
        while (it.hasNext()) {
            String next = it.next();
            System.out.println(next);
        }
        System.out.println(tree.getRootNode().getLeft().numChildren());

    }
}
