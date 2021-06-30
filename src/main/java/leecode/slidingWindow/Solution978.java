package leecode.slidingWindow;

/**
 * @description: https://leetcode-cn.com/problems/longest-turbulent-subarray/
 * 最长湍流子数组
 * @author: xwy
 * @create: 18:27 2021/2/8
 **/

public class Solution978 {

    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        int ret = 1;
        int left = 0, right = 0;

        while (right < n - 1) {
            if (left == right) {
                if (arr[left] == arr[left + 1]) {
                    left++;
                }
                right++;
            } else {
                if (arr[right - 1] < arr[right] && arr[right] > arr[right + 1]) {
                    right++;
                } else if (arr[right - 1] > arr[right] && arr[right] < arr[right + 1]) {
                    right++;
                } else {
                    left = right;
                }
            }
            ret = Math.max(ret, right - left + 1);
        }
        return ret;
    }


    public int maxTurbulenceSize1(int[] arr) {
        int len = arr.length;
        if (len < 2) {
            return len;
        }

        int left = 0;
        int right = 1;
        boolean pre = arr[left] < arr[right];
        int res = 1;

        while (right + 1 < len) {
            boolean current = arr[right] < arr[right + 1];
            if (pre != current) {
                res = Math.max(res, right - left + 1);
            } else {
                left = right;
            }
            right++;
            pre = current;
        }

        return res ;
    }

    /**
     * 动态规划
     *
     * 记 dp[i][0]dp[i][0] 为以 arr[i]arr[i] 结尾，且 arr[i-1] > arr[i]arr[i−1]>arr[i] 的「湍流子数组」的最大长度；dp[i][1]dp[i][1] 为以 arr[i]arr[i] 结尾，且 arr[i-1] < arr[i]arr[i−1]<arr[i] 的「湍流子数组」的最大长度。
     *
     * 显然，以下标 00 结尾的「湍流子数组」的最大长度为 11，因此边界情况为 dp[0][0]=dp[0][1]=1dp[0][0]=dp[0][1]=1。
     *
     * 当 i>0i>0 时，考虑 arr[i-1]arr[i−1] 和 arr[i]arr[i] 之间的大小关系：
     *
     * 如果 arr[i-1]>arr[i]arr[i−1]>arr[i]，则如果以下标 i-1i−1 结尾的子数组是「湍流子数组」，应满足 i-1=0i−1=0，或者当 i-1>0i−1>0 时 arr[i-2] < arr[i-1]arr[i−2]<arr[i−1]，因此 dp[i][0]=dp[i-1][1]+1dp[i][0]=dp[i−1][1]+1，dp[i][1]=1dp[i][1]=1；
     *
     * 如果 arr[i-1]<arr[i]arr[i−1]<arr[i]，则如果以下标 i-1i−1 结尾的子数组是「湍流子数组」，应满足 i-1=0i−1=0，或者当 i-1>0i−1>0 时 arr[i-2] > arr[i-1]arr[i−2]>arr[i−1]，因此 dp[i][0]=1dp[i][0]=1，dp[i][1]=dp[i-1][0]+1dp[i][1]=dp[i−1][0]+1；
     *
     * 如果 arr[i-1]=arr[i]arr[i−1]=arr[i]，则 arr[i-1]arr[i−1] 和 arr[i]arr[i] 不能同时出现在同一个湍流子数组中，因此 dp[i][0]=dp[i][1]=1dp[i][0]=dp[i][1]=1。
     *
     * 最终，dp 数组的最大值即为所求的答案。
     *
     * @param arr
     * @return
     */
    public int maxTurbulenceSize2(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][2];
        dp[0][0] = dp[0][1] = 1;
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i][1] = 1;
            if (arr[i - 1] > arr[i]) {
                dp[i][0] = dp[i - 1][1] + 1;
            } else if (arr[i - 1] < arr[i]) {
                dp[i][1] = dp[i - 1][0] + 1;
            }
        }

        int ret = 1;
        for (int i = 0; i < n; i++) {
            ret = Math.max(ret, dp[i][0]);
            ret = Math.max(ret, dp[i][1]);
        }
        return ret;
    }


    public static void main(String[] args) {
        Solution978 solution978 = new Solution978();
        int[] arr = {9, 4, 2, 10, 7, 8, 8, 1, 9};
        System.out.println(solution978.maxTurbulenceSize2(arr));
    }

}