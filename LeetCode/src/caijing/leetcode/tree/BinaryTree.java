package caijing.leetcode.tree;

/**
 * Created by Caij on 2016/2/29.
 */
public class BinaryTree {

    private static BinaryNode<Integer> root;

    static {
        root = new BinaryNode<Integer>(10);
        BinaryNode<Integer> node1 = new BinaryNode<Integer>(8);
        BinaryNode<Integer> node2 = new BinaryNode<Integer>(7);
        root.setLeft(node1);
        root.setRight(node2);

        BinaryNode<Integer> node3 = new BinaryNode<Integer>(3);
        BinaryNode<Integer> node4 = new BinaryNode<Integer>(5);
        node1.setLeft(node3);
        node1.setRight(node4);

        BinaryNode<Integer> node5 = new BinaryNode<Integer>(6);
        BinaryNode<Integer> node6 = new BinaryNode<Integer>(7);
        node3.setRight(node5);
        node4.setLeft(node6);

        BinaryNode<Integer> node7 = new BinaryNode<Integer>(4);
        node2.setRight(node7);

        BinaryNode<Integer> node8 = new BinaryNode<Integer>(8);
        BinaryNode<Integer> node9 = new BinaryNode<Integer>(9);
        node7.setLeft(node8);
        node7.setRight(node9);
    }

    public static BinaryNode<Integer> createBinaryTree() {
        return root;
    }
}
