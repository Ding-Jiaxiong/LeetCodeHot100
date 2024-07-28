package LeetCodeHot100.remove_nth_node_from_end_of_list29;

import java.lang.annotation.Target;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * <p>
 * 思路: 双指针【 快慢指针 】
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

    public static void printList(ListNode head) {
        while (head != null) {

            if (head.next != null) {
                System.out.print(head.val + " -> ");
            } else {
                System.out.print(head.val);
            }

            head = head.next;
        }

        System.out.println();
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        // 伪头结点
        ListNode dummy = new ListNode();

        dummy.next = head;

        // 快指针
        ListNode fast = dummy;  // 用于遍历链表

        // 慢指针
        ListNode slow = dummy;

        // 快指针先走 n 步
        while (n > 0) {
            fast = fast.next;
            n--;
        }

        // 快指针没指向空，就一直循环
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;

        }

        // 这个时候慢指针指向的就是 要删除的节点的前一个节点, 跳过（删除）下一个节点即可
        slow.next = slow.next.next;

        return dummy.next;
    }

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        printList(node1);

        int n = 2;

        printList(removeNthFromEnd(node1, n));

    }

}
