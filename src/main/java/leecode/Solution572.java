package leecode;

import xiaomage.printer.BinaryTreeInfo;
import xiaomage.printer.BinaryTrees;

/**
 * @description: https://leetcode-cn.com/problems/subtree-of-another-tree/
 * 另一个树的子树
 * @author: xwy
 * @create: 18:35 2020/10/15
 **/

public class Solution572 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null || t == null) return false;
        return postSerialize(s).contains(postSerialize(t));
    }

    //利用后序遍历的方式进行序列化
    private String postSerialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        postSerialize(root, sb);
        return sb.toString();
    }

    private void postSerialize(TreeNode root, StringBuilder sb) {
        if (root.left != null) {
            postSerialize(root.left, sb);
        } else {
            sb.append("#!");
        }
        if (root.right != null) {
            postSerialize(root.right, sb);
        } else {
            sb.append("#!");
        }
        sb.append(root.val).append("!");
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.right = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);

        BinaryTrees.println(new BinaryTreeInfo() {
            @Override
            public Object root() {
                return root;
            }

            @Override
            public Object left(Object node) {
                return ((TreeNode) node).left;
            }

            @Override
            public Object right(Object node) {
                return ((TreeNode) node).right;
            }

            @Override
            public Object string(Object node) {
                return ((TreeNode) node).val;
            }
        });

        Solution572 solution572 = new Solution572();
        System.out.println(solution572.postSerialize(root));

    }
}