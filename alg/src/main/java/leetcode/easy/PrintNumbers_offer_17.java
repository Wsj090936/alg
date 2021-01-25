package leetcode.easy;

/**
 * 剑指 Offer 17. 打印从1到最大的n位数
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 *
 * 示例 1:
 *
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 *
 * @Author jiahao
 * @Date 2021/1/24 11:04
 */
public class PrintNumbers_offer_17 {
    public int[] printNumbers(int n) {
        int max = 9;
        for(int i = 1;i < n;i++){
            max = max * 10 + 9;
        }
        int[] res = new int[max];
        for (int i = 1;i <= max;i++){
            res[i - 1] = i;
        }
        return res;

    }
}
