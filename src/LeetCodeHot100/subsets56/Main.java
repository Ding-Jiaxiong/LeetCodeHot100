package LeetCodeHot100.subsets56;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的 子集（幂集）。
 * <p>
 * 思路：神奇的网友脑洞，一直往结果中加就完事儿了
 *
 * @author Ding Jiaxiong
 */

public class Main {

    public static List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> res = new ArrayList<>(); // 所有子集列表结果

        res.add(new ArrayList<>()); // 空集添加

        for (int i = 0; i < nums.length; i++) {  // 遍历数组的每一个元素

            int size = res.size();  // 当前结果列表的大小

            for (int j = 0; j < size; j++) { // 遍历当前结果列表中的每一个子集

                ArrayList<Integer> subset = new ArrayList<>(res.get(j));// 复制当前子集
                subset.add(nums[i]);
                res.add(subset);  // 新子集添加到结果列表
            }
        }

        return res;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{1, 2, 3};

        for (List<Integer> subset : subsets(nums)) {
            for (Integer integer : subset) {
                System.out.print(integer + " ");
            }

            System.out.println();
        }
    }
}
