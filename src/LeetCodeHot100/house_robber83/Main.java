package LeetCodeHot100.house_robber83;

/**
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * <p>
 * 思路：动态规划
 *
 * @author Ding Jiaxiong
 */

public class Main {

    public static int rob(int[] nums) {

        if (nums == null || nums.length == 0) return 0;

        int len = nums.length;

        if (len == 1) return nums[0];

        int[] dp = new int[len];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < len; i++) {

            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        return dp[len - 1];
    }

    public static void main(String[] args) {

        int[] prices = {1, 2, 3, 1};

        System.out.println(rob(prices));

    }
}
