package LeetCodeHot100.majority_element97;

/**
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 思路：摩尔投票
 *
 * @author Ding Jiaxiong
 */

public class Main {

    public static int majorityElement(int[] nums) {

        int x = 0;
        int votes = 0;

        for (int num : nums) {

            if (votes == 0) x = num;

            votes += num == x ? 1 : -1;
        }

        return x;

    }

    public static void main(String[] args) {

        int[] nums = {3, 2, 3};

        System.out.println(majorityElement(nums));
    }
}
