package caijing.leetcode.offer;

import java.util.ArrayList;

/**
 * Created by Caij on 2016/3/30.
 */
public class 最小的K个数 {

//    输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        if (k > input.length) return al;
        for (int i = input.length/2 - 1; i >= 0; i--) {
            createMinHeap(input, i, input.length - 1);
        }

        int temp;
        for(int j = input.length - 1; j >= input.length - k; j --) {
            temp = input[0];
            al.add(temp);
            input[0] = input[j];
            input[j] = temp;

            createMinHeap(input, 0, j - 1);
        }

        return al;
    }

    private void createMinHeap(int[] input, int index, int end) {
        int temp = input[index];
        int j = index * 2;
        while (j < end) {
            if (j < end && input[j + 1] < input[j]) {
                j ++;
            }

            if (input[j] < temp) {
                input[index] = input[j];
                index = j;
                j = index * 2;
            }else {
                j = end;
            }

            input[index] = temp;
        }
    }

    public ArrayList<Integer> GetLeastNumbers_Solution2(int [] input, int k) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        if (k > input.length) {
            return al;
        }
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < input.length - i - 1; j++) {
                if (input[j] < input[j + 1]) {
                    int temp = input[j];
                    input[j] = input[j + 1];
                    input[j + 1] = temp;
                }
            }
            al.add(input[input.length - i - 1]);
        }
        return al;
    }
}
