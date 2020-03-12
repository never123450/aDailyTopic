package leecode;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @description:https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 *
 * 层序遍历
 *
 * 练习：107 103 199
 *
 * @author: xwy
 * @create: 1:55 PM 2020/3/8
 **/

public class Solution102 {

    //     Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }



        return null;
    }

}