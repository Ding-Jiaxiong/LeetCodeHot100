package LeetCodeHot100.sliding_window_maximum11;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 思路: 滑动窗口 + 单调队列
 *
 * @author Ding Jiaxiong
 */


public class Main {


    public static int[] maxSlidingWindow(int[] nums, int k) {

        // 特判
        if (nums.length == 0 || k == 0) return new int[0];

        // 双端队列初始化
        Deque<Integer> deque = new LinkedList<>();

        int[] res = new int[nums.length - k + 1];  // 结果数组


        for (int j = 0, i = 1 - k; j < nums.length; i++, j++) {

            // 删除 deque 中对应的 nums[i - 1]
            if (i > 0 && deque.peekFirst() == nums[i - 1])
                deque.removeFirst();

            // 保持 deque 递减
            while (!deque.isEmpty() && deque.peekLast() < nums[j])
                deque.removeLast();

            deque.addLast(nums[j]);

            // 记录窗口最大值
            if (i >= 0)
                res[i] = deque.peekFirst();
        }

        return res;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};

        int k = 3;

        for (int i : maxSlidingWindow(nums, k)) {
            System.out.print(i + " ");
        }

    }

}
