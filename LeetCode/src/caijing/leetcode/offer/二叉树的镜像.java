package caijing.leetcode.offer;

/**
 * Created by Caij on 2016/3/3.
 */
public class 二叉树的镜像 {

//    二叉树的镜像定义：源二叉树
//              8
//            /  \
//            6   10
//            / \  / \
//            5  7 9 11
//    镜像二叉树
//              8
//            /  \
//            10   6
//            / \  / \
//            11 9 7  5

     public class TreeNode {
     int val = 0;
     TreeNode left = null;
     TreeNode right = null;

     public TreeNode(int val) {
     this.val = val;

     }

     }

    public void mirror(TreeNode root) {
        if(root == null) return;
        swap(root);
        mirror(root.left);
        mirror(root.right);
    }

    private void swap(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
