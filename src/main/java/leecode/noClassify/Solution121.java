package leecode.noClassify;

/**
 * @description: https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 * <p>
 * 练习:674,63,122,123,188,714
 * 买卖股票的最佳时机
 * @author: xwy
 * @create: 4:02 下午 2020/9/10
 **/

public class Solution121 {

    /**
     * 遍历 2 次
     *
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int maxPrice = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (maxPrice < (prices[j] - prices[i])) {
                    maxPrice = prices[j] - prices[i];
                }
            }
        }
        return maxPrice;
    }

    /**
     * 遍历 1 次
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int maxPrice = 0; //前面扫描过的最大利润
        int minPrice = prices[0]; //前面扫描过的最小价格
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                // 第 i 天的股票卖出
                int profit = prices[i] - minPrice;
                maxPrice = Math.max(profit, maxPrice);
            }
        }
        return maxPrice;
    }

    /**
     * 动态规划
     * 相邻两天的差值存入数组,求最大连续相加子序列
     *
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int maxPrice = 0;


        return maxPrice;
    }

}