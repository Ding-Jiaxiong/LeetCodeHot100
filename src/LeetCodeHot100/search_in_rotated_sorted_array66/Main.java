package LeetCodeHot100.search_in_rotated_sorted_array66;

/**
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 * <p>
 * 思路：二分
 *
 * @author Ding Jiaxiong
 */

public class Main {

    public static int search(int[] nums, int target) {

        int n = nums.length;

        // 特判
        if (n == 0) return -1;
        if (n == 1) return nums[0] == target ? 0 : -1;

        int left = 0;
        int right = n - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[0] <= nums[mid]) {

                if (nums[0] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[n - 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;

    }

    public static void main(String[] args) {

        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;

        System.out.println(search(nums, target));

    }

}
