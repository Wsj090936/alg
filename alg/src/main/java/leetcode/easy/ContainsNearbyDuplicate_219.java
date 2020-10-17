package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 219. 存在重复元素 II
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * 示例 2:
 *
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 * 示例 3:
 *
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 *
 * @Author jiahao
 * @Date 2020/10/17 14:50
 */
public class ContainsNearbyDuplicate_219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < nums.length;i++){
            Integer index = map.get(nums[i]);
            if(index != null){
                if(Math.abs(index - i) <= k){
                    return true;
                }
            }else {
                map.put(nums[i],i);
            }
        }
        return false;
    }
}
