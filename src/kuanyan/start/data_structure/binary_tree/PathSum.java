package kuanyan.start.data_structure.binary_tree;

import java.util.ArrayList;

// 判断一棵树能否组成给定的路径和
// 测试链接：https://leetcode.com/problems/path-sum
public class PathSum {
    public static boolean hasPath = false;

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        hasPath = false;
        int currentSum = 0; // 这一步必不可少
        process(root, targetSum, currentSum);
        return hasPath;
    }

    public static void process(TreeNode root, int targetSum, int currentSum) {
        if (hasPath) {
            return;
        }
        currentSum += root.val;
        if (root.left == null && root.right == null) {
            if (targetSum == currentSum) {
                hasPath = true;
            }
        }
        if (root.left != null) {
            process(root.left, targetSum, currentSum);
        }
        if (root.right != null) {
            process(root.right, targetSum, currentSum);
        }
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);

        t1.left = t4;
        t1.right = t3;

        t4.left = t6;
        t4.right = t2;

        t3.left = t5;
        t3.right = t7;

        int targetSum = 12;
        boolean b = hasPathSum(t1, targetSum);
        System.out.println(b);
    }
}
