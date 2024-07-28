package LeetCodeHot100.daily_temperatures72;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * <p>
 * 思路：单调栈
 *
 * @author Ding Jiaxiong
 */

public class Main {

    public static int[] dailyTemperatures(int[] temperatures) {

        // 定义栈
        Deque<Integer> stack = new ArrayDeque<>();

        int[] res = new int[temperatures.length];  // 结果数组

        for (int i = 0; i < temperatures.length; i++) {

            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {

                int index = stack.pop();
                res[index] = i - index;

            }

            stack.push(i);

        }

        return res;
    }

    public static void main(String[] args) {

        int[] temperatures = new int[]{73, 74, 75, 71, 69, 72, 76, 73};

        for (int i : dailyTemperatures(temperatures)) {
            System.out.print(i + " ");
        }

    }
}
