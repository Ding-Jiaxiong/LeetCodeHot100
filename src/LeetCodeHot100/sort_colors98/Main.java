package LeetCodeHot100.sort_colors98;

/**
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 思路：直接干三指针
 *
 * @author Ding Jiaxiong
 */

public class Main {

    public static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void sortColors(int[] nums) {

        int size = nums.length;

        int left = -1;
        int right = size;

        for (int i = 0; i < right; i++) {

            if (nums[i] == 0) {
                swap(nums, i, ++left);
            } else if (nums[i] == 2) {
                swap(nums, i--, --right);
            }

        }

    }


    public static void main(String[] args) {

        int[] nums = {2, 0, 2, 1, 1, 0};

        sortColors(nums);

        for (int num : nums) {
            System.out.print(num + " ");
        }

    }
}
