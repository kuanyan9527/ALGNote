package kuanyan.start.data_structure.binary_tree;

// 判断一个树是不是平衡树
// 测试链接：https://leetcode.com/problems/balanced-binary-tree
public class BalanceTree {
    static class Info {
        boolean isBalance;
        int depth;

        public Info(boolean isBalance, int depth) {
            this.isBalance = isBalance;
            this.depth = depth;
        }
    }

    public static boolean isBalanced(TreeNode root) {
        return process(root).isBalance;
    }

    public static Info process(TreeNode root) {
        if (root == null) {
            return new Info(true, 0);
        }
        Info left = process(root.left);
        Info right = process(root.right);
        boolean balanced = left.isBalance && right.isBalance && Math.abs(left.depth - right.depth) <= 1;
        int depth = Math.max(left.depth, right.depth) + 1;
        return new Info(balanced, depth);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);

        t1.left = t2;
        t1.right = t3;

        t2.left = t4;
        t2.right = t5;

        t3.right = t6;

        boolean res = isBalanced(t1);
        System.out.println(res);
    }
}
