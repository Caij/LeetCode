package caijing.leetcode.offer;

/**
 * Created by Caij on 2016/3/2.
 */
public class Fibonacci {

//    大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。

    public int fibonacci递归(int n) {
        if (n < 2) {
            return n;
        }

        if (n == 2) {
            return 1;
        }

        return fibonacci递归(n - 1) + fibonacci递归(n - 2);
    }

    public int fibonacci非递归(int n) {
        int a = 1; //n-1
        int b = 1; //n-2
        int c = 0;
        if (n < 2) {
            return n;
        }

        if (n == 2) {
            return 1;
        }
//        n1= 1 n2 = 1
        for (int i = 3; i <= n; i ++) {
            c = a + b;
            b = a;
            a = c;
        }

        return c;
    }


}
