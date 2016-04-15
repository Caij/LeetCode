package caijing.leetcode.offer;

/**
 * Created by Caij on 2016/4/11.
 */
public class 连续子数组的最大和 {

    public int FindGreatestSumOfSubArray(int[] array) {
        if (array==null || array.length==0) {
            return 0;
        }
        int curSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i ++) {
            if (curSum <= 0) {
                curSum = array[i];
            }else {
                curSum += array[i];
            }

            if (curSum > maxSum) {
                maxSum = curSum;
            }
        }
        return maxSum;
    }

}
