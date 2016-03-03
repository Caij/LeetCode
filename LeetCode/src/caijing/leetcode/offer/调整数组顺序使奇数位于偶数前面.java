package caijing.leetcode.offer;

/**
 * Created by Caij on 2016/3/3.
 */
public class 调整数组顺序使奇数位于偶数前面 {

//    输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
// 所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。

    public void reOrderArray(int [] array) {
        for (int i = 1; i < array.length; i ++){
            int temp = array[i];
            int j = i - 1;
            while (j >= 0 && temp % 2 != 0 && array[j] % 2 == 0) {
                array[j + 1] = array[j];
                j --;
            }
            array[j + 1] = temp;
        }
    }
}
