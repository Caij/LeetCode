package caijing.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Caij on 2016/2/26.
 */
public class BinaryTreeOrder {

    public static List<Integer> binaryTree前序遍历递归(BinaryNode<Integer> binaryNode) {
        List<Integer> results = new ArrayList<Integer>();
        if (binaryNode != null) {
            results.add(binaryNode.getData());
            results.addAll(binaryTree前序遍历递归(binaryNode.getLeft()));
            results.addAll(binaryTree前序遍历递归(binaryNode.getRight()));
            return results;
        }
        return results;
    }

    public static List<Integer> binaryTree中序遍历递归(BinaryNode<Integer> binaryNode) {
        List<Integer> results = new ArrayList<Integer>();
        if (binaryNode != null) {
            results.addAll(binaryTree中序遍历递归(binaryNode.getLeft()));
            results.add(binaryNode.getData());
            results.addAll(binaryTree中序遍历递归(binaryNode.getRight()));
            return results;
        }
        return results;
    }

    public static List<Integer> binaryTree后序遍历递归(BinaryNode<Integer> binaryNode) {
        List<Integer> results = new ArrayList<Integer>();
        if (binaryNode != null) {
            results.addAll(binaryTree后序遍历递归(binaryNode.getLeft()));
            results.addAll(binaryTree后序遍历递归(binaryNode.getRight()));
            results.add(binaryNode.getData());
            return results;
        }
        return results;
    }

    public static List<Integer> binaryTree前序遍历非递归(BinaryNode<Integer> binaryNode) {
        List<Integer> results = new ArrayList<Integer>();
        Stack<BinaryNode<Integer>> cache = new Stack<BinaryNode<Integer>>();
        cache.push(binaryNode);
        while (!cache.isEmpty()) {
            BinaryNode<Integer> node = cache.pop();
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

    public static List<Integer> binaryTree中序遍历非递归(BinaryNode<Integer> binaryNode) {
        List<Integer> results = new ArrayList<Integer>();
        Stack<BinaryNode<Integer>> cache = new Stack<BinaryNode<Integer>>();
        BinaryNode<Integer> current = binaryNode;
        while (!cache.isEmpty() || current != null) {
            if (current != null) {
                cache.push(current);
                current = current.getLeft();
            }else {
                BinaryNode<Integer> node = cache.pop();
                results.add(node.getData());
                current = node.getRight();
            }
        }
        return results;
    }

    public static List<Integer> binaryTree后序遍历非递归(BinaryNode<Integer> binaryNode) {
        List<Integer> results = new ArrayList<Integer>();
        Stack<BinaryNode<Integer>> cache = new Stack<BinaryNode<Integer>>();
        cache.push(binaryNode);
        BinaryNode<Integer> pre = null;
        BinaryNode<Integer> current = null;
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
