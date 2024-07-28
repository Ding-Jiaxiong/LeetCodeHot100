package LeetCodeHot100.min_stack70;

import java.util.Stack;

/**
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * 思路：最小栈定义, 两个栈完成
 *
 * @author Ding Jiaxiong
 */

public class Main {


    class MinStack {

        Stack<Integer> A, B;

        public MinStack() {
            A = new Stack<>();
            B = new Stack<>();
        }

        public void push(int x) {
            A.add(x);
            if (B.isEmpty() || B.peek() >= x) B.add(x);
        }

        public void pop() {
            if (A.pop().equals(B.peek())) B.pop();
        }

        public int top() {
            return A.peek();
        }

        public int getMin() {
            return B.peek();
        }

    }


    public static void main(String[] args) {


    }
}
