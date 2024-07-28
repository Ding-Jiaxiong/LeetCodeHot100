package LeetCodeHot100.product_of_array_except_self16;

/**
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 * <p>
 * 32 位 整数范围
 * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * <p>
 * 思路：数理逻辑，表格，两步循环
 *
 * @author Ding Jiaxiong
 */

public class Main {


    public static int[] productExceptSelf(int[] nums) {

        int length = nums.length;

        // 特判
        if (length == 0) return new int[0];

        int[] answer = new int[length];  // 结果数组

        answer[0] = 1;

        int tmp = 1;

        // 计算下三角
        for (int i = 1; i < length; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // 计算上三角
        for (int i = length - 2; i >= 0; i--) {

            tmp *= nums[i + 1];
            answer[i] *= tmp;
        }

        return answer;

    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4};
        for (int i : productExceptSelf(nums)) {
            System.out.print(i + " ");
        }

    }

}
