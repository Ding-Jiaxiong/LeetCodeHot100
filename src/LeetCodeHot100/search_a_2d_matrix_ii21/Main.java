package LeetCodeHot100.search_a_2d_matrix_ii21;

/**
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。
 * <p>
 * 思路: 我觉得二分真挺好的[ 每一行上进行二分 ]
 *
 * @author Ding Jiaxiong
 */

public class Main {

    public static int binarySearch(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;  // 不直接相加除以是为了防止整数相加溢出

            int num = nums[mid];

            if (num == target) {  // 找到目标值
                return mid;
            } else if (num > target) {  // 目标值在左边
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;

    }

    public static boolean searchMatrix(int[][] matrix, int target) {

        for (int[] row : matrix) {

            int index = binarySearch(row, target);

            if (index >= 0) return true;
        }

        return false;

    }

    public static void main(String[] args) {

        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}};

        int target = 5;

        System.out.println(searchMatrix(matrix, target));

    }

}
