package LeetCodeHot100.maximum_product_subarray88;

/**
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续 子数组 （该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * <p>
 * 思路：动态规划
 *
 * @author Ding Jiaxiong
 */

public class Main {

    public static int maxProduct(int[] nums) {

        int len = nums.length;

        if (len == 0) return 0;

        int[][] dp = new int[len][2];

        dp[0][0] = nums[0];
        dp[0][1] = nums[0];

        for (int i = 1; i < len; i++) {

            if (nums[i] >= 0) {
                dp[i][1] = Math.max(nums[i], dp[i - 1][1] * nums[i]);
                dp[i][0] = Math.min(nums[i], dp[i - 1][0] * nums[i]);
            } else {

                dp[i][1] = Math.max(nums[i], dp[i - 1][0] * nums[i]);
                dp[i][0] = Math.min(nums[i], dp[i - 1][1] * nums[i]);
            }

        }


        int res = dp[0][1];

        for (int i = 1; i < len; i++) {
            res = Math.max(res, dp[i][1]);
        }

        return res;
    }

    public static void main(String[] args) {

        int[] nums = {2, 3, -2, 4};

        System.out.println(maxProduct(nums));

    }
}
