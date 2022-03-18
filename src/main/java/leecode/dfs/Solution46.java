package leecode.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: https://leetcode-cn.com/problems/permutations/
 * 给出数组的排列组合
 * <p>
 * 回溯
 * 练习：47 39 40 216 78 90 401
 * @author: xwy
 * @create: 9:01 PM 2020/3/16
 **/

public class Solution46 {

    // ---------------------报错报错报错报错-------------------
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0)
            return output;
        used = new boolean[nums.length];
        List<Integer> p = new ArrayList<>();
        generatePermutation(nums, 0, p);
        return output;
    }

    List<List<Integer>> output = new ArrayList<>();
    boolean[] used;

    // p中保存了一个有index个元素的排列
    // 向这个排列的末尾添加第index+1个元素，获得一个有index+1个元素的排列
    void generatePermutation(int[] nums, int index, List<Integer> p) {
        if (index == nums.length) {
            // 保存s
            output.add(p);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                // 将nums[i] 放入p中
                p.add(nums[i]);
                used[i] = true;
                generatePermutation(nums, index + 1, p);
                //p.remove(new Integer(nums[i]));
                used[i] = false;
            }
        }
    }

    // --------------------------------------------------
    private List<List<Integer>> list;
    private int[] nums;
    //    private List<Integer> result;
    private boolean[] used1;
    private int[] result;

    public List<List<Integer>> permute1(int[] nums) {
        if (nums == null) return null;
        list = new ArrayList<>();
//        result = new ArrayList<>();
        result = new int[nums.length];
        used1 = new boolean[nums.length];
        if (nums.length == 0) return list;
        this.nums = nums;
        dfs(0);
        return list;
    }

    private void dfs(int i) {
        // 不能继续往下搜索
        if (i == nums.length) {
            List<Integer> resultList = new ArrayList<>();
//            list.add(new ArrayList<>(result));
            for (int value : result) {
                resultList.add(value);
            }
            list.add(resultList);
            return;
        }

        // 枚举这一层所有可以做的选择
        for (int j = 0; j < nums.length; j++) {
            if (used1[j]) continue;
            result[i] = nums[j];
            used1[j] = true;
            dfs(i + 1);
            used1[j] = false;
        }
    }

    // --------------------------------------------------
    // 值利用一个数组,反复交换位置
    // 0号位置分别和 0,1,2 号位置进行交换    让 1 号位置分别和1,2 号位置进行交换   让 2 号位置和 2 号位置进行交换
    public List<List<Integer>> permute2(int[] nums) {
        if (nums == null) return null;
        list = new ArrayList<>();
        result = new int[nums.length];
        used1 = new boolean[nums.length];
        if (nums.length == 0) return list;
        this.nums = nums;
        dfs1(0);
        return list;
    }

    private void dfs1(int idx) {
        if (idx == nums.length) {
            List<Integer> resultList = new ArrayList<>();
            for (int value : nums) {
                resultList.add(value);
            }
            list.add(resultList);
            return;
        }

        // 枚举这一层所有可以做出的选择
        for (int i = idx; i < nums.length; i++) {
            // 保证一个数字在ids位置只会出现一次
            if (isRepeat(nums, idx, i)) continue;
            swap(idx, i);
            dfs1(idx + 1);
            swap(idx, i);
        }
    }

    private boolean isRepeat(int[] nums, int idx, int i) {
        for (int j = idx; j < i; j++) {
            if (nums[j] == nums[i]) return true;
        }
        return false;
    }

    private void swap(int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    private List<Integer> result1;

    private void dfs11(int idx) {
        if (idx == nums.length) {
            list.add(new ArrayList<>(result1));
            return;
        }
        //枚举这一层所有可以做出的选择
        for (int i = 0; i < nums.length; i++) {
            if (result1.contains(nums[i])) continue;
            result1.add(nums[i]);
            dfs(idx + 1);
            result1.remove(result1.size() - 1);
        }
    }


    public static void main(String[] args) {
        Solution46 solution46 = new Solution46();
        List<List<Integer>> lists = solution46.permute2(new int[]{1, 2, 3});
        System.out.println(lists);
    }

}