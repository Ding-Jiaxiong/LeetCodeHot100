package LeetCodeHot100.climbing_stairs81;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 思路：动态规划
 *
 * @author Ding Jiaxiong
 */

public class Main {

    public static int climbStairs(int n) {

        if (n == 1 || n == 2) return n;

        // dp 表
        int[] dp = new int[n + 1];

        // 初始状态
        dp[1] = 1;
        dp[2] = 2;

        // 状态转移
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static void main(String[] args) {

        int n = 3;
        System.out.println(climbStairs(n));
    }

}
