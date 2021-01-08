package leecode.noClassify;

/**
 * @description: leetCode 只有会员才能看这个题
 * 最大 BST子树
 * @author: xwy
 * @create: 5:49 下午 2020/9/16
 **/

public class Solution333 {

    // 递归
    private boolean isBST(TreeNode root) {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBST(TreeNode root, int min, int max) {
        if (root == null) return true;
        return min < root.val && root.val < max && isBST(root.left, min, root.val)
                && isBST(root.right, root.val, max);
    }

    private int nodesCount(TreeNode root) {
        if (root == null) return 0;
        return 1 + nodesCount(root.left) + nodesCount(root.right);
    }

    public int largestBSTSubTree1(TreeNode root) {
        if (root == null) return 0;
        if (isBST(root)) return nodesCount(root);
        return Math.max(largestBSTSubTree1(root.right), largestBSTSubTree1(root.left));
    }

    // ---------------------------------------------------------------

    /**
     * 返回以 root 为根节点的二叉树的最大 BST 子树信息
     *
     * @param root
     * @return
     */
    private Info getInfo(TreeNode root) {
        if (root == null) return null;

        // li(left info):左子树的最大 BST 子树信息
        Info li = getInfo(root.left);

        // li(right info):右子树的最大 BST 子树信息
        Info ri = getInfo(root.right);

        /*
        有 4 种情况,以 root 为根节点的二叉树就是一颗 BST ,最大BST 树就是本身
        ① li!=null && ri!=null
        && li.root = root.left && roo.val > li.max
        && ri.root == roo.right && roo.val<ri.min

        ② li!=null && ri==null
        && li.root = root.left && roo.val > li.max

        ③ li==null && ri!=null
        && ri.root == roo.right && roo.val<ri.min

        ④ li==null && ri==null
         */

        // 以 root 为根节点的二叉树就是BST
        int max = root.val, min = root.val, leftBstSize = -1, rightBstSize = -1;
        if (li == null) {
            leftBstSize = 0;
        } else if (li.root == root.left && root.val > li.max) {
            leftBstSize = li.size;
            min = li.min;
        }

        if (ri == null) {
            rightBstSize = 0;
        } else if (ri.root == root.right && root.val < ri.min) {
            rightBstSize = ri.size;
            max = ri.max;
        }

        // 以 root 为根节点的二叉树不是BST
        if (leftBstSize >= 0 && rightBstSize >= 0) {
            return new Info(root, 1 + leftBstSize + rightBstSize, max, min);
        }
        // 返回最大BST 子树的节点数量较多的那个 Info
        if (li != null && ri != null) {
            return (li.size > ri.size) ? li : ri;
        }

        return (li != null) ? li : ri;
    }

    private static class Info {
        public TreeNode root;//根节点
        public int size;//节点总数
        public int max;//最大值
        public int min;//最小值

        public Info(TreeNode root, int size, int max, int min) {
            this.root = root;
            this.size = size;
            this.max = max;
            this.min = min;
        }
    }

    public int largestBSTSubTree(TreeNode root) {
        return (root == null) ? 0 : getInfo(root).size;
    }

}