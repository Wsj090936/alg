package leetcode.mid;

/**
 * 55. 跳跃游戏
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个位置。
 *
 * 示例 1:
 *
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * 示例 2:
 *
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 *
 * @Author jiahao
 * @Date 2020/11/3 21:24
 */
public class CanJump_55 {
    public boolean canJump(int[] nums) {
        if(nums.length <= 1){
            return true;
        }
        int cur = nums[0];
        int i = 1;
        for(; cur > 0 && i < nums.length;i++){
            cur--;
            if(cur < nums[i]){
                cur = nums[i];
            }
        }
        return i == nums.length;
    }
    public boolean canJumpV2(int[] nums) {
        if(nums.length <= 1){
            return true;
        }
        int max = nums[0];
        for(int i = 1; i < nums.length - 1;i++){
            // 当走过的步长比当前小时，需要补充
            if(i < nums[i]){
                max = Math.max(max,nums[i] + i);
            }
        }
        return max > nums.length;

    }
}
