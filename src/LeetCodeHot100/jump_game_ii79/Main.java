package LeetCodeHot100.jump_game_ii79;

/**
 * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
 * <p>
 * 返回到达 nums[n - 1] 的最小跳跃次数。
 * <p>
 * 思路：贪心
 *
 * @author Ding Jiaxiong
 */

public class Main {

    public static int jump(int[] nums) {

        int position = nums.length - 1;
        int steps = 0;

        while (position > 0) {

            for (int i = 0; i < position; i++) {

                if (i + nums[i] >= position) {
                    position = i;
                    steps++;
                    break;
                }
            }
        }

        return steps;
    }

    public static void main(String[] args) {

        int[] nums = {2, 3, 1, 1, 4};

        System.out.println(jump(nums));

    }
}
