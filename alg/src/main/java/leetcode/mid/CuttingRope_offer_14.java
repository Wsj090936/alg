package leetcode.mid;

/**
 * 剑指 Offer 14- I. 剪绳子
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 示例 1：
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * 示例 2:
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 *
 * @Author jiahao
 * @Date 2021/1/23 14:44
 */
public class CuttingRope_offer_14 {
    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for(int i = 2;i <= n;i++){
            // 每次减掉j个
            for(int j = 1;j < i;j++){
                // 每次计算最大的乘积
                dp[i] = Math.max(dp[i],Math.max(j,dp[j]) * (i - j));
            }
        }
        return dp[n];

    }
    public int cuttingRopeV2(int n) {
        if(n <= 3){
            return n - 1;
        }
        long res = 1;
        int p = 1000000007;
        while (n > 4){
            // 优先减去3
            res = res * 3 % p;
            n = n - 3;
        }
        // 剩下 2 3 4
        return (int) (res * n % p);
    }
}
