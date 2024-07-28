package LeetCodeHot100.binary_tree_right_side_view45;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * <p>
 * 思路: 就是层序遍历的最后一个值拼一块儿
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

    public static List<Integer> rightSideView(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();

        ArrayList<Integer> res = new ArrayList<>();

        if (root != null) queue.add(root);

        while (!queue.isEmpty()) {

            ArrayList<Integer> tmp = new ArrayList<>();

            for (int i = queue.size(); i > 0; i--) {

                TreeNode node = queue.poll();
                tmp.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }


            res.add(tmp.get(tmp.size() - 1));
        }


        return res;
    }

    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(4);

        node1.left = node2;
        node1.right = node3;
        node2.right = node4;
        node3.right = node5;

        for (Integer i : inorderTraversal(node1)) {
            System.out.print(i + " ");
        }

        System.out.println();

        for (Integer integer : rightSideView(node1)) {
            System.out.print(integer + " ");
        }
    }

}
