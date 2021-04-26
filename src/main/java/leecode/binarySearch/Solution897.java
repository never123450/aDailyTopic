package leecode.binarySearch;

import leecode.noClassify.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: https://leetcode-cn.com/problems/increasing-order-search-tree/
 * 递增顺序搜索树
 * @projectName:dataStructure
 * @see:leecode.binarySearch
 * @author:xwy
 * @createTime:2021/4/26 21:23
 * @version:1.0
 */
public class Solution897 {
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        inorder(root,res);

        TreeNode dummyNode = new TreeNode(-1);
        TreeNode currNode = dummyNode;
        for(int value : res){
            currNode.right = new TreeNode(value);
            currNode = currNode.right;
        }
        return dummyNode.right;
    }

    public void inorder(TreeNode node,List<Integer> res){
        if (node == null){
            return;
        }
        inorder(node.left,res);
        res.add(node.val);
        inorder(node.right,res);
    }



    // 方法二：
    private TreeNode resNode;
    public TreeNode increasingBST1(TreeNode root) {
        TreeNode dummyNode = new TreeNode(-1);
        resNode = dummyNode;
        inorder1(root);
        return dummyNode.right;
    }

    public void inorder1(TreeNode node) {
        if (node == null){
            return;
        }
        inorder1(node.left);

        // 在中序遍历的过程中修改节点指向
        resNode.right = node;
        node.left = null;
        resNode = node;

        inorder1(node.right);
    }
}
