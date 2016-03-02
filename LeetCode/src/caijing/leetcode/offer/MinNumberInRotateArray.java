package caijing.leetcode.offer;

/**
 * Created by Caij on 2016/3/2.
 */
public class MinNumberInRotateArray {

//    把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
//    输入一个非递减序列的一个旋转，输出旋转数组的最小元素。
//    例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。

    public int minNumberInRotateArray(int [] array) {
        int i = 0;
        if(array.length==0){
            return 0;
        }
        if(array.length==1){
            return array[0];
        }
        while (i < array.length) {
            if (array[i] < array[i - 1 < 0 ? array.length - 1 : i - 1]) {
                return array[i];
            }
            i ++;
        }
        return -1;
    }
}
