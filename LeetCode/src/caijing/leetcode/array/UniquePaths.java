package caijing.leetcode.array;

/**
 * Created by Caij on 2016/3/23.
 */
public class UniquePaths {

//    uniquePaths(m-1,n)+uniquePaths(m,n-1)
//    public static int uniquePaths(int m, int n) {
//        if (m == 0 || n == 0) return 1;
//        else return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
//    }

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                dp[i][j] = i == 0 || j == 0 ? 1 : dp[i - 1][j] + dp[i][j - 1];

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(2, 2));
    }

}
