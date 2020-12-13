package leecode.array;


import java.util.*;

/**
 * @description: https://leetcode-cn.com/problems/contains-duplicate/
 * 数组中是否存在重复元素
 * @author: xwy
 * @create: 19:14 2020/12/13
 **/

public class Solution217 {

    // 双循环  超时
    public boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i]==nums[j]){
                    return true;
                }
            }
        }
        return false;
    }

    // 使用 hashMap
    public boolean containsDuplicate1(int[] nums) {
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])){
                return true;
            }else {
                map.put(nums[i],nums[i]);
            }
        }
        return false;
    }

    // java 流
    public boolean containsDuplicate2(int[] nums) {
        return Arrays.stream(nums).distinct().count() < nums.length;
    }

    // hashSet
    public boolean containsDuplicate3(int[] nums) {
        Set set = new HashSet();
        for(int n:nums){
            if (set.add(n)) continue;
            return true;
        }
        return false;
    }
    // 先排序,再判断相邻的是否相等
    public boolean containsDuplicate4(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution217 solution217 = new Solution217();
        int [] nums = {1,2,3,4,1};
        boolean b = solution217.containsDuplicate(nums);
        System.out.println(b);

    }
}