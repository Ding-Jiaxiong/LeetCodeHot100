package LeetCodeHot100.sort_list33;

/**
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * <p>
 * 思路: 归并排序
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

    public static ListNode sortList(ListNode head) {

        // 特判
        if (head == null || head.next == null) return head;

        ListNode fast = head.next, slow = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode tmp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);

        ListNode h = new ListNode();
        ListNode res = h;

        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }

            h = h.next;
        }

        h.next = left != null ? left : right;

        return res.next;
    }


    public static void main(String[] args) {

        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        printList(node1);

        printList(sortList(node1));

    }

}
