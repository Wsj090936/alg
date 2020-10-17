package leetcode.easy;

/**
 * 204. 计数质数
 * 统计所有小于非负整数 n 的质数的数量。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 10
 * 输出：4
 * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 *
 * @Author jiahao
 * @Date 2020/10/16 20:35
 */
public class CountPrimes_204 {
    public int countPrimes(int n) {
        int count = 0;
        boolean[] sign = new boolean[n];
        for(int i = 2;i < n;i++){
            if(!sign[i]){
                count++;
                for(int j = i + i;j < n;j += i){
                    sign[j] = true;// 排除所有倍数
                }
            }
        }
        return count;
    }
}
