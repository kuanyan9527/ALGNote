package kuanyan.start.data_structure.binary_tree;

// 判断一棵树为二叉搜索树
// 有两种思路
// 1、得到中序数组，然后判断中序数组是否为从小到大排列 略
// 2、递归，左树的最大值小于root.val,右树的最小值大于root.val
public class SearchTree {
    static class Info {
        boolean search;
        int max;
        int min;

        public Info(boolean search, int max, int min) {
            this.search = search;
            this.max = max;
            this.min = min;
        }
    }

    public static boolean isSearchTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        return process(root).search;
    }

    public static Info process(TreeNode root) {
        if (root == null) {
            return null;
        }
        Info left = process(root.left);
        Info right = process(root.right);
        boolean isSearch;
        int max;
        int min;
        if (left == null && right == null) {
            isSearch = true;
            max = root.val;
            min = root.val;
        } else if (left == null) {
            isSearch = right.search && right.min > root.val;
            max = right.max;
            min = root.val;
        } else if (right == null) {
            isSearch = left.search && left.max < root.val;
            max = root.val;
            min = left.min;
        } else {
            isSearch = left.search && right.search && left.max < root.val && root.val < right.min;
            max = right.max;
            min = left.min;
        }
        return new Info(isSearch, max, min);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);

        t4.left = t3;
        t4.right = t5;

        t3.left = t2;
        t2.left = t1;

        t5.right = t6;

        boolean res = isSearchTree(t4);
        System.out.println(res);
    }
}
