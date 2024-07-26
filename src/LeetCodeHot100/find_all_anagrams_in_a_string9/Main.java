package LeetCodeHot100.find_all_anagrams_in_a_string9;


import java.util.*;

/**
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * <p>
 * 思路: 滑动窗口 + 哈希表
 *
 * @author Ding Jiaxiong
 */
public class Main {

    // 判断是否是 异位词（这种写法直接超时了）
    public static boolean isAnagram(String s, String t) {

        char[] schars = s.toCharArray();
        char[] tchars = t.toCharArray();

        Arrays.sort(schars);
        Arrays.sort(tchars);

        for (int i = 0; i < schars.length; i++) {
            if (schars[i] != tchars[i]) {
                return false;
            }
        }

        return true;
    }

//    public static List<Integer> findAnagrams(String s, String p) {  会超时
//
//        // 窗口大小固定
//        int left = 0;
//        int right = p.length();
//
//        List<Integer> res = new ArrayList<>();  // 结果列表
//
//        while (right <= s.length()) { // 左指针没有到达结尾
//
//            String substring = s.substring(left, right); // 取出
//
//            System.out.println(substring);
//
//            if (isAnagram(substring, p)) {
//                res.add(left);
//            }
//
//            left++;
//            right++;
//        }
//
//        return res;
//
//    }

    // 使用字符频率计数器
    public static List<Integer> findAnagrams(String s, String p) {

        List<Integer> res = new ArrayList<>(); // 存储结果

        // 特判
        if (s == null || s.length() == 0 || p == null || p.length() == 0) {
            return res;
        }

        // 频率计数数组, 用于记录字符出现的频率
        int[] pCount = new int[26];
        int[] sCount = new int[26];  // 数组长度为26对应字母表中的26个小写字母。

        // 初始化 p 的频率计数
        for (int i = 0; i < p.length(); i++) {
            pCount[p.charAt(i) - 'a']++; // 对应索引上的数代表 p 中字符的频率【0是b，25才是a】
        }

        // 滑动窗口
        for (int i = 0; i < s.length(); i++) {

            // 增加当前字符的频率
            sCount[s.charAt(i) - 'a']++;

            if (i >= p.length()) { // 到达窗口判断条件
                sCount[s.charAt(i - p.length()) - 'a']--; // 移出窗口左边字符的频率
            }

            // 比较两个频率数组是否相等
            if (Arrays.equals(sCount, pCount)) {
                res.add(i - p.length() + 1); // 将起始索引加入结果列表
            }

        }

        return res;

    }


    public static void main(String[] args) {


        String s = "baa";
        String p = "aa";

        List<Integer> anagrams = findAnagrams(s, p);

        for (Integer i : anagrams) {

            System.out.print(i + " ");
        }

    }

}
