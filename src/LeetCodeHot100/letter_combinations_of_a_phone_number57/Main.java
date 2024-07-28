package LeetCodeHot100.letter_combinations_of_a_phone_number57;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * <p>
 * 思路：回溯
 *
 * @author Ding Jiaxiong
 */

public class Main {

    public static List<String> letterCombinations(String digits) {

        List<String> combinations = new ArrayList<>();  // 结果字符串列表

        if (digits.length() == 0) return combinations;

        // 存储字符映射关系
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};

        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());

        return combinations;

    }

    private static void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {

        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {

            char digit = digits.charAt(index);

            String letter = phoneMap.get(digit);
            int lettersCount = letter.length();

            for (int i = 0; i < lettersCount; i++) {
                combination.append(letter.charAt(i));
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }

    }

    public static void main(String[] args) {

        String digits = "23";

        for (String string : letterCombinations(digits)) {
            System.out.print(string + " ");
        }

    }

}
