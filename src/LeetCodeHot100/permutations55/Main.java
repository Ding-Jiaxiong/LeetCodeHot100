package LeetCodeHot100.permutations55;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * <p>
 * 思路：回溯
 *
 * @author Ding Jiaxiong
 */

public class Main {

    static List<Integer> nums;
    static List<List<Integer>> res;

    static void swap(int a, int b) {
        int tmp = nums.get(a);
        nums.set(a, nums.get(b));
        nums.set(b, tmp);
    }

    static void dfs(int x) {

        if (x == nums.size() - 1) {
            res.add(new ArrayList<>(nums));  // 添加排列方案
            return;
        }

        for (int i = x; i < nums.size(); i++) {
            swap(i, x);
            dfs(x + 1);
            swap(i, x);
        }
    }

    public static List<List<Integer>> permute(int[] numsnums) {

        res = new ArrayList<>();
        nums = new ArrayList<>();

        for (int num : numsnums) {
            nums.add(num);
        }

        dfs(0);

        return res;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};

        for (List<Integer> integers : permute(nums)) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

}
