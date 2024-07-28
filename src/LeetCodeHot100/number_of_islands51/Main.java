package LeetCodeHot100.number_of_islands51;

/**
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * <p>
 * 思路：深度优先遍历
 *
 * @author Ding Jiaxiong
 */

public class Main {

    public static int numIslands(char[][] grid) {

        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }

            }
        }

        return count;
    }

    private static void dfs(char[][] grid, int i, int j) {

        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') return;

        grid[i][j] = '0';
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);

    }


    public static void main(String[] args) {

        char[][] grid = new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};

        System.out.println(numIslands(grid));
    }
}
