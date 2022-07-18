package kuanyan.start.data_structure.binary_tree;

// 测试链接：https://leetcode.com/problems/same-tree
// 判断两棵树是否相等
public class SameTree {
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

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        boolean isLeftSameTree = isSameTree(p.left, q.left);
        boolean isRightSameTree = isSameTree(p.right, q.right);

        return p.val == q.val && isLeftSameTree && isRightSameTree;
    }
}
