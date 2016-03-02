package caijing.leetcode.offer;


import caijing.leetcode.tree.TreeNode;

/**
 * Created by Caij on 2016/3/2.
 */
public class ReConstructBinaryTree {

//    输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
//    假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
//    例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。

    public TreeNode<Integer> reConstructBinaryTree递归(int [] pre, int [] in) {
        TreeNode<Integer> root = createBinaryTreeNext(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }

    private TreeNode<Integer> createBinaryTreeNext(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
        if(preStart > preEnd || inStart > inEnd)
            return null;
        TreeNode<Integer> root = new TreeNode<Integer>(pre[preStart]);
        for (int i = inStart; i <= inEnd; i++) {
            if (in[i] == pre[preStart]) {
                root.left = createBinaryTreeNext(pre, preStart + 1, preStart + i - inStart, in, inStart, i - 1);
                root.right = createBinaryTreeNext(pre, preStart + i - inStart + 1, preEnd, in, i + 1, inEnd);
            }
        }
        return root;
    }


    public TreeNode reConstructBinaryTree非递归(int [] pre, int [] in) {
        return null;
    }
}
