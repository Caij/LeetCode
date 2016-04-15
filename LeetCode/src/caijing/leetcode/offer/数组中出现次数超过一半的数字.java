package caijing.leetcode.offer;

/**
 * Created by Caij on 2016/4/5.
 */
public class 数组中出现次数超过一半的数字 {

    static int MoreThanHalfNum_Solution(int []  numbers) {
        int n = numbers.length;
        if (n == 0) return 0;

        int num = numbers[0];
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (numbers[i] == num) count++;
            else count--;
            if (count == 0) {
                num = numbers[i];
                count = 1;
            }
        }
        // Verifying
        count = 0;
        for (int i = 0; i < n; i++) {
            if (numbers[i] == num) count++;
        }
        if (count * 2 > n) return num;
        return 0;
    }

    public static void main(String[] args) {
        int[] datas = new int[]{1, 2, 3, 2, 4, 2};
        System.out.println(MoreThanHalfNum_Solution(datas));
    }
}
