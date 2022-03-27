package leecode.binaryTree;

import leecode.noClassify.TreeNode;

import java.util.*;

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


    /**
     * @param
     * @param root
     * @return java.util.List<java.lang.Integer>
     * @Description 前序遍历，非递归，使用栈
     * @author xwy
     * @date 27/3/2022 下午6:03
     */
    public List<Integer> midnonRecursion5(leecode.noClassify.TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<leecode.noClassify.TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                res.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return res;
    }


}