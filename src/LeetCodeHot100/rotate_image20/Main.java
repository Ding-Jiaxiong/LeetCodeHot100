package LeetCodeHot100.rotate_image20;

/**
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。( 需要原地操作 )
 * <p>
 * 思路: 就硬变成数学 + 图思维
 * <p>
 * (K 神，yyds)
 *
 * @author Ding Jiaxiong
 */

public class Main {

    public static void rotate(int[][] matrix) {

        int n = matrix.length; // 矩阵行列数

        // 起始点范围: 0 <= i < n / 2 , 0 <= j < (n + 1) / 2

        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < (n + 1) / 2; j++) {

                int tmp = matrix[i][j];

                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = tmp;

            }
        }

    }

    public static void main(String[] args) {

        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }

            System.out.println();
        }

        System.out.println();

        rotate(matrix);

        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }

            System.out.println();
        }

    }

}
