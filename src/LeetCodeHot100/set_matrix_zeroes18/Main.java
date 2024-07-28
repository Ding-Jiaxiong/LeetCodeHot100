package LeetCodeHot100.set_matrix_zeroes18;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 * <p>
 * 思路: 两遍扫 matrix ,第一遍用集合记录哪些行、哪些列有 0 ; 第二遍置 0
 *
 * @author Ding Jiaxiong
 */

public class Main {

    public static void setZeroes(int[][] matrix) {

        Set<Integer> row_zero = new HashSet<>(); // 有 0 的行
        Set<Integer> col_zero = new HashSet<>(); // 有 0 的列

        int row = matrix.length, col = matrix[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                if (matrix[i][j] == 0) {
                    row_zero.add(i);  // 加入行号
                    col_zero.add(j);  // 加入列号
                }

            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                if (row_zero.contains(i) || col_zero.contains(j)) {
                    matrix[i][j] = 0;
                }

            }
        }

    }

    public static void main(String[] args) {

        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};

        setZeroes(matrix);

        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt);
            }
            System.out.println();
        }

    }

}
