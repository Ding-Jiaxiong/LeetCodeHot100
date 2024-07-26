package LeetCodeHot100.group_anagrams2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * <p>
 * 主要解题思路: 哈希表【将排序之后的字符串作为哈希表的键】
 *
 * @author Ding Jiaxiong
 */

public class Main {

    public static List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>(); // 存储遍历结果

        for (String str : strs) {  // 遍历

            char[] chars = str.toCharArray();  // 转换为字符数组方便排序
            Arrays.sort(chars);

            String key = new String(chars);  // 排序结果就是要存的键

            // 从 map 中取，如果不存在返回空列表
            List<String> list = map.getOrDefault(key, new ArrayList<>());

            // 加入当前字符串
            list.add(str);

            // 更新 map
            map.put(key, list);
        }

        return new ArrayList<>(map.values());

    }

    public static void main(String[] args) {

        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};

        for (List<String> groupAnagram : groupAnagrams(strs)) {

            System.out.println(groupAnagram);
        }


    }

}
