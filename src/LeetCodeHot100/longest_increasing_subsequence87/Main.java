package LeetCodeHot100.longest_increasing_subsequence87;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * <p>
 * 思路：动态规划
 *
 * @author Ding Jiaxiong
 */

public class Main {

    public static int lengthOfLIS(int[] nums) {

        if (nums.length == 0) return 0;

        int[] dp = new int[nums.length];

        int res = 0;

        Arrays.fill(dp, 1);

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {

                if (nums[j] < nums[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }

            res = Math.max(res, dp[i]);
        }


        return res;

    }

    public static void main(String[] args) {

        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};

        System.out.println(lengthOfLIS(nums));
    }
}
