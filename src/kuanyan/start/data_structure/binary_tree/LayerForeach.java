package kuanyan.start.data_structure.binary_tree;

// 测试链接：https://leetcode.com/problems/binary-tree-level-order-traversal-ii
import java.util.*;

// 按层遍历一棵树,逆序返回
public class LayerForeach {
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

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        LinkedList<TreeNode> temp = new LinkedList<>();
        temp.push(root);
        while (temp.size() > 0) {
            List<Integer> midRes = new ArrayList<>();
            int size = temp.size();
            for (int i = 0; i < size; i++) {
                TreeNode item = temp.pop();
                midRes.add(item.val);
                if (item.left != null) {
                    temp.add(item.left);
                }
                if (item.right != null) {
                    temp.add(item.right);
                }
            }
            result.add(midRes);
        }
        Collections.reverse(result);
        return result;
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

        List<List<Integer>> lists = levelOrderBottom(t1);
        System.out.println(lists);
    }
}
