package LeetCodeHot100.partition_equal_subset_sum89;

/**
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 思路：动态规划
 *
 * @author Ding Jiaxiong
 */

public class Main {

    public static boolean canPartition(int[] nums) {

        int len = nums.length;

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 == 1) return false;

        int target = sum / 2;

        boolean[][] dp = new boolean[len + 1][target + 1];

        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }

        for (int i = 1; i < len; i++) {

            for (int j = 0; j <= target; j++) {

                dp[i][j] = dp[i - 1][j];

                if (nums[i] == j) {
                    dp[i][j] = true;
                    continue;
                }

                if (nums[i] < j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }

        return dp[len - 1][target];

    }

    public static void main(String[] args) {

        int[] nums = {1, 5, 11, 5};

        System.out.println(canPartition(nums));

    }
}
