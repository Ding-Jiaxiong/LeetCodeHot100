package LeetCodeHot100.partition_labels80;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
 * <p>
 * 思路：贪心
 *
 * @author Ding Jiaxiong
 */

public class Main {

    public static List<Integer> partitionLabels(String s) {

        int[] last = new int[26];

        int length = s.length();

        for (int i = 0; i < length; i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        List<Integer> res = new ArrayList<>();

        int start = 0;
        int end = 0;

        for (int i = 0; i < length; i++) {

            end = Math.max(end, last[s.charAt(i) - 'a']);

            if (i == end) {
                res.add(end - start + 1);
                start = end + 1;
            }

        }

        return res;

    }

    public static void main(String[] args) {

        String s = "ababcbacadefegdehijhklij";

        for (Integer label : partitionLabels(s)) {
            System.out.print(label + " ");
        }
    }
}
