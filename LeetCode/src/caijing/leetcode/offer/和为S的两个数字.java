package caijing.leetcode.offer;

import java.util.ArrayList;

/**
 * Created by Caij on 2016/3/30.
 */
public class 和为S的两个数字 {

    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> integers = new ArrayList<Integer>();
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            if (array[left] + array[right] == sum) {
                integers.add(array[left]);
                integers.add(array[right]);
                break;
            }

            while (left < right && array[left] + array[right] > sum) right--;
            while (left < right && array[left] + array[right] < sum) left++;
        }
        return integers;
    }

}
