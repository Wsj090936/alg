package leetcode.easy;

/**
 * 453. 最小移动次数使数组元素相等
 * 给定一个长度为 n 的非空整数数组，找到让数组所有元素相等的最小移动次数。每次移动将会使 n - 1 个元素增加 1。
 *
 *
 *
 * 示例:
 *
 * 输入:
 * [1,2,3]
 *
 * 输出:
 * 3
 *
 * 解释:
 * 只需要3次移动（注意每次移动会增加两个元素的值）：
 *
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 *
 * @Author jiahao
 * @Date 2020/12/14 19:56
 */
public class MinMoves_453 {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        int count = 0;
        for (int num : nums) {
            count += num;
            min = Math.min(min,num);
        }
        // 所以每个元素一直减，减到和最小值相同即可
        return count - min * nums.length;

    }
}
