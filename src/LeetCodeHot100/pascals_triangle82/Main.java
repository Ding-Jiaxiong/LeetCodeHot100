package LeetCodeHot100.pascals_triangle82;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * <p>
 * 思路：数学题
 *
 * @author Ding Jiaxiong
 */

public class Main {

    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> res = new ArrayList<>(); // 结果列表

        for (int i = 0; i < numRows; i++) {

            List<Integer> row = new ArrayList<>();

            for (int j = 0; j <= i; j++) {

                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }

            res.add(row);

        }

        return res;
    }

    public static void main(String[] args) {

        int numRows = 5;

        for (List<Integer> integers : generate(numRows)) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }

            System.out.println();
        }

    }
}
