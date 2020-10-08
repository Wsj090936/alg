package leetcode.mid;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 *
 * @Author jiahao
 * @Date 2020/10/8 11:04
 */
public class SearchRange_34 {
    // 最优解
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1,-1};
        if(nums == null || nums.length <= 0){
            return res;
        }
        if(nums.length == 1 && target == nums[0]){
            res[0] = 0;
            res[1] = 0;
            return res;
        }
        int l = 0;
        int r = nums.length;// 注意这里
        // 确定左边界
        while (l < r) {
            int mid = (l + r) / 2;
            if(nums[mid] >= target){
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        if(nums[l] != target){
            return res;
        }
        res[0] = l;
        r = nums.length - 1;
        // 确定右边界
        while (l < r){
            int mid = (l + r) / 2;
//            if(nums[mid] <= target){
//                l = mid + 1;
//            }else {
//                r = mid;
//            }
            if(nums[mid] >= target){
                l = mid;
            }else {
                r = mid - 1;
            }
        }
        res[1] = r;
        return res;
    }
    public int[] searchRangeV2(int[] nums, int target) {
        int[] res = new int[]{-1,-1};
        if(nums == null || nums.length <= 0){
            return res;
        }
        int l = 0;
        int r = nums.length - 1;
        while (l < r){
            int mid = (l + r) / 2;
            if(nums[mid] > target){
                r = mid - 1;
            }else if(nums[mid] < target){
                l = mid + 1;
            }else{
                while (nums[l] != target) l++;
                while (nums[r] != target) r--;
                return new int[]{l,r};
            }
        }
        return res;

    }
}
