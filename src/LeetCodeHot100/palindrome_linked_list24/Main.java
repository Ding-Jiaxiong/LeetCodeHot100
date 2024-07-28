package LeetCodeHot100.palindrome_linked_list24;

import java.util.ArrayList;

/**
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 思路: 底子是双指针, 链表转到列表中存储进行比较
 *
 * @author Ding Jiaxiong
 */

public class Main {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static boolean isPalindrome(ListNode head) {

        ArrayList<Integer> list = new ArrayList<>();

        // 取出所有数据放入列表
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        int size = list.size();
        for (int i = 0; i < size / 2; i++) {
            if (list.get(i) != list.get(size - i - 1)) { // 前后对比较
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        System.out.println(isPalindrome(node1));

    }

}
