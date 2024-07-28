package LeetCodeHot100.word_search60;

/**
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 *
 * @author Ding Jiaxiong
 */

public class Main {


    public static boolean exist(char[][] board, String word) {

        char[] words = word.toCharArray();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                if (dfs(board, words, i, j, 0)) return true;

            }
        }

        return false;
    }

    private static boolean dfs(char[][] board, char[] word, int i, int j, int k) {

        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) return false;
        if (k == word.length - 1) return true;

        board[i][j] = '\0';

        boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) || dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i, j - 1, k + 1);

        board[i][j] = word[k];

        return res;
    }

    public static void main(String[] args) {

        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};

        String word = "ABCCED";

        System.out.println(exist(board, word));
    }

}
