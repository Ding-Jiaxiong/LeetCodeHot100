package LeetCodeHot100.copy_list_with_random_pointer32;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
 * 构造这个链表的深拷贝
 * <p>
 * 思路: 哈希表，分别 val 和 random 构建原链表节点和新链表节点的键值对对应关系
 *
 * @author Ding Jiaxiong
 */

public class Main {

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        public Node(int val, Node random) {
            this.val = val;
            this.random = random;
        }
    }

    public static void printList(Node head) {
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

    public static Node copyRandomList(Node head) {

        // 特判
        if (head == null) return null;

        Node cur = head;

        Map<Node, Node> map = new HashMap<>();

        // 复制各个节点（按值）
        while (cur != null) {

            map.put(cur, new Node(cur.val));

            cur = cur.next;
        }

        // 回到头结点
        cur = head;

        // 复制 random 关系
        while (cur != null) {

            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);

            cur = cur.next;
        }

        return map.get(head);
    }


    public static void main(String[] args) {

        Node node1 = new Node(7, null);
        Node node2 = new Node(13, node1);
        Node node4 = new Node(10, node2);
        Node node3 = new Node(11, node4);
        Node node5 = new Node(1, node1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        printList(node1);

        printList(copyRandomList(node1));

    }

}
