package leecode.binaryTree;

import leecode.noClassify.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @description: https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/submissions/
 * @author: xwy
 * @create: 22:59 2020/10/31
 **/

public class Solution129 {

    int sum = 0;

    public int sumNumbers(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traverse(root, list);
        return sum;
    }

    // 深度优先遍历
    private void traverse(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        if (root.left == null && root.right == null) {
            // 累加
            int temp = 0;
            for (Integer integer : list) {
                temp = temp * 10 + integer;
            }
            sum += temp;
        }

        if (root.left != null) {
            traverse(root.left, list);
        }
        if (root.right != null) {
            traverse(root.right, list);
        }
        list.remove(list.size() - 1);

    }


    // 深度优先遍历2
    public int sumNumbers1(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int prev) {
        if (root == null) {
            return 0;
        }
        int sum = root.val + prev * 10;
        if (root.right == null && root.left == null) {
            return sum;
        } else {
            return dfs(root.right, sum) + dfs(root.left, sum);
        }
    }

    // 广度优先遍历
    public int sumNumbers2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        Queue<Integer> numQueue = new LinkedList<Integer>();
        nodeQueue.add(root);
        numQueue.add(root.val);
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            int num = numQueue.poll();
            if (node.left == null && node.right == null) {
                sum += num;
            } else {
                if (node.right != null) {
                    nodeQueue.add(node.right);
                    numQueue.add(node.right.val + num * 10);
                }
                if (node.left != null) {
                    nodeQueue.add(node.left);
                    numQueue.add(node.left.val + num * 10);
                }
            }
        }
        return sum;
    }


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        int sum = 0;
        for (Integer integer : list) {
            sum = sum * 10 + integer;
        }
        System.out.println(sum);
    }
}