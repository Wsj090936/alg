package leetcode.mid;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 *  
 *
 * 示例：
 *
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *  
 *
 * 提示：
 *
 * 3 <= nums.length <= 10^3
 * -10^3 <= nums[i] <= 10^3
 * -10^4 <= target <= 10^4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author jiahao
 * @Date 2020/9/27 20:47
 */
public class ThreeSumClosest {
    /**
     * 思路 ：
     *      排序，
     *      先选取第一个数，然后用双指针选取当前数的下一个，依次对比每一次的大小
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length <= 0){
            return 0;
        }
        Arrays.sort(nums);
        int closeNUm = nums[0] + nums[1] + nums[2];
        for (int i = 0;i < nums.length - 2;i++){
            int l = i + 1;// 当前数的下一个
            int r = nums.length - 1;// 最后一个
            while (l < r){
                int num = nums[i] + nums[l] + nums[r];
                // 当前加起来比上一次小，就选当前的和
                if(Math.abs(num - target) < Math.abs(closeNUm - target)){
                    closeNUm = num;
                }
                if(num > target){
                    r--;
                }else if(num < target){
                    l++;
                }else {
                    return closeNUm;
                }
            }
        }
        return closeNUm;
    }
}
