package leecode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description: https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 * 二叉树的前序遍历
 * <p>
 * 练习：145 94 中序遍历 后序遍历   341
 * @author: xwy
 * @create: 11:21 AM 2020/3/8
 **/

public class Solution144 {

    //     Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<Integer> list = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        // 递归实现
//        this.preOrder(root);

        // 非递归实现
        this.prenonRecursion(root);
        return list;
    }

    // 非递归前序遍历
    private void prenonRecursion(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if (root == null)
            return;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    // 递归前序遍历
    private void preOrder(TreeNode node) {
        if (node != null) {
            list.add(node.val);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    // 递归后序遍历
    private void midOrder(TreeNode node) {
        if (node != null) {
            midOrder(node.left);
            midOrder(node.right);
            list.add(node.val);
        }
    }

    // 递归后序遍历
    private void midnonRecursion(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        if (node==null)
            return;
        stack.push(node);
        while (!stack.isEmpty()){
            TreeNode pop = stack.pop();

            if (node.right!=null){
                stack.push(node.right);
            }
            if (node.left!=null){
                stack.push(node.left);
            }

            list.add(0,pop.val);
        }
    }


}