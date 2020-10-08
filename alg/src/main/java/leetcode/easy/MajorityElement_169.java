package leetcode.easy;

/**
 * 169. 多数元素
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 *
 * @Author jiahao
 * @Date 2020/10/8 10:05
 */
public class MajorityElement_169 {
    public int majorityElement(int[] nums) {
        if(nums == null || nums.length < 0){
            return -1;
        }
        int count = 0;
        int res = nums[0];
        for(int i = 0;i < nums.length;i++){
            if(res == nums[i]){
                count++;
            }else {
                count--;
                if(count == 0){
                    res = nums[i];
                    count = 1;
                }
            }
        }
        return res;
    }
}
