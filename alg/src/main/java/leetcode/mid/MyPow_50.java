package leetcode.mid;

/**
 * 50. Pow(x, n)
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 *
 * 示例 1:
 *
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 *
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 *
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 *
 * @Author jiahao
 * @Date 2020/10/27 22:29
 */
public class MyPow_50 {
    public double myPow(double x, int n) {
        if(n == 0){
            return 1;
        }
        // n是偶数，就计算x平方的 n/2 (x ^ 2) ^ n / 2;
        if(n > 0 && n % 2 == 0){
            return myPow(x * x,n / 2);
        }
        // 奇数
        if(n > 0){
            return myPow(x,n - 1) * x;
        }
        // 负数
        return 1 / myPow(x,-n);
    }
    public double myPowV2(double x, int n) {
        long N = n;
        return n > 0 ? quickMul(x,N) : 1/quickMul(x,-N);
    }
    private double quickMul(double x,long N){
        if(N == 0){
            return 1.0;
        }
        double y = quickMul(x, N / 2);
        // // n是偶数，就计算x平方的 n/2 (x ^ 2) ^ n / 2;
        return N % 2 == 0 ? y * y : y * y * x;
    }
}
