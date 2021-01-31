package leetcode.easy;

/**
 * 122. 买卖股票的最佳时机 II
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 *
 * @Author jiahao
 * @Date 2020/9/28 21:29
 */
public class MaxProfit_122 {

    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 0){
            return 0;
        }
        int res = 0;
        // 只要后一天比前一天大，就卖出
        for(int i = 1;i < prices.length;i++){
            if(prices[i] > prices[i - 1]){
                res += prices[i] - prices[i - 1];
            }
        }
        return res;
    }

    // DP
    public int maxProfit_V2(int[] prices) {
        if(prices == null || prices.length <= 0){
            return 0;
        }
        int res = 0;
        int[][] dp = new int[prices.length][2];
        // 当天结束，不持有股票的收益
        dp[0][0] = 0;
        // 当天结束，持有一只股票的收益
        dp[0][1] = -prices[0];
        for(int i = 1;i < prices.length;i++){
            // i天结束，不持有股票的收益 = 前一天不持有股票的收益 / 前一天持有股票，在i天卖出
            dp[i][0] = Math.max(dp[i - 1][0],dp[i - 1][1] + prices[i]);
            // i天结束，持有股票的收益 = 前一天结束时持有股票 / 前一天不持有股票(已经卖出) ，并且今天买入

            dp[i][1] = Math.max(dp[i - 1][1],dp[i - 1][0] - prices[i]);
        }
        return res;
    }


}
