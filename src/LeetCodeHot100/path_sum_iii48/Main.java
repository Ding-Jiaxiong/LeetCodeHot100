package LeetCodeHot100.path_sum_iii48;

/**
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 * <p>
 * 思路: DFS 深度优先搜索
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

    public static int pathSum(TreeNode root, long targetSum) {

        if (root == null) return 0;

        int res = rootSum(root, targetSum);

        res += pathSum(root.left, targetSum);
        res += pathSum(root.right, targetSum);

        return res;
    }

    private static int rootSum(TreeNode root, long targetSum) {

        int res = 0;

        if (root == null) return 0;

        int val = root.val;
        if (val == targetSum) {
            res++;
        }

        res += rootSum(root.left, targetSum - val);
        res += rootSum(root.right, targetSum - val);

        return res;

    }


    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(-3);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(11);
        TreeNode node7 = new TreeNode(3);
        TreeNode node8 = new TreeNode(-2);
        TreeNode node9 = new TreeNode(1);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        node4.left = node7;
        node4.right = node8;
        node5.right = node9;

        int k = 8;

        System.out.println(pathSum(node1, k));

    }

}
