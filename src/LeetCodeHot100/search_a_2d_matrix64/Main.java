package LeetCodeHot100.search_a_2d_matrix64;

/**
 * 给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。
 * <p>
 * 思路：二维二分 或者 排除法
 *
 * @author Ding Jiaxiong
 */

public class Main {

    public static boolean searchMatrix(int[][] matrix, int target) {

        int i = 0;
        int j = matrix[0].length - 1;

        while (i < matrix.length && j >= 0) {

            if (matrix[i][j] == target) {
                return true;
            }

            if (matrix[i][j] < target) {
                i++;
            } else {
                j--;
            }
        }

        return false;
    }


    public static void main(String[] args) {

        int[][] matrix = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};

        int target = 3;

        System.out.println(searchMatrix(matrix, target));

    }
}
