package LeetCodeHot100.minimum_path_sum92;

/**
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 思路：动态规划
 *
 * @author Ding Jiaxiong
 */

public class Main {

    public static int minPathSum(int[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (i == 0 && j == 0) continue;
                else if (i == 0) grid[i][j] = grid[i][j - 1] + grid[i][j];
                else if (j == 0) grid[i][j] = grid[i - 1][j] + grid[i][j];

                else grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];

            }
        }

        return grid[grid.length - 1][grid[0].length - 1];

    }

    public static void main(String[] args) {

        int[][] grid = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};

        System.out.println(minPathSum(grid));
    }
}
