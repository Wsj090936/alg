package leetcode.mid;

/**
 * 81. 搜索旋转排序数组 II
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
 *
 * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
 *
 * 示例 1:
 *
 * 输入: nums = [2,5,6,0,0,1,2], target = 0
 * 输出: true
 * 示例 2:
 *
 * 输入: nums = [2,5,6,0,0,1,2], target = 3
 * 输出: false
 * 进阶:
 *
 * 这是 搜索旋转排序数组 的延伸题目，本题中的 nums  可能包含重复元素。
 * 这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？
 *
 * @Author jiahao
 * @Date 2020/12/1 19:43
 */
public class Search_81 {
    public static boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            while (left < right && nums[left] == nums[left + 1]){
                left++;
            }
            while (left < right && nums[right] == nums[right - 1]){
                right--;
            }
            int mid = left + (right - left)/2;
            if(nums[mid] == target){
                return true;
            }else if(nums[mid] > nums[right]){
                // 中间的比右边的大
                if(nums[mid] > target && nums[left] <= target){
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }else{
                // 中间的比左边的小
                if(nums[mid] < target && nums[right] >= target){
                    left = mid + 1;

                }else {
                    right = mid - 1;

                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,5};
        search(arr,1);
    }
}
