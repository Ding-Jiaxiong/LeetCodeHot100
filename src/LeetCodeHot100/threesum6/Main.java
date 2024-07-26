package LeetCodeHot100.threesum6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
 * <p>
 * 排序 + 双指针
 *
 * @author Ding Jiaxiong
 */

public class Main {

    public static List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums); // 从小到大排序

        List<List<Integer>> res = new ArrayList<>(); // 结果

        for (int k = 0; k < nums.length; k++) { // 最左（最小）元素的指针 k

            if (nums[k] > 0) break;  // 3 个元素都 > 0，不可能再找到了

            if (k > 0 && nums[k] == nums[k - 1]) continue; // 已经加入，执行会结果重复

            int left = k + 1; // 左指针
            int right = nums.length - 1;  // 右指针

            while (left < right) {  // 左右指针相遇结束本次遍历

                int sum = nums[k] + nums[left] + nums[right];

                if (sum < 0) {  // 说明 左指针指着的元素太小，不足以拉到 0
                    while (left < right && nums[left] == nums[++left]) ;  // 左指针右移到下一个不同的数
                } else if (sum > 0) {  // 说明 右指针指着的元素太大， 不足以缩到 0
                    while (left < right && nums[right] == nums[--right]) ; // 右指针左移到下一个不同的数
                } else { // 记录一个结果

                    res.add(new ArrayList<Integer>(Arrays.asList(nums[k], nums[left], nums[right])));

                    while (left < right && nums[left] == nums[++left]) ;  // 左指针右移到下一个不同的数
                    while (left < right && nums[right] == nums[--right]) ; // 右指针左移到下一个不同的数
                }
            }
        }

        return res;
    }


    public static void main(String[] args) {

        int[] nums = {-1, 0, 1, 2, -1, -4};

        for (List<Integer> integerList : threeSum(nums)) {

            for (Integer i : integerList) {

                System.out.print(i + " ");
            }

            System.out.println();

        }

    }

}
