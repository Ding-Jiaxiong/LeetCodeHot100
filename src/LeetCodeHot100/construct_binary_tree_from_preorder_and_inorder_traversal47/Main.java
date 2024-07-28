package LeetCodeHot100.construct_binary_tree_from_preorder_and_inorder_traversal47;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 * <p>
 * 思路: 分治
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

    public static void post(TreeNode root, List<Integer> res) {
        if (root == null) return;

        post(root.left, res);
        post(root.right, res);
        res.add(root.val);
    }

    public static List<Integer> postorderTraversal(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<>();

        post(root, res);

        return res;
    }


    static int[] preorderstatic;
    static HashMap<Integer, Integer> dic = new HashMap<>();

    public static TreeNode buildTree(int[] preorder, int[] inorder) {

        preorderstatic = preorder;

        for (int i = 0; i < inorder.length; i++) {
            dic.put(inorder[i], i);
        }

        return recur(0, 0, inorder.length - 1);
    }

    private static TreeNode recur(int root, int left, int right) {

        if (left > right) return null;  // 递归终止

        // 建立根节点
        TreeNode node = new TreeNode(preorderstatic[root]);
        // 划分根节点、左子树、右子树
        int i = dic.get(preorderstatic[root]);
        node.left = recur(root + 1, left, i - 1);
        node.right = recur(root + i - left + 1, i + 1, right);

        return node;
    }

    public static void main(String[] args) {

        int[] pre = new int[]{3, 9, 20, 15, 7};
        int[] in = new int[]{9, 3, 15, 20, 7};

        TreeNode root = buildTree(pre, in);

        for (Integer integer : postorderTraversal(root)) {
            System.out.print(integer + " ");
        }

    }


}
