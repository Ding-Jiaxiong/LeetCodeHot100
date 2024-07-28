package LeetCodeHot100.longest_common_subsequence94;

/**
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 * <p>
 * 思路：动态规划【这道题不用连续】
 *
 * @author Ding Jiaxiong
 */

public class Main {

    public static int longestCommonSubsequence(String text1, String text2) {

        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {

            char c1 = text1.charAt(i - 1);

            for (int j = 1; j <= n; j++) {

                char c2 = text2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }

            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {

        String text1 = "abcde";
        String text2 = "ace";

        System.out.println(longestCommonSubsequence(text1, text2));

    }
}
