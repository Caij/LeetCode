package caijing.leetcode.offer;

/**
 * Created by Caij on 2016/3/3.
 */
public class 树的子结构 {

//    输入两颗二叉树A，B，判断B是不是A的子结构。

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }


    public boolean hasSubtree递归(TreeNode root1, TreeNode root2) {
        if(root2==null) return true;
        if(root1==null) return false;
        return isSub(root1, root2) || hasSubtree递归(root1.left, root2) || hasSubtree递归(root1.right, root2);
    }

    private boolean isSub(TreeNode root1, TreeNode root2) {
        if(root2==null) return true;
        if(root1==null) return false;
        if (root1.val == root2.val) {
            return isSub(root1.left, root2.left) && isSub(root1.right, root1.right);
        }else {
            return false;
        }
    }
}
