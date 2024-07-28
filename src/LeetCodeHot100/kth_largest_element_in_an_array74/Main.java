package LeetCodeHot100.kth_largest_element_in_an_array74;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * <p>
 * 思路：快选
 *
 * @author Ding Jiaxiong
 */

public class Main {

    // 直接排序也能过
//    public static int findKthLargest(int[] nums, int k) {
//
//        Arrays.sort(nums);
//        return nums[nums.length - k];
//
//    }

    public static int findKthLargest(int[] nums, int k) {

        List<Integer> numList = new ArrayList<Integer>();

        for (int num : nums) {
            numList.add(num);
        }

        return quickSelect(numList, k);

    }

    private static int quickSelect(List<Integer> nums, int k) {

        // 随机选择基准数
        Random rand = new Random();

        int pivot = nums.get(rand.nextInt(nums.size()));

        List<Integer> big = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> small = new ArrayList<>();

        for (int num : nums) {
            if (num > pivot) {
                big.add(num);
            } else if (num < pivot) {
                small.add(num);
            } else {
                equal.add(num);
            }
        }

        if (k <= big.size()) {
            return quickSelect(big, k);
        }

        if (nums.size() - small.size() < k) {
            return quickSelect(small, k - nums.size() + small.size());
        }

        return pivot;
    }


    public static void main(String[] args) {

        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
        int k = 2;

        System.out.println(findKthLargest(nums, k));

    }
}
