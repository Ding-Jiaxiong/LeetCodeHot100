package LeetCodeHot100.search_insert_position63;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 思路：二分
 *
 * @author Ding Jiaxiong
 */

public class Main {

    public static int searchInsert(int[] nums, int target) {

        int n = nums.length;

        int left = 0;
        int right = n - 1;

        int res = n;

        while (left <= right) {

            int mid = left + (right - left) / 2;  // 防止越界

            if (target <= nums[mid]) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }

        return res;

    }

    public static void main(String[] args) {


        int[] nums = {1, 3, 5, 6};
        int target = 5;

        System.out.println(searchInsert(nums, target));

    }
}
