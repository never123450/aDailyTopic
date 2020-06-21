package leecode.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @description: 二叉树的最大深度
 *
 * @author: xwy
 *
 * @create: 10:06 AM 2020/3/11
**/

public class Solution104 {

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


    // 递归
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return (Math.max(maxDepth(root.left), maxDepth(root.right))) + 1;
    }

    // BSF
    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int depth = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            depth++;
            for (int i = 0; i < queue.size(); i++) {
                TreeNode temp = queue.poll();
                if (temp.left != null){
                    queue.add(temp.left);
                }
                if (temp.right != null){
                    queue.add(temp.right);
                }
            }
        }
        return depth;
    }

}