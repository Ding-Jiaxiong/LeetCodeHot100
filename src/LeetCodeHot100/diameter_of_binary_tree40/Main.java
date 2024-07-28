package LeetCodeHot100.diameter_of_binary_tree40;

/**
 * 给你一棵二叉树的根节点，返回该树的 直径 。
 * <p>
 * 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。 两节点之间路径的 长度 由它们之间边数表示。
 * <p>
 * 思路: DFS（这里不是光往下走，所以是左右两边最大值的和）
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

    static int res = 0;

    public static int diameterOfBinaryTree(TreeNode root) {

        dfs(root);

        return res;
    }

    private static int dfs(TreeNode root) {

        if (root == null) return 0;

        int leftDepth = dfs(root.left);
        int rightDepth = dfs(root.right);

        res = Math.max(res, leftDepth + rightDepth);

        return Math.max(leftDepth, rightDepth) + 1;
    }


    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;

        System.out.println(diameterOfBinaryTree(node1));

    }

}
