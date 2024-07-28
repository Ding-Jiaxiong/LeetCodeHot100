package LeetCodeHot100.symmetric_tree39;

/**
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * <p>
 * 思路: 又是递归了
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

    public static boolean isSymmetric(TreeNode root) {

        // 特判
        return root == null || recur(root.left, root.right);

    }

    private static boolean recur(TreeNode left, TreeNode right) {

        if (left == null && right == null) return true;
        if (left == null || right == null || left.val != right.val) return false;

        return recur(left.left, right.right) && recur(left.right, right.left); // 自行脑补那个对称结构
    }


    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(3);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        System.out.println(isSymmetric(node1));

    }

}
