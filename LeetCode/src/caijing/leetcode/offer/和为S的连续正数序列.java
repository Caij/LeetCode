package caijing.leetcode.offer;

import java.util.ArrayList;

/**
 * Created by Caij on 2016/3/30.
 */
public class 和为S的连续正数序列 {

//    输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if (sum < 3) return results;
        int left = 1;
        int right = 2;
        int curSum = left + right;
        while (left < (sum + 1) / 2 && right < sum) {
            while (curSum > sum) {
                curSum -= left;
                left ++;
            }

            if (curSum == sum) {
                ArrayList<Integer> result  = createRightList(left, right);
                results.add(result);
            }

            right ++;
            curSum += right;
        }

        return results;
    }

    private  ArrayList<Integer> createRightList(int left, int right) {
        ArrayList<Integer> results = new ArrayList<Integer>();
        for (int i = left; i <= right; i ++) {
            results.add(i);
        }
        return results;
    }

    public static void main(String[] args) {
    }
}
