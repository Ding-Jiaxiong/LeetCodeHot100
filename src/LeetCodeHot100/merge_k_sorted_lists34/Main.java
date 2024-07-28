package LeetCodeHot100.merge_k_sorted_lists34;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 * <p>
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * <p>
 * 思路：K 指针，K 个指针分别指向 K 条链表 // 复杂度有点高了，如果用递归 + 归并会更快
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

    public static ListNode mergeKLists(ListNode[] lists) {

        int k = lists.length;  // k 个指针

        ListNode dummy = new ListNode(); // 暂头

        ListNode tail = dummy;

        while (true) {

            ListNode minNode = null;
            int minPointer = -1;

            for (int i = 0; i < k; i++) {

                if (lists[i] == null) {
                    continue;
                }

                if (minNode == null || lists[i].val < minNode.val) {

                    minNode = lists[i];
                    minPointer = i;
                }
            }

            if (minPointer == -1) {
                break;
            }

            tail.next = minNode;
            tail = tail.next;
            lists[minPointer] = lists[minPointer].next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;

        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);

        node4.next = node5;
        node5.next = node6;

        ListNode node7 = new ListNode(2);
        ListNode node8 = new ListNode(6);

        node7.next = node8;

        printList(node1);
        printList(node4);
        printList(node7);

        ListNode[] nodes = new ListNode[]{node1, node4, node7};

        printList(mergeKLists(nodes));

    }

}
