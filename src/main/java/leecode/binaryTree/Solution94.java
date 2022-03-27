package leecode.binaryTree;

import leecode.noClassify.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * 94. 二叉树的中序遍历
 * @projectName:dataStructure
 * @see:leecode.binaryTree
 * @author:xwy
 * @createTime:27/3/2022 下午5:33
 * @version:1.0
 */
public class Solution94 {
    /**
     * @param
     * @param root
     * @return java.util.List<java.lang.Integer>
     * @Description 非递归，使用栈
     * @author xwy
     * @date 27/3/2022 下午6:03
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return res;
    }

    /**
     * @param
     * @param root
     * @return java.util.List<java.lang.Integer>
     * @Description 使用递归
     * @author xwy
     * @date 27/3/2022 下午6:06
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    private void inorder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }
}
