package leetcode.easy;

/**
 * 121. 买卖股票的最佳时机
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意：你不能在买入股票前卖出股票。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 示例 2:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 * @Author jiahao
 * @Date 2020/9/27 20:08
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 0){
            return 0;
        }
        int min = prices[0];
        int ans = 0;
        for(int i = 0;i < prices.length;i++){
            ans = Math.max(ans,prices[i] - min);
            min = Math.min(min,prices[i]);
        }
        return ans;
    }
    public int maxProfit_V1(int[] prices) {
        if(prices == null || prices.length <= 0){
            return 0;
        }
        int minVal = prices[0];
        int ans = 0;
        for(int i = 0;i < prices.length;i++){
            minVal = Math.min(minVal,prices[i]);// 找到最小的
            ans = Math.max(ans,prices[i] - minVal);
        }
        return ans;
    }
    // 使用DP dp[i][0] = Math.max(dp[i - 1][0],dp[i - 1][1] + prices[i]);
    // dp[i][1] = Math.max(dp[i - 1][1],-prices[i]);
    public int maxProfit_dp(int[] prices){
        if(prices == null || prices.length <= 0){
            return 0;
        }
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;// 第一天不持股，收益为0
        dp[0][1] = -prices[0];// 第一天持股，收益为 -
        for(int i = 1;i < prices.length;i++){
            // 当天不持股的收益
            dp[i][0] = Math.max(dp[i - 1][0],dp[i - 1][1] + prices[i]);// 前一天不持股，和前一天买入，今天卖出的收益
            dp[i][1] = Math.max(dp[i - 1][1],-prices[i]);
        }

        return dp[prices.length - 1][0];
    }
}
