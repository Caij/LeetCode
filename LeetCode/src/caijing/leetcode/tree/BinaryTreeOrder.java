package caijing.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Caij on 2016/2/26.
 */
public class BinaryTreeOrder {

    public static List<Integer> binaryTree前序遍历递归(TreeNode<Integer> treeNode) {
        List<Integer> results = new ArrayList<Integer>();
        if (treeNode != null) {
            results.add(treeNode.getData());
            results.addAll(binaryTree前序遍历递归(treeNode.getLeft()));
            results.addAll(binaryTree前序遍历递归(treeNode.getRight()));
            return results;
        }
        return results;
    }

    public static List<Integer> binaryTree中序遍历递归(TreeNode<Integer> treeNode) {
        List<Integer> results = new ArrayList<Integer>();
        if (treeNode != null) {
            results.addAll(binaryTree中序遍历递归(treeNode.getLeft()));
            results.add(treeNode.getData());
            results.addAll(binaryTree中序遍历递归(treeNode.getRight()));
            return results;
        }
        return results;
    }

    public static List<Integer> binaryTree后序遍历递归(TreeNode<Integer> treeNode) {
        List<Integer> results = new ArrayList<Integer>();
        if (treeNode != null) {
            results.addAll(binaryTree后序遍历递归(treeNode.getLeft()));
            results.addAll(binaryTree后序遍历递归(treeNode.getRight()));
            results.add(treeNode.getData());
            return results;
        }
        return results;
    }

    public static List<Integer> binaryTree前序遍历非递归(TreeNode<Integer> treeNode) {
        List<Integer> results = new ArrayList<Integer>();
        Stack<TreeNode<Integer>> cache = new Stack<TreeNode<Integer>>();
        cache.push(treeNode);
        while (!cache.isEmpty()) {
            TreeNode<Integer> node = cache.pop();
            results.add(node.getData());

            if (node.hasRight()) {
                cache.push(node.getRight());
            }

            if (node.hasLeft()) {
                cache.push(node.getLeft());
            }
        }
        return results;
    }

    public static List<Integer> binaryTree中序遍历非递归(TreeNode<Integer> treeNode) {
        List<Integer> results = new ArrayList<Integer>();
        Stack<TreeNode<Integer>> cache = new Stack<TreeNode<Integer>>();
        TreeNode<Integer> current = treeNode;
        while (!cache.isEmpty() || current != null) {
            if (current != null) {
                cache.push(current);
                current = current.getLeft();
            }else {
                TreeNode<Integer> node = cache.pop();
                results.add(node.getData());
                current = node.getRight();
            }
        }
        return results;
    }

    public static List<Integer> binaryTree后序遍历非递归(TreeNode<Integer> treeNode) {
        List<Integer> results = new ArrayList<Integer>();
        Stack<TreeNode<Integer>> cache = new Stack<TreeNode<Integer>>();
        cache.push(treeNode);
        TreeNode<Integer> pre = null;
        TreeNode<Integer> current = null;
        while (!cache.isEmpty()) {
            current = cache.peek();
            if (pre == null || pre.getLeft() == current || pre.getRight() == current) {
                if (current.hasLeft()) {
                    cache.push(current.getLeft());
                } else if (current.hasRight()) {
                    cache.push(current.getRight());
                } else {
                    cache.pop();
                    results.add(current.getData());
                }
            }else if (pre == current.getLeft()) {
                if (current.hasRight()) {
                    cache.push(current.getRight());
                }else {
                    cache.pop();
                    results.add(current.getData());
                }
            }else if (pre == current.getRight()) {
                cache.pop();
                results.add(current.getData());
            }
            pre = current;
        }


        return results;
    }

    public static void main(String[] args) {
//        List<Integer> results = binaryTree前序遍历递归(BinaryTree.createBinaryTree());
//        List<Integer> results = binaryTree前序遍历非递归(BinaryTree.createBinaryTree());
//        List<Integer> results = binaryTree中序遍历非递归(BinaryTree.createBinaryTree());
//        List<Integer> results = binaryTree后序遍历递归(BinaryTree.createBinaryTree());
        List<Integer> results = binaryTree后序遍历非递归(BinaryTree.createBinaryTree());
        for (Integer i : results){
            System.out.print(i + ",");
        }
    }
}
