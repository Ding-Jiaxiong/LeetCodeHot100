package LeetCodeHot100.longest_substring_without_repeating_characters8;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的最长子串的长度
 * <p>
 * 基本思路: 滑动窗口
 *
 * @author Ding Jiaxiong
 */

public class Main {

    public static int lengthOfLongestSubstring(String s) {

        int left = 0; // 滑动窗口左部
        int right = 0; // 滑动窗口右部

        Set<Character> set = new HashSet<>(); // 子集结果存储

        int longest = 0; // 最长子串的长度

        while (right < s.length()) { // 滑动窗口未到达结束部, 就一直滑

            while (set.contains(s.charAt(right))) { // 如果集合中已经包含右指针，说明已经出现了重复情况

                set.remove(s.charAt(left));  // 移除左指针元素
                left++; // 窗口向右滑动

            }

            set.add(s.charAt(right));  // 右指针元素一直加入

            longest = Math.max(longest, right - left + 1);

            right++; // 右指针往后探测

        }

        return longest;

    }


    public static void main(String[] args) {

        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));

    }
}
