package leetcode.easy;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author jiahao
 * @Date 2020/6/15 20:48
 */
public class MaxSubArray {
    public static int maxSubArray(int[] nums) {
        // 每次保存上一个以i结尾的最大子数组和
        int pre = 0;
        int maxValue = nums[0];
        for(int each : nums){
            pre = Math.max(pre + each,each);
            maxValue = Math.max(maxValue,pre);
        }
        return maxValue;

    }
    public static int maxSubArrayV2(int[] nums){
        int pre = 0;
        int maxValue = nums[0];
        for(int each : nums){
            // 加起来比自己都小，说明断了
            if(pre + each < each){
                pre = each;
            }else{
                pre = pre + each;
            }
            if(pre > maxValue){
                maxValue = pre;
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(arr));
    }
}
