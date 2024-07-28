package LeetCodeHot100.kth_smallest_element_in_a_bst44;

/**
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 小的元素（从 1 开始计数）。
 * <p>
 * 思路: 二叉搜索树的重要性质【二叉搜索树的中序遍历 是一个 递增序列】【这道题性质就变了：求中序遍历的第 k 个节点。】
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

    static int res, k;

    public static void dfs(TreeNode root) {

        if (root == null) return;

        dfs(root.left);
        if (k == 0) return;
        if (--k == 0) res = root.val;
        dfs(root.right);
    }

    public static int kthSmallest(TreeNode root, int kk) {

        k = kk;
        dfs(root);
        return res;
    }

    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(2);

        node1.left = node2;
        node1.right = node3;
        node2.right = node4;

        int k = 1;

        System.out.println(kthSmallest(node1, k));

    }

}
