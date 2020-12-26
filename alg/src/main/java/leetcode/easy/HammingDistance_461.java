package leetcode.easy;

/**
 * 461. 汉明距离
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 *
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 *
 * 注意：
 * 0 ≤ x, y < 231.
 *
 * 示例:
 *
 * 输入: x = 1, y = 4
 *
 * 输出: 2
 *
 * 解释:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 *
 * 上面的箭头指出了对应二进制位不同的位置。
 *
 * @Author jiahao
 * @Date 2020/12/26 21:11
 */
public class HammingDistance_461 {
    public int hammingDistance(int x, int y) {
        int n = x ^ y;
        // 异或之后，如果最右边是1的 就说明有一个位置不一样的
        int res = 0;
        while (n != 0){
            if(n % 2 == 1){
                res++;
            }
            n = n >> 1;
        }
        return res;
    }
}
