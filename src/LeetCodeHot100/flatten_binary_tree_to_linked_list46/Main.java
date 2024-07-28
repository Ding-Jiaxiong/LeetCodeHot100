package LeetCodeHot100.flatten_binary_tree_to_linked_list46;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：展开后的单链表应该与二叉树 先序遍历 顺序相同。
 * <p>
 * 思路:
 *
 * @author Ding Jiaxiong
 */

public class Main {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void inorder(TreeNode root, List<Integer> res) {
        if (root == null) return;

        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

    public static List<Integer> inorderTraversal(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<>();

        inorder(root, res);

        return res;
    }

    public static void flatten(TreeNode root) {

        TreeNode curr = root;

        while (curr != null) {

            if (curr.left != null) {

                TreeNode next = curr.left;
                TreeNode predecessor = next;

                while (predecessor.right != null) {

                    predecessor = predecessor.right;
                }

                predecessor.right = curr.right;
                curr.left = null;
                curr.right = next;
            }

            curr = curr.right;

        }

    }

    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(6);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;

        for (Integer integer : inorderTraversal(node1)) {
            System.out.print(integer + " ");
        }

        System.out.println();

        flatten(node1);

        for (Integer integer : inorderTraversal(node1)) {
            System.out.print(integer + " ");
        }

    }

}
