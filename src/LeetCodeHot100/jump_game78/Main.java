package LeetCodeHot100.jump_game78;

/**
 * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断能够到达最后一个下标
 * <p>
 * 思路：贪心
 *
 * @author Ding Jiaxiong
 */

public class Main {

    public static boolean canJump(int[] nums) {

        int n = nums.length;

        int rightmost = 0;

        for (int i = 0; i < n; i++) {

            if (i <= rightmost) {

                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }

            }

        }

        return false;
    }

    public static void main(String[] args) {

        int[] nums = {2, 3, 1, 1, 4};

        System.out.println(canJump(nums));

    }
}
