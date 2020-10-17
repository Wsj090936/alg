package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 *217. 存在重复元素
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 *
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 *
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 * @Author jiahao
 * @Date 2020/10/17 14:39
 */
public class ContainsDuplicate_217 {
    public boolean containsDuplicate(int[] nums) {
        if(nums == null || nums.length <= 0){
            return true;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for(int each : nums){
            Integer count = map.getOrDefault(each, 0);
            if(count >= 1){
                return true;
            }
            count++;
            map.put(each,count);
        }
        return false;
    }
}
