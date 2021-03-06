package leetcode.easy;

/**
 *414. 第三大的数
 * 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
 *
 * 示例 1:
 *
 * 输入: [3, 2, 1]
 *
 * 输出: 1
 *
 * 解释: 第三大的数是 1.
 * 示例 2:
 *
 * 输入: [1, 2]
 *
 * 输出: 2
 *
 * 解释: 第三大的数不存在, 所以返回最大的数 2 .
 * 示例 3:
 *
 * 输入: [2, 2, 3, 1]
 *
 * 输出: 1
 *
 * 解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。
 * 存在两个值为2的数，它们都排第二。
 * @Author jiahao
 * @Date 2020/12/5 13:28
 */
public class ThirdMax_414 {
    public int thirdMax(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[0],nums[1]);
        }
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        int flag = 0;
        boolean f = true;
        for (int num : nums) {
            if(num == Integer.MIN_VALUE && f){
                flag++;
                f = false;
            }
            if(num > max1){
                // 比第一个大
                // 第二个最大的变为第三个最大的
                max3 = max2;
                max2 = max1;
                max1 = num;
                flag++;
            }else if(num > max2 && num < max1){
                // 第二个最大的变为第三个最大的
                max3 = max2;
                max2 = num;
                flag++;
            }else if(num > max3 && num < max2){
                max3 = num;
                flag++;
            }
        }
        return flag >=3 ? max3 : max1;
    }
}
