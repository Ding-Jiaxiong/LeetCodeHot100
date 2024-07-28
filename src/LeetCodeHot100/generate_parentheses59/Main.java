package LeetCodeHot100.generate_parentheses59;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * 思路：回溯
 *
 * @author Ding Jiaxiong
 */

public class Main {

    static List<String> res = new ArrayList<>();  // 结果列表

    public static List<String> generateParenthesis(int n) {

        // 特判
        if (n <= 0) return null;

        def("", 0, 0, n);

        return res;
    }

    private static void def(String paths, int left, int right, int n) {

        if (left > n || right > left) return;

        if (paths.length() == n * 2) {
            res.add(paths);
            return;
        }

        def(paths + "(", left + 1, right, n);
        def(paths + ")", left, right + 1, n);

    }


    public static void main(String[] args) {

        int n = 3;

        for (String s : generateParenthesis(n)) {
            System.out.print(s + " ");
        }

    }
}
