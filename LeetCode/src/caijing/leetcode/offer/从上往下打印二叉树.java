package caijing.leetcode.offer;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by Caij on 2016/3/4.
 */
public class 从上往下打印二叉树 {

//    从上往下打印出二叉树的每个节点，同层节点从左至右打印。

     public class TreeNode {
     int val = 0;
     TreeNode left = null;
     TreeNode right = null;

     public TreeNode(int val) {
     this.val = val;

     }

     }

    public ArrayList<Integer> printFromTopToBottom(TreeNode root) {
        ArrayList<Integer> results = new ArrayList<Integer>();
        if(root == null) return results;
        ArrayList<TreeNode> temp = new ArrayList<TreeNode>();
        temp.add(root);
        while (temp.size() > 0) {
            TreeNode node = temp.remove(0);
            if (node != null) {
                results.add(node.val);
                if (node.left != null) {
                    temp.add(node.left);
                }

                if (node.right != null) {
                    temp.add(node.right);
                }
            }
        }
        return results;
    }
}
