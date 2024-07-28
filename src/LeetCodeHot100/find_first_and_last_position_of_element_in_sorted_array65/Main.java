package LeetCodeHot100.find_first_and_last_position_of_element_in_sorted_array65;

/**
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 思路：两次二分
 *
 * @author Ding Jiaxiong
 */

public class Main {

    public static int[] searchRange(int[] nums, int target) {

        // 第一次二分，找到第一个等于 target
        int left = 0;
        int right = nums.length - 1;

        int first = -1;
        int last = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                first = mid;
                right = mid - 1; // 虽然找到了但是这个位置并不一定是最左边的第一个，还要继续往左边看

            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }

        // 第二次二分，找到最后一个等于target
        left = 0;
        right = nums.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {

                last = mid;
                left = mid + 1;  // 同理，继续往右看
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }

        return new int[]{first, last};
    }

    public static void main(String[] args) {

        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int target = 8;

        for (int i : searchRange(nums, target)) {
            System.out.print(i + " ");
        }

    }

}
