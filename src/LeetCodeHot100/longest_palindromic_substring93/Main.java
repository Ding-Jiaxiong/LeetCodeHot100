package LeetCodeHot100.longest_palindromic_substring93;

/**
 * 给你一个字符串 s，找到 s 中最长的 回文 子串。
 * <p>
 * 思路：动态规划
 *
 * @author Ding Jiaxiong
 */

public class Main {

    public static String longestPalindrome(String s) {

        int len = s.length();
        if (len < 2) return s;

        int maxLen = 1;
        int begin = 0;

        boolean[][] dp = new boolean[len][len];
        char[] charArray = s.toCharArray();

        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {

                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {


                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {

                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }

        return s.substring(begin, begin + maxLen);

    }

    public static void main(String[] args) {

        String s = "babad";

        System.out.println(longestPalindrome(s));
    }
}
