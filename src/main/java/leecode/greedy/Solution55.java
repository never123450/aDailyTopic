package leecode.greedy;

/**
 * @param
 * @author xwy
 * @Description https://leetcode.cn/problems/jump-game/
 * 跳跃游戏
 * @date 2022-07-22 下午4:03
 * @return
 */
public class Solution55 {
    public static void main(String[] args) {
        Solution55 solution55 = new Solution55();
//        int nums[] = new int[]{0,2,3};
//        int nums[] = new int[]{3, 0, 8, 2, 0, 0, 1};
//        int nums[] = new int[]{1,1,1,0};
        int[] nums = new int[]{2, 3, 1, 1, 4};
        boolean b = solution55.canJump(nums);
        System.out.println(b);
    }

    public boolean canJump(int[] nums) {
        int cover = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= cover) {
                cover = Math.max(nums[i] + i, cover);
                if (nums.length - 1 <= cover) {
                    return true;
                }
            }
        }
        return false;
    }
}
