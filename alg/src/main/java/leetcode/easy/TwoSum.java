package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author jiahao
 * @Date 2020/6/1 20:07
 */
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if(nums.length <= 0){
            return res;
        }
        Map<Integer,Integer> indexMap = new HashMap<>();// key : 第二个值，第一个值所在的数组的下标
        int temp = 0;
        for(int i = 0; i < nums.length; i++){
            temp = nums[i];
            Integer otherIndex = indexMap.get(temp);
            if(otherIndex != null && i != otherIndex){
                res[0] = i;
                res[1] = otherIndex;
                return res;
            }
            indexMap.put(target - temp,i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};
        int target = 9;
        int[] ints = twoSum(nums, target);
        System.out.println(ints[0]);
        System.out.println(ints[1]);
    }
}
