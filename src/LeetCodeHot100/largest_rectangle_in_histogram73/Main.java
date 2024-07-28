package LeetCodeHot100.largest_rectangle_in_histogram73;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * <p>
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * <p>
 * 思路：单调栈 + 哨兵技巧
 *
 * @author Ding Jiaxiong
 */

public class Main {

    public static int largestRectangleArea(int[] heights) {

        int len = heights.length;

        if (len == 0) return 0;
        if (len == 1) return heights[0];

        int res = 0;

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < len; i++) {


            while (!stack.isEmpty() && heights[i] < heights[stack.peekLast()]) {

                int curHeight = heights[stack.peekLast()];
                while (!stack.isEmpty() && heights[stack.peekLast()] == curHeight) {
                    stack.pollLast();
                }

                int curWidth;

                if (stack.isEmpty()) {
                    curWidth = i;
                } else {
                    curWidth = i - stack.peekLast() - 1;
                }

                res = Math.max(res, curWidth * curHeight);
            }

            stack.addLast(i);

        }

        while (!stack.isEmpty()) {

            int curHeight = heights[stack.pollLast()];

            while (!stack.isEmpty() && heights[stack.peekLast()] == curHeight) {
                stack.pollLast();
            }

            int curWidth;

            if (stack.isEmpty()) {
                curWidth = len;
            } else {
                curWidth = len - stack.peekLast() - 1;
            }

            res = Math.max(res, curWidth * curHeight);

        }

        return res;

    }

    public static void main(String[] args) {

        int[] heights = new int[]{2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(heights));

    }
}
