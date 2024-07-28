package LeetCodeHot100.reverse_nodes_in_k_group31;

/**
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * <p>
 * 思路: 模拟
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

    public static ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode pre = dummy;

        while (head != null) {

            ListNode tail = pre;

            // 查看链表剩余部分长度是否 >= k
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    return dummy.next;
                }
            }

            ListNode next = tail.next;
            ListNode[] reverse = myReverse(head, tail);

            head = reverse[0];
            tail = reverse[1];

            // 子链表接回原链表
            pre.next = head;
            tail.next = next;
            pre = tail;
            head = tail.next;
        }

        return dummy.next;
    }

    private static ListNode[] myReverse(ListNode head, ListNode tail) {

        ListNode prev = tail.next;
        ListNode p = head;

        while (prev != tail) {
            ListNode next = p.next;
            p.next = prev;
            prev = p;
            p = next;
        }

        return new ListNode[]{tail, head};
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

        int k = 2;

        printList(reverseKGroup(node1, k));

    }

}
