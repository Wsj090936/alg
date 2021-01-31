package leetcode.easy;

/**
 * 剑指 Offer 42. 连续子数组的最大和
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *
 * 要求时间复杂度为O(n)。
 *
 *
 *
 * 示例1:
 *
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 *
 * 提示：
 *
 * 1 <= arr.length <= 10^5
 * -100 <= arr[i] <= 100
 *
 * @Author jiahao
 * @Date 2021/1/31 15:38
 */
public class MaxSubArray_offer_42 {
    public int maxSubArray(int[] nums) {
        if(nums == null){
            return 0;
        }
        // 表示以i结尾的子数组的最大和
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for(int i = 1;i < nums.length;i++){
            dp[i] = Math.max(dp[i - 1] + nums[i],nums[i]);
            max = Math.max(max,dp[i]);
        }
        return max;
    }
    public int maxSubArray_v1(int[] nums){
        if(nums == null){
            return 0;
        }
        int preMax = 0;
        int maxValue = nums[0];
        for(int i = 0;i < nums.length;i++){
            preMax = Math.max(preMax + nums[i],nums[i]);
            maxValue = Math.max(maxValue,preMax);
        }
        return maxValue;
    }
}
