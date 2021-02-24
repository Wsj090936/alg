package leetcode.mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *
 *
 * 示例：
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * @Author jiahao
 * @Date 2020/9/26 20:11
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length <= 0){
            return res;
        }
        Arrays.sort(nums);
        for(int i = 0;i < nums.length;i++){
            // 首先，去重
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int target = -nums[i];
            int k = nums.length - 1;

            for(int j = i + 1;j < nums.length;j++){
                // 去重
                if(j > i + 1 && nums[j] == nums[j - 1]){
                    continue;
                }
                while (j < k && nums[j] + nums[k] > target){
                    k--;
                }
                // 如果左右指针重复了  就直接跳出
                if(j == k){
                    break;
                }
                if(nums[j] + nums[k] == target){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    res.add(list);
                }

            }
        }
        return res;

    }

    public List<List<Integer>> threeSumV2(int[] nums){
        if(nums == null || nums.length <= 0){
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);
        for(int i = 0;i < nums.length;i++){
            // 去重
            if(i > 0 && nums[i - 1] == nums[i]){
                continue;
            }
            int k = nums.length - 1;
            int target = -nums[i];
            for(int j = 0;j < nums.length;j++){
                // 去重
                if(j > 0 && nums[j - 1] == nums[j]){
                    continue;
                }
                // 找相同的
                while (j < k && nums[j] + nums[k] > target){
                    k--;
                }
                if(j == k){
                    continue;
                }
                if(nums[j] + nums[k] == target){
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    list.add(k);
                    res.add(list);
                }
            }
        }
        return res;
    }

}
