package LeetCodeHot100.maximum_subarray13;


/**
 * 题目描述: 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 子数组 是数组中的一个连续部分。
 * <p>
 * 思路: 动态规划[ 原数组作为 dp 表 ]
 *
 * @author Ding Jiaxiong
 */

public class Main {


    public static int maxSubArray(int[] nums) {

        int res = nums[0];  // 最开始情况，最大子数组和就是第一个元素

        for (int i = 1; i < nums.length; i++) {

            nums[i] += Math.max(nums[i - 1], 0); // 如果前一个数是正数，就加上，如果不是，加上0相当于忽略

            res = Math.max(res, nums[i]); // 更新结果
        }

        return res;
    }

    public static void main(String[] args) {

        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        System.out.println(maxSubArray(nums));
    }

}
