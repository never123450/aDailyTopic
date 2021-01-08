package leecode.noClassify;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @description: https://leetcode-cn.com/problems/recover-binary-search-tree/
 * <p>
 * 恢复二叉搜索树
 * @author: xwy
 * @create: 6:37 上午 2020/9/15
 **/

public class Solution99 {

    // 上一次中序遍历过的节点
    private TreeNode prev;

    // 第一个错误节点
    private TreeNode first;

    // 第二个错误节点
    private TreeNode second;

    /**
     * @param root 是一颗错误的二叉搜索树(有 2 个节点被错误交换)
     */
    public void recoverTree(TreeNode root) {
        findWrongNodes(root);
        // 交换 2 个错误节点的值
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }

    // 中序遍历查找
    // 1,6,3,4,5,2,7
    // 6,3   5,2
    private void findWrongNodes(TreeNode root) {
        if (root == null) return;
        findWrongNodes(root.left);
        // 出现逆序对
        find(root);
        findWrongNodes(root.right);
    }

    private void find(TreeNode node) {
        if (prev != null && prev.val > node.val) {
            // 第二个错误节点,最后一个逆序对中较小的节点
            second = node;
            // 第一个错误节点,第一个逆序对中较大的节点
            if (first != null) return;
            first = prev;
        }
        prev = node;
    }


    // ------------------------------------------------------------------------------------------------------------------------------------------------


    public void recoverTree1(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        inOrder(root, nums);
        int[] swapped = finTwoSwaped(nums);
        swapTwo(root, swapped[0], swapped[1], swapped.length);
    }

    /**
     * 交换 2 个元素
     *
     * @param root
     * @param x
     * @param y
     * @param size
     */
    public void swapTwo(TreeNode root, int x, int y, int size) {
        if (root != null) {
            if (root.val == x || root.val == y) {
                root.val = root.val == x ? y : x;
                if (--size == 0) {
                    return;
                }
            }
            swapTwo(root.left, x, y, size);
            swapTwo(root.right, x, y, size);
        }
    }

    /**
     * 找到 2 个需要交换的元素
     *
     * @param nums
     * @return
     */
    public int[] finTwoSwaped(List<Integer> nums) {

        int x = -1, y = -1;
        // 1,6,3,4,5,2,7
        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i) > nums.get(i + 1)) {
                y = nums.get(i + 1);// 3 2
                if (x == -1) {
                    x = nums.get(i); // 6  5
                } else {
                    break;
                }
            }
        }
        return new int[]{x, y};
    }

    /**
     * 中序遍历
     *
     * @param root
     * @param nums
     */
    public void inOrder(TreeNode root, List<Integer> nums) {
        if (root == null) return;

        inOrder(root.left, nums);
        nums.add(root.val);
        inOrder(root.right, nums);
    }

    // ------------------------------------------------------------------------------------------------------------------------------------------------

    public void recoverTree2(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode x = null, y = null, pred = null;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pred != null && root.val < pred.val) {
                y = root;
                if (x == null) {
                    x = pred;
                } else {
                    break;
                }
            }
            pred = root;
            root = root.right;
        }
        swap(x, y);
    }

    private void swap(TreeNode x, TreeNode y) {
        int tmp = x.val;
        x.val = y.val;
        y.val = tmp;
    }

    // ------------------------------------------------------------------------------------------------------------------------------------------------

    // 二叉树的Morris遍历  线索二叉树
    public void recoverTree3(TreeNode root) {
        // inOrder(root); // 正常的中序遍历
        TreeNode node = root;
        while (node != null) {
            if (node.left != null) {
                // 找到前驱节点(前驱 precursor)(succeed 后继)
                TreeNode pred = node.left;
                while (pred.right != null && pred.right != node) {
                    pred = pred.right;
                }
                if (pred.right == null) {
                    pred.right = node;
                    node = node.left;
                } else { // pred.right = node;
                    //System.out.println(node.val + " ");
                    find(node);
                    pred.right = null;
                    node = node.right;
                }
            } else {
                //System.out.println(node.val + " ");
                find(node);
                node = node.right;
            }
        }
        // 交换 2 个错误节点的值
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }


}