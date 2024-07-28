package LeetCodeHot100.find_the_duplicate_number100;

/**
 * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。
 * <p>
 * 假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。
 * <p>
 * 思路：快慢指针
 *
 * @author Ding Jiaxiong
 */

public class Main {

    public static int findDuplicate(int[] nums) {

        int slow = 0;
        int fast = 0;

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }


    public static void main(String[] args) {

        int[] nums = {1, 3, 4, 2, 2};

        System.out.println(findDuplicate(nums));
    }
}
