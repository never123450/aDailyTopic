package leecode.noClassify;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: https://leetcode-cn.com/problems/invert-binary-tree/
 * 翻转二叉树
 *
 * 练习：101 222 110
 * @author: xwy
 * @create: 11:12 AM 2020/3/11
 **/

public class Solution226 {

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

    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;

        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        root.right = left;
        root.left = right;
        return root;
    }


    public TreeNode invertTree1(TreeNode root) {
        if (root == null)
            return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode currNode = queue.poll();
            TreeNode temp = currNode.left;
            currNode.left = currNode.right;
            currNode.right = temp;
            if (currNode.left != null) queue.add(currNode.left);
            if (currNode.right != null) queue.add(currNode.right);
        }
        return root;
    }


}
