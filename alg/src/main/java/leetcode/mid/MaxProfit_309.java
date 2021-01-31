package leetcode.mid;

/**
 * 309. 最佳买卖股票时机含冷冻期
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 *
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 示例:
 *
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 *
 * @Author jiahao
 * @Date 2021/1/31 13:53
 */
public class MaxProfit_309 {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 0){
            return 0;
        }
        int[][] dp = new int[prices.length][3];

        dp[0][0] = 0;// 当天结束时，不持有股票。处于冷冻期 的收益
        dp[0][1] = 0;// 不持有股票，并且不在冷冻期
        dp[0][2] = -prices[0];// 目前持有一致股票，累计的最大收益
        for(int i = 1;i < prices.length;i++){
            dp[i][0] = dp[i - 1][2] + prices[i];// 当前不持有股票处于冷冻期 = 前一天有股票。今天卖出
            dp[i][1] = Math.max(dp[i - 1][0],dp[i - 1][1]);// 当前不持有股票。不再冷冻期 = 前一天不持有，在冷冻期 / 前一天不持有股票，不再冷冻期
            dp[i][2] = Math.max(dp[i - 1][2],dp[i - 1][1] - prices[i]);// 收益 = 前一天持有的累计收益 / 前一天不持有，今天买入
        }
        return Math.max(dp[prices.length - 1][0],dp[prices.length - 1][1]);
    }
}
