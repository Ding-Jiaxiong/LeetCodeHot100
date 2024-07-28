package LeetCodeHot100.coin_change85;

import java.util.Arrays;

/**
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * <p>
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * <p>
 * 思路：
 *
 * @author Ding Jiaxiong
 */

public class Main {

    public static int coinChange(int[] coins, int amount) {

        int max = amount + 1;

        int[] dp = new int[amount + 1];

        Arrays.fill(dp, max);

        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {

            for (int j = 0; j < coins.length; j++) {

                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];

    }

    public static void main(String[] args) {

        int[] coins = {1, 2, 5};
        int amount = 11;

        System.out.println(coinChange(coins, amount));
    }
}
