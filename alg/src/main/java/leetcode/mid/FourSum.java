package leetcode.mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 四数之和
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：
 *
 * 答案中不可以包含重复的四元组。
 *
 * 示例：
 *
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 *
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 *
 * @Author jiahao
 * @Date 2020/9/28 21:58
 */
public class FourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length <= 0){
            return res;
        }
        Arrays.sort(nums);
        for(int i = 0;i < nums.length - 3;i++){
            // 区重复
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            // 再次剪枝叶
            if(nums[i] + 3 * nums[i + 1] > target){
                break;
            }
            // 剪枝 递增的
            if(nums[i] + 3 * nums[nums.length - 1] < target){
                continue;
            }
            for(int j = i + 1;j < nums.length - 2;j++){
                // 先去重
                if(j > i + 1 && nums[j] == nums[j - 1]){
                    continue;
                }
                // 剪
                if(nums[i] + nums[j] + 2 * nums[j + 1] > target){
                    break;
                }
                // 剪
                if(nums[i] + nums[j] + 2 * nums[nums.length - 1] < target){
                    continue;
                }
                int left = j + 1;
                int right = nums.length - 1;
                // 开始循环判断
                while (left < right){
                    if(nums[left] + nums[i] + nums[j] + nums[right] == target){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[left]);
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[right]);
                        res.add(list);
                        left++;
                        right--;
                        // 再次去重
                        while (left < right && nums[left] == nums[left - 1]){
                            left++;
                        }
                        // 去重
                        while (left < right && nums[right] == nums[right + 1]){
                            right--;
                        }
                    }
                    if(nums[left] + nums[i] + nums[j] + nums[right] > target){
                        right--;
                    }
                    if(nums[left] + nums[i] + nums[j] + nums[right] < target){
                        left++;
                    }
                }
            }

        }
        return res;

    }

    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{1, 0, -1, 0, -2, 2},0));
    }
}
