package caijing.leetcode.tree;

/**
 * Created by Caij on 2016/2/29.
 */
public class BinaryTree {

    private static TreeNode<Integer> root;

    static {
        root = new TreeNode<Integer>(10);
        TreeNode<Integer> node1 = new TreeNode<Integer>(8);
        TreeNode<Integer> node2 = new TreeNode<Integer>(7);
        root.setLeft(node1);
        root.setRight(node2);

        TreeNode<Integer> node3 = new TreeNode<Integer>(3);
        TreeNode<Integer> node4 = new TreeNode<Integer>(5);
        node1.setLeft(node3);
        node1.setRight(node4);

        TreeNode<Integer> node5 = new TreeNode<Integer>(6);
        TreeNode<Integer> node6 = new TreeNode<Integer>(7);
        node3.setRight(node5);
        node4.setLeft(node6);

        TreeNode<Integer> node7 = new TreeNode<Integer>(4);
        node2.setRight(node7);

        TreeNode<Integer> node8 = new TreeNode<Integer>(8);
        TreeNode<Integer> node9 = new TreeNode<Integer>(9);
        node7.setLeft(node8);
        node7.setRight(node9);
    }

    public static TreeNode<Integer> createBinaryTree() {
        return root;
    }
}
