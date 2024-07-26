package LeetCodeHot100.move_zeroes4;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 思路: 双指针[左指针指向当前已经处理好的序列的尾部，右指针指向待处理序列的头部]右指针不断向右移动，每次右指针指向非零数，则将左右指针对应的数交换，同时左指针右移
 *
 * @author Ding Jiaxiong
 */

public class Main {

    // 交换数组中的两个数
    public static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void moveZeroes(int[] nums) { // 引用传递

        int n = nums.length;  // 数组大小
        int left = 0;
        int right = 0;  // 起始左右指针都指向数组第一个元素 (下标为0)

        while (right < n) {  // 右指针从左到右看，直到数组尽头

            if (nums[right] != 0) { // 右指针指向的数不等于0，要和左指针指向的数进行交换，其实在这道题中 左指针指向的数一直应该为0，到最后一步交换，左指针会指向当前已经处理好的序列的尾部
                swap(nums, left, right);
                left++;
            }

            right++;

        }

    }

    public static void main(String[] args) {

        int[] nums = new int[]{1, 0, 3, 12};

        moveZeroes(nums);

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

}
