package LeetCodeHot100.longest_consecutive_sequence3;

import java.util.HashSet;
import java.util.Set;

/**
 * 问题：给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。[只要有，就算连续]
 * <p>
 * 思路: 暴力遍历会 n2 超时，解决办法就是实现跳过，当然答案还是用哈希表来存储【Set】
 *
 * @author Ding Jiaxiong
 */

public class Main {

    public static int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<Integer>();  // 用map不行，没有 k v 条件

        // 所有数字入集合
        for (int num : nums) {
            set.add(num);
        }

        int longest = 0; // 答案【连续序列的最长那个的长度】

        // 遍历集合
        for (int num : set) { // 自动拆箱

            if (!set.contains(num - 1)) {  // 不包含当前遍历数的前一个数，说明这个数得作为起点

                int curnum = num;  // 当前数
                int curlength = 1;  // 1 开头【1 其实是这道题的最小答案，数组不为空，最小返回 1】

                while (set.contains(curnum + 1)) { // 如果集合中包含当前数的下一个数，就继续循环

                    curnum++; // 当前数 → 下一个数
                    curlength++;
                }

                // 循环结束后，更新最大长度
                longest = Math.max(longest, curlength);
            }
        }

        return longest;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println(longestConsecutive(nums));

    }

}
