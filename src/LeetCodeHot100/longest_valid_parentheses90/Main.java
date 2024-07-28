package LeetCodeHot100.longest_valid_parentheses90;

/**
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号 子串 的长度。
 * <p>
 * 思路：动态规划
 *
 * @author Ding Jiaxiong
 */

public class Main {

    public static int longestValidParentheses(String s) {

        int maxres = 0;

        int[] dp = new int[s.length()];

        for (int i = 1; i < s.length(); i++) {

            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }

                maxres = Math.max(maxres, dp[i]);
            }
        }


        return maxres;

    }

    public static void main(String[] args) {

        String s = "(()";

        System.out.println(longestValidParentheses(s));

    }
}
