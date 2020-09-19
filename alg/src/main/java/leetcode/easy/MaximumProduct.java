package leetcode.easy;

import java.util.Arrays;

/**
 * 628. 三个数的最大乘积
 * 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: 6
 * 示例 2:
 *
 * 输入: [1,2,3,4]
 * 输出: 24
 * 注意:
 *
 * 给定的整型数组长度范围是[3,104]，数组中所有的元素范围是[-1000, 1000]。
 * 输入的数组中任意三个数的乘积不会超出32位有符号整数的范围。
 *
 * @Author jiahao
 * @Date 2020/9/19 20:55
 */
public class MaximumProduct {
    public int maximumProduct(int[] nums) {

        Arrays.sort(nums);
        int len = nums.length;
        int res1 = nums[len - 1] * nums[len - 2] * nums[len - 3];//全是正数的情况或全是负数
        int res2 = nums[0] * nums[1] * nums[len - 1];// 有负数
        return Math.max(res1,res2);
    }
}
