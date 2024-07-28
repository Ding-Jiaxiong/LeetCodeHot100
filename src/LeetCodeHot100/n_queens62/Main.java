package LeetCodeHot100.n_queens62;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 * <p>
 * 思路：回溯套路
 *
 * @author Ding Jiaxiong
 */

public class Main {

    public static List<List<String>> solveNQueens(int n) {

        List<List<String>> res = new ArrayList<>();

        int[] col = new int[n];
        boolean[] onPath = new boolean[n];

        boolean[] diag1 = new boolean[n * 2 - 1];
        boolean[] diag2 = new boolean[n * 2 - 1];

        dfs(0, n, col, onPath, diag1, diag2, res);

        return res;

    }

    private static void dfs(int r, int n, int[] col, boolean[] onPath, boolean[] diag1, boolean[] diag2, List<List<String>> res) {

        if (r == n) {
            List<String> board = new ArrayList<>(n);

            for (int c : col) {
                char[] row = new char[n];
                Arrays.fill(row, '.');
                row[c] = 'Q';
                board.add(new String(row));
            }

            res.add(board);
            return;
        }

        for (int c = 0; c < n; c++) {

            int rc = r - c + n - 1;

            if (!onPath[c] && !diag1[r + c] && !diag2[rc]) {
                col[r] = c;
                onPath[c] = diag1[r + c] = diag2[rc] = true;
                dfs(r + 1, n, col, onPath, diag1, diag2, res);
                onPath[c] = diag1[r + c] = diag2[rc] = false;  // 恢复现场
            }
        }

    }

    public static void main(String[] args) {

        int n = 4;
        for (List<String> solveNQueen : solveNQueens(n)) {
            for (String s : solveNQueen) {
                System.out.print(s + " ");
            }
            System.out.println();
        }

    }
}
