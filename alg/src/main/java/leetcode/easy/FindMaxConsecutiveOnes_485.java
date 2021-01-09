package leetcode.easy;

/**
 * 485. 最大连续1的个数
 * 给定一个二进制数组， 计算其中最大连续1的个数。
 *
 * 示例 1:
 *
 * 输入: [1,1,0,1,1,1]
 * 输出: 3
 * 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
 * 注意：
 *
 * 输入的数组只包含 0 和1。
 * 输入数组的长度是正整数，且不超过 10,000。
 *
 * @Author jiahao
 * @Date 2021/1/9 10:28
 */
public class FindMaxConsecutiveOnes_485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        if(null == nums || nums.length <= 0){
            return 0;
        }
        int res = 0;
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                // 遇到0判断大小
                res = Math.max(res,cur);
                cur = 0;
            }else {
                cur++;
            }
        }
        // 防止全是1的情况
        res = Math.max(res,cur);
        return res;
    }
}
