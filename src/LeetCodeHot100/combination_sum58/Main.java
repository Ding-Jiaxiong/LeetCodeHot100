package LeetCodeHot100.combination_sum58;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * <p>
 * 思路：回溯 + 剪枝
 *
 * @author Ding Jiaxiong
 */

public class Main {

    public static void backtrack(List<Integer> state, int target, int[] choices, int start, List<List<Integer>> res) {

        // 子集和等于 target ，记录
        if (target == 0) {
            res.add(new ArrayList<>(state));

            return;
        }

        // 遍历所有选择
        // 从start 开始遍历，避免生成重复子集
        for (int i = start; i < choices.length; i++) {

            if (target - choices[i] < 0) {
                break;
            }

            state.add(choices[i]);

            backtrack(state, target - choices[i], choices, i, res);

            state.remove(state.size() - 1);
        }

    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<Integer> state = new ArrayList<Integer>(); // 状态
        Arrays.sort(candidates);  // 排序

        int start = 0; // 遍历起始点

        List<List<Integer>> res = new ArrayList<>();  // 结果列表
        backtrack(state, target, candidates, start, res);

        return res;
    }

    public static void main(String[] args) {

        int[] candidates = {2, 3, 6, 7};
        int target = 7;

        for (List<Integer> integers : combinationSum(candidates, target)) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }

    }
}
