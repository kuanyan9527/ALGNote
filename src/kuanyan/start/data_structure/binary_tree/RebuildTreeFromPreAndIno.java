package kuanyan.start.data_structure.binary_tree;

import java.util.Arrays;

//测试链接：https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
// 根据先序数组和中序数组重建一棵树
public class RebuildTreeFromPreAndIno {
    private static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }
        return process(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public static TreeNode process(int[]preorder, int l1, int r1, int[] inorder, int l2, int r2) {
        if (l1 > r1) {
            return null;
        }
        int rootValue = preorder[l1];
        TreeNode root = new TreeNode(rootValue);
        int find = 0;
        while (inorder[find] != rootValue) {
            find++;
        }
        root.left = process(preorder, l1 + 1, l1 + find - l2, inorder, l2, find - 1);
        root.right = process(preorder, l1 + find - l2 + 1, r1, inorder, find + 1, r2);
        return root;
    }

    public static void main(String[] args) {
        int[] pre = { 1, 2, 4, 5, 3 };
        int[] ino = { 4, 5, 2, 1, 3 };

        TreeNode tree = buildTree(pre, ino);
        System.out.println(tree);
    }
}
