package caijing.leetcode.offer;

import java.util.Stack;

/**
 * Created by Caij on 2016/3/3.
 */
public class 栈的压入弹出序列 {
//    输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
//    假设压入栈的所有数字均不相等。
//    例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。

    public boolean isPopOrder(int [] pushA,int [] popA) {
        if (pushA.length == 0 || popA.length == 0) {
            return false;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int j = 0;
        for (int i = 0; i < pushA.length; i ++){
            stack.push(pushA[i]);
            while (j < popA.length && stack.peek() == popA[j]) {
                stack.pop();
                j ++;
            }
        }
        return stack.isEmpty();
    }
}
