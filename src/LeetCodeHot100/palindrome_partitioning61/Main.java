package LeetCodeHot100.palindrome_partitioning61;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 * <p>
 * 思路：回溯【枚举性质】
 *
 * @author Ding Jiaxiong
 */

public class Main {

    // 辅助方法，检测字符串是否回文
    public static boolean checkPalindrome(char[] charArray, int left, int right) {

        while (left < right) {

            if (charArray[left] != charArray[right]) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static List<List<String>> partition(String s) {

        int len = s.length();

        List<List<String>> res = new ArrayList<>();  // 结果列表

        if (len == 0) return res;

        Deque<String> stack = new ArrayDeque<>();

        char[] charArray = s.toCharArray();

        dfs(charArray, 0, len, stack, res);

        return res;
    }

    private static void dfs(char[] charArray, int index, int len, Deque<String> path, List<List<String>> res) {

        if (index == len) {
            res.add(new ArrayList<>(path));
            return;
        }


        for (int i = index; i < len; i++) {
            if (!checkPalindrome(charArray, index, i)) {
                continue;
            }

            path.addLast(new String(charArray, index, i + 1 - index));
            dfs(charArray, i + 1, len, path, res);
            path.removeLast();
        }

    }

    public static void main(String[] args) {

        String S = "aab";

        for (List<String> strings : partition(S)) {
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println();
        }

    }
}
