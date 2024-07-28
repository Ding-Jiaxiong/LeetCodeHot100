package LeetCodeHot100.single_number96;

/**
 * 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 思路：位运算
 *
 * @author Ding Jiaxiong
 */

public class Main {

    public static int singleNumber(int[] nums) {

        int x = 0;

        for (int num : nums) {
            x ^= num;
        }

        return x;
    }

    public static void main(String[] args) {

        int[] nums = {2, 2, 1};

        System.out.println(singleNumber(nums));
    }
}
