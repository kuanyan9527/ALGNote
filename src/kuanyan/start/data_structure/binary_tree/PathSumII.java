package kuanyan.start.data_structure.binary_tree;

import java.util.ArrayList;
import java.util.List;

// 测试链接：https://leetcode.com/problems/path-sum-ii
// 收集所有达标路径
public class PathSumII {
    public static List<List<Integer>> allPath = new ArrayList<>();

    public static List<Integer> copyList(List<Integer> source) {
        List<Integer> target = new ArrayList<>();
        for (int item : source) {
            target.add(item);
        }
        return target;
    }

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root != null) {
            allPath.clear(); // 这一步不能少
            List<Integer> currentPath = new ArrayList<>();
            process(root, targetSum, currentPath);
        }
        return allPath;
    }

    public static void process(TreeNode root, int targetSum, List<Integer> currentPath) {
        currentPath.add(root.val);
        if (root.left == null && root.right == null) {
            int sum = 0;
            for (int item : currentPath) {
                sum += item;
            }
            if (sum == targetSum) {
                allPath.add(copyList(currentPath));
            }
        }
        if (root.left != null) {
            process(root.left, targetSum, currentPath);
        }
        if (root.right != null) {
            process(root.right, targetSum, currentPath);
        }
        currentPath.remove(currentPath.size() - 1);
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

        int targetSum = 11;
        List<List<Integer>> lists = pathSum(t1, targetSum);
        System.out.println(lists);
    }
}
