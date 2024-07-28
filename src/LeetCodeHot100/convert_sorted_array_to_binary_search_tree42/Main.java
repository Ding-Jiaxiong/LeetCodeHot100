package LeetCodeHot100.convert_sorted_array_to_binary_search_tree42;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 平衡 二叉搜索树。
 * <p>
 * 思路: 递归 【利用有序数组 和 二叉搜索树的关系】
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

    public static TreeNode sortedArrayToBST(int[] nums) {

        // 数组本身升序，而搜索树的特点就是左边都比根节点小，右边都比根节点大[ 像二分 ]
        // 每次都让数组中点作为根，左边所有元素作为左子树，右边同理
        if (nums.length == 0) return null;

        int mid = nums.length / 2;

        TreeNode root = new TreeNode(nums[mid]);

        root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, mid));
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums, mid + 1, nums.length));

        return root;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{-10, -3, 0, 5, 9};

        for (Integer integer : inorderTraversal(sortedArrayToBST(nums))) {
            System.out.print(integer + " ");
        }

    }

}
