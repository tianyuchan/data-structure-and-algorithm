package search.dfs;

import java.util.*;

/**
 * @Classname : BinaryTreePaths
 * @Description : 257. 二叉树的所有路径
 * https://leetcode.cn/problems/binary-tree-paths/
 * @Author : chentianyu
 * @Date 2022/9/19 23:35
 */


public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        LinkedList<String> path = new LinkedList<>();
        dfs(ans, path, root);
        return ans;
    }

    // 深度优先搜索
    private void dfs(List<String> ans, LinkedList<String> path, TreeNode root) {
        if (root == null) return;

        LinkedList<String> curPath = new LinkedList<>(path);
        curPath.add(root.val + "");

        if (root.left == null && root.right == null) {
            ans.add(String.join("->", curPath));
        }
        dfs(ans, curPath, root.left);
        dfs(ans, curPath, root.right);
    }


    // 回溯法
    private void backTracking(List<String> ans, LinkedList<String> path, TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            path.addLast(root.val + "");
            ans.add(String.join("->", path));
            path.removeLast();
            return;
        }
        path.addLast(root.val + "");
        backTracking(ans, path, root.left);
        backTracking(ans, path, root.right);
        path.removeLast();
    }

    class TreeNode {
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
}
