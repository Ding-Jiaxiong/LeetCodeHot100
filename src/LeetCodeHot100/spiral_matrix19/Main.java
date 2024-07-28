package LeetCodeHot100.spiral_matrix19;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * <p>
 * 思路: 模拟
 *
 * @author Ding Jiaxiong
 */

public class Main {

    public static List<Integer> spiralOrder(int[][] array) {

        // 特判
        if (array == null || array.length == 0 || array[0].length == 0) return new ArrayList<>();

        int row = array.length, col = array[0].length;

        int top = 0;  // 上边界
        int bottom = row - 1;  // 下边界
        int left = 0;  // 左边界
        int right = col - 1; // 右边界

        ArrayList<Integer> res = new ArrayList<>();  // 结果列表

        // 终止条件，上边界到达下边界，左边界到达右边界
        while (top <= bottom && left <= right) {

            // 向右走
            for (int i = left; i <= right; i++) {
                res.add(array[top][i]);
            }

            top++;  // 走完一层

            // 往下走
            for (int i = top; i <= bottom; i++) {
                res.add(array[i][right]);
            }

            right--;  // 走完一列

            // 向左走
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    res.add(array[bottom][i]);
                }

                bottom--;
            }

            // 向上走
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    res.add(array[i][left]);
                }

                left++;
            }

        }

        return res;
    }

    public static void main(String[] args) {

        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        List<Integer> spiralOrder = spiralOrder(matrix);

        System.out.println(spiralOrder);
    }

}
