package LeetCodeHot100.valid_parentheses69;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 思路：栈
 *
 * @author Ding Jiaxiong
 */

public class Main {

    public static boolean isValid(String s) {

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(i);
            } else {

                if (stack.isEmpty()) {
                    return false;
                }
                if (s.charAt(i) == ')' && s.charAt(stack.pop()) != '(') {
                    return false;
                }
                if (s.charAt(i) == '}' && s.charAt(stack.pop()) != '{') {
                    return false;
                }
                if (s.charAt(i) == ']' && s.charAt(stack.pop()) != '[') {
                    return false;
                }
            }

        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {

        String s = "()";

        System.out.println(isValid(s));

    }

}
