package leecode.noClassify;

/**
 *
 * @description:  https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 *
 * 练习：125  345  11
 * @author: xwy
 *
 * @create: 11:20 AM 2020/3/1
**/

public class Solution167 {
    // 时间复杂度：O(n) 空间复杂度：O(1)  对撞指针
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length-1;
        while (left<right){
            if (numbers[left] + numbers[right] == target){
                int[] sum = {left,right};
                return sum;
            }else if (numbers[left] + numbers[right] > target){
                right --;
            }else {
                left++;
            }
        }
        return null;
    }
}