package LeetCodeHot100.rotting_oranges52;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * 在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：
 * <p>
 * - 值 0 代表空单元格；
 * - 值 1 代表新鲜橘子；
 * - 值 2 代表腐烂的橘子。
 * <p>
 * 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。
 * <p>
 * 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。
 * <p>
 * 思路：BFS
 *
 * @author Ding Jiaxiong
 */

public class Main {

    static int[] directRow = new int[]{-1, 0, 1, 0};
    static int[] directCol = new int[]{0, -1, 0, 1};

    public static int orangesRotting(int[][] grid) {

        int rowrow = grid.length;
        int colcol = grid[0].length;

        Queue<Integer> queue = new ArrayDeque<>();

        Map<Integer, Integer> depth = new HashMap<>();

        for (int r = 0; r < rowrow; r++) {
            for (int c = 0; c < colcol; c++) {

                if (grid[r][c] == 2) {
                    int code = r * colcol + c;
                    queue.add(code);
                    depth.put(code, 0);
                }

            }
        }

        int ans = 0;

        while (!queue.isEmpty()) {

            int code = queue.remove();
            int r = code / colcol;
            int c = code % colcol;

            for (int k = 0; k < 4; k++) {

                int nr = r + directRow[k];
                int nc = c + directCol[k];

                if (0 <= nr && nr < rowrow && 0 <= nc && nc < colcol && grid[nr][nc] == 1) {
                    grid[nr][nc] = 2;
                    int ncode = nr * colcol + nc;
                    queue.add(ncode);
                    depth.put(ncode, depth.get(code) + 1);
                    ans = depth.get(ncode);
                }
            }
        }

        for (int[] row : grid) {
            for (int v : row) {
                if (v == 1) {
                    return -1;
                }
            }
        }

        return ans;

    }

    public static void main(String[] args) {

        int[][] oranges = new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};

        System.out.println(orangesRotting(oranges));
    }
}
