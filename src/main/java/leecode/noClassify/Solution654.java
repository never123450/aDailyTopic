package leecode.noClassify;

import java.util.Arrays;
import java.util.Stack;

/**
 * @description: https://leetcode-cn.com/problems/maximum-binary-tree/
 * 最大二叉树
 * @author: xwy
 * @create: 21:35 2020/10/14
 **/

public class Solution654 {
    // 递归
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null) return null;
        return findRoot(nums, 0, nums.length);
    }

    private TreeNode findRoot(int[] nums, int l, int r) {
        if (l == r) return null;
        // 找到[l,r)范围内的最大值的索引
        int maxIdx = l;
        for (int i = l + 1; i < r; i++) {
            if (nums[i] > nums[maxIdx]) maxIdx = i;
        }
        TreeNode root = new TreeNode(nums[maxIdx]);
        root.left = findRoot(nums, l, maxIdx);
        root.right = findRoot(nums, maxIdx + 1, r);
        return root;
    }

    // 变种: 返回一个数组:数组里面存放着每个节点的父节点的索引(如果没有父节点,就存-1)
    // 同种题目 Solution739
    // 利用栈
    public int[] constructMaximumBinaryTree1(int[] nums) {

        // 1.扫描一遍所有的元素 2.保持栈从栈底到栈顶是单调递减的

        int[] lis = new int[nums.length];
        int[] ris = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            ris[i] = -1;
            lis[i] = -1;
        }
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                ris[stack.pop()] = i;
            }
            lis[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        System.out.println(Arrays.toString(lis));
        System.out.println(Arrays.toString(ris));

        int[] pis = new int[nums.length];
        for (int i = 0; i < pis.length; i++) {
            if (lis[i] == -1 && ris[i] == -1) {
                pis[i] = -1;
                continue;
            }
            if (lis[i] == -1) {
                pis[i] = ris[i];
            } else if (ris[i] == -1) {
                pis[i] = lis[i];
            } else if (nums[lis[i]] < nums[ris[i]]) {
                pis[i] = lis[i];
            } else {
                pis[i] = ris[i];
            }
        }
        return pis;
    }

    public static void main(String[] args) {
        Solution654 solution654 = new Solution654();
        int[] nums = {3, 2, 1, 0, 6, 5};
        int[] ints = solution654.constructMaximumBinaryTree1(nums);
        System.out.println(Arrays.toString(ints));
    }

}