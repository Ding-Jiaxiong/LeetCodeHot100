package LeetCodeHot100.linked_list_cycle25;

/**
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 * <p>
 * 思路: 快慢指针: 有环的情况下，快慢指针一定会重合
 *
 * @author Ding Jiaxiong
 */

public class Main {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static boolean hasCycle(ListNode head) {

        // 特判
        if (head == null || head.next == null) return false;

        ListNode slow = head; // 慢指针，一次走一步
        ListNode fast = head.next;  // 快指针，一次走两步

        while (slow != fast) {

            if (fast == null || fast.next == null) return false; // 这种情况是一共就两个节点或者一个节点

            slow = slow.next;  // 走一步
            fast = fast.next.next; // 走两步
        }

        return true;
    }

    public static void main(String[] args) {

        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

        System.out.println(hasCycle(node1));

    }

}
