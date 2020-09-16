package leetcode.easy;

/**
 * 746. 使用最小花费爬楼梯
 * 数组的每个索引作为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
 *
 * 每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
 *
 * 您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
 *
 * 示例 1:
 *
 * 输入: cost = [10, 15, 20]
 * 输出: 15
 * 解释: 最低花费是从cost[1]开始，然后走两步即可到阶梯顶，一共花费15。
 *  示例 2:
 *
 * 输入: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * 输出: 6
 * 解释: 最低花费方式是从cost[0]开始，逐个经过那些1，跳过cost[3]，一共花费6。
 * 注意：
 *
 * cost 的长度将会在 [2, 1000]。
 * 每一个 cost[i] 将会是一个Integer类型，范围为 [0, 999]。
 * 来源：力扣
 * https://leetcode-cn.com/problems/min-cost-climbing-stairs/
 *
 * @Author jiahao
 * @Date 2020/9/16 21:01
 */
public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        if(cost == null || cost.length == 0){
            return 0;
        }
        //dp[i] 表示到达第i个台阶所消耗的最小体力(注意 次数第i个台阶还没跨过去)
        int[] dp = new int[cost.length];
        dp[0] = 0;
        dp[1] = 0;
        for(int i = 2;i < cost.length;i++){
            dp[i] =  Math.min(dp[i - 1] + cost[i - 1],dp[i - 2] + cost[i - 2]);
        }
        // 循环完后，还没结束，题目的意思是要到最后一个台阶之上，所以还要跨一次台阶
        int len = cost.length;
        int last = cost[len - 1];// 最后一个台阶消耗的体力
        int preLast = cost[len - 2];// 倒数第1个台阶消耗的体力
        // 从最后一个台阶起跳 或者 从倒数第一个台阶起跳
        return Math.min(dp[len - 1] + last,dp[len - 2] + preLast);
    }

    public static void main(String[] args) {

    }
}
