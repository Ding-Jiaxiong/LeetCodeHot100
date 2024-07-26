package LeetCodeHot100.trapping_rain_water7;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * 思路: 双指针[这道题暂时没看明白，感觉代码很简单]
 *
 * @author Ding Jiaxiong
 */

public class Main {

    public static int trap(int[] height) {

        int res = 0; // 记录答案

        int left = 0; // 左指针指向最左
        int right = height.length - 1;  //右指针最右

        int leftMax = 0;  // 左方遍历最大值
        int rightMax = 0; // 右方遍历最大值

        while (left < right) { // 指针相遇结束

            leftMax = Math.max(leftMax, height[left]);  // 更新左方
            rightMax = Math.max(rightMax, height[right]); // 更新右方

            if (height[left] < height[right]) { //
                res += leftMax - height[left];
                left++;
            } else {
                res += rightMax - height[right];
                right--;
            }

        }

        return res;

    }

    public static void main(String[] args) {

        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        System.out.println(trap(height));
    }

}
