package LeetCodeHot100.rotate_array15;

/**
 * 题目描述: 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 * <p>
 * 思路: 翻转再翻转，神人
 *
 * @author Ding Jiaxiong
 */


public class Main {

    // 翻转数组
    public static void reverse(int[] nums, int start, int end) {

        while (start < end) {
            int temp = nums[start];

            nums[start] = nums[end];

            nums[end] = temp;

            start++;
            end--;
        }

    }

    public static void rotate(int[] nums, int k) {

        k = k % nums.length;  // 取余操作是一个倍数就不变了
        reverse(nums, 0, nums.length - 1); // 翻转整个数组
        // 从第 k 个元素后，将数组划分为左右两块子数组
        reverse(nums, 0, k - 1); // 左边翻转
        reverse(nums, k, nums.length - 1); // 右边翻转

    }


    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        rotate(nums, k);

        for (int num : nums) {

            System.out.print(num + " ");
        }

    }

}
