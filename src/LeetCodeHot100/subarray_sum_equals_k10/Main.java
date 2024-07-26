package LeetCodeHot100.subarray_sum_equals_k10;


import java.util.HashMap;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 * <p>
 * 思路: 前缀和 + 哈希 ( 我还没写呢，AI 已经提示完了 ) 【枚举看看会不会超时, LeetCode倒是没有超时，但是已经 1s 多了, 使用前缀和 23ms】
 *
 * 前缀和: 前缀和是指数组从开始位置到当前位置的元素之和。例如，数组 [1, 2, 3] 的前缀和分别为 [1, 3, 6]。
 *
 *
 * @author Ding Jiaxiong
 */

public class Main {

//    public static int subarraySum枚举(int[] nums, int k) {
//
//        int count = 0;
//
//        for (int start = 0; start < nums.length; start++) {
//
//            int sum = 0;
//
//            for (int end = start; end >= 0; end--) {
//
//                sum += nums[end];
//
//                if (sum == k) {
//                    count++;
//                }
//            }
//
//        }
//
//        return count;
//
//    }


    public static int subarraySum(int[] nums, int k) {

        int count = 0; // 记录满足条件的子数组的个数
        int pre = 0; // 前缀和

        HashMap<Integer, Integer> map = new HashMap<>(); // 存储前缀和出现的词数

        map.put(0, 1); // 初始化前缀和为 0 的次数为 1

        for (int i = 0; i < nums.length; i++) {

            pre += nums[i]; // 更新前缀和

            if (map.containsKey(pre - k)) {
                count += map.get(pre - k); // 如果存在满足条件的前缀和，增加次数
            }

            map.put(pre, map.getOrDefault(pre, 0) + 1);  // 更新前缀和出现的次数
        }

        return count;  // 返回满足条件的子数组个数
    }

    public static void main(String[] args) {

        int[] nums = new int[]{1, 1, 1};
        int k = 2;

        System.out.println(subarraySum(nums, k));

    }

}
