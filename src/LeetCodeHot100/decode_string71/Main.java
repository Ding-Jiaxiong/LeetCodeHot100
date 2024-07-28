package LeetCodeHot100.decode_string71;

import java.util.LinkedList;

/**
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * <p>
 * 思路：辅助栈
 *
 * @author Ding Jiaxiong
 */

public class Main {

    public static String decodeString(String s) {

        StringBuilder res = new StringBuilder();

        int multi = 0;

        LinkedList<Integer> stack_multi = new LinkedList<>();
        LinkedList<String> stack_res = new LinkedList<>();

        for (Character c : s.toCharArray()) {

            if (c == '[') {
                stack_multi.addLast(multi);
                stack_res.addLast(res.toString());
                multi = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                StringBuilder tmp = new StringBuilder();
                int cur_multi = stack_multi.removeLast();
                for (int i = 0; i < cur_multi; i++) {
                    tmp.append(res);
                }
                res = new StringBuilder(stack_res.removeLast() + tmp);
            } else if (c >= '0' && c <= '9') {
                multi = multi * 10 + Integer.parseInt(c + "");
            } else {
                res.append(c);
            }

        }


        return res.toString();

    }

    public static void main(String[] args) {

        String s = "3[a]2[bc]";

        System.out.println(decodeString(s));
    }
}
