package LeetCodeHot100.linked_list_cycle_ii26;

/**
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * <p>
 * 思路: 和常规环形链表不同，这里要返回节点, 【 数学 】 之前那种方式找不到入口节点，汇聚节点是入口的下一个, 相遇两次，第二次就能相遇在入口处( 不过第二轮跑的时候速度一样 )
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

    public static ListNode detectCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (true) {

            if (fast == null || fast.next == null) return null;

            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) break;
        }

        fast = head; // 快指针回到头节点，再跑一次
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }

    public static void main(String[] args) {

        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

        System.out.println(detectCycle(node1).val);
    }
}
