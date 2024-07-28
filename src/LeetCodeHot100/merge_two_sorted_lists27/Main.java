package LeetCodeHot100.merge_two_sorted_lists27;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * 思路: 双指针
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

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(); // 伪头结点
        ListNode curr = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }

            curr = curr.next;
        }

        // 处理结余
        curr.next = l1 != null ? l1 : l2;

        return dummy.next;  // 伪头结点下一个节点才是真正的头
    }

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;

        printList(node1);

        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);

        node4.next = node5;
        node5.next = node6;

        printList(node4);

        printList(mergeTwoLists(node1, node4));

    }

}
