package leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: https://leetcode-cn.com/problems/binary-tree-paths/
 * <p>
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径
 *
 * 练习：113 129
 * @author: xwy
 * @create: 10:28 AM 2020/3/12
 **/

public class Solution257 {

    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();

        if (root == null)
            return res;

        if (root.left == null && root.right == null) {
            res.add(String.valueOf(root.val));
            return res;
        }

        List<String> lefts = binaryTreePaths(root.left);
        for (String s : lefts) {
            res.add(String.valueOf(root.val) + "->" + s);
        }

        List<String> rights = binaryTreePaths(root.right);
        for (String s : rights) {
            res.add(String.valueOf(root.val) + "->" + s);
        }

        return res;
    }

}