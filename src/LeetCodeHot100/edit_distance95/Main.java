package LeetCodeHot100.edit_distance95;

/**
 * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
 * <p>
 * 思路：动态规划
 *
 * @author Ding Jiaxiong
 */

public class Main {

    public static int minDistance(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        if (n * m == 0) {
            return n + m;
        }

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = i;
        }

        for (int j = 1; j < m + 1; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i < n + 1; i++) {

            for (int j = 1; j < m + 1; j++) {

                int left = dp[i - 1][j] + 1;
                int down = dp[i][j - 1] + 1;
                int left_down = dp[i - 1][j - 1];

                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    left_down += 1;
                }

                dp[i][j] = Math.min(left, Math.min(down, left_down));
            }

        }

        return dp[n][m];
    }

    public static void main(String[] args) {

        String word1 = "horse";
        String word2 = "ros";

        System.out.println(minDistance(word1, word2));

    }
}
