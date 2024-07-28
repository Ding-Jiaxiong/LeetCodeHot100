package LeetCodeHot100.binary_tree_maximum_path_sum50;

/**
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 * <p>
 * 思路：递归
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

    static int maxSum = Integer.MIN_VALUE;

    public static int maxPathSum(TreeNode root) {

        maxGain(root);

        return maxSum;
    }

    private static int maxGain(TreeNode node) {

        if (node == null) return 0;

        // 递归计算左右子节点的贡献
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        // 最终决定的最大路径由三部分组成
        int priceNewpath = node.val + leftGain + rightGain;

        // 更新答案
        maxSum = Math.max(maxSum, priceNewpath);

        // 返回节点的最大贡献
        return node.val + Math.max(leftGain, rightGain);
    }

    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        node1.left = node2;
        node1.right = node3;

        System.out.println(maxPathSum(node1));

    }

}
