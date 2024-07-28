package LeetCodeHot100.first_missing_positive17;

/**
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。 没1的话一定是1
 * <p>
 * 思路: 原地哈希
 *
 * @author Ding Jiaxiong
 */

public class Main {

    public static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static int firstMissingPositive(int[] nums) {

        int len = nums.length;

        for (int i = 0; i < len; i++) {

            // 指定范围, 数字没有放在正确的位置，就交换
            while (nums[i] > 0 && nums[i] < len && nums[nums[i] - 1] != nums[i]) {
                swap(nums, nums[i] - 1, i);
            }

        }

        // 检查数组
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return len + 1; // 都正确

    }

    public static void main(String[] args) {

        int[] nums = new int[]{1, 2, 0};
        System.out.println(firstMissingPositive(nums));

    }

}
