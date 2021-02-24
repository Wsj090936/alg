package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 228. 汇总区间
 * 给定一个无重复元素的有序整数数组 nums 。
 *
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 *
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 *
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 *
 *
 * 示例 1：
 *
 * 输入：nums = [0,1,2,4,5,7]
 * 输出：["0->2","4->5","7"]
 * 解释：区间范围是：
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 * 示例 2：
 *
 * 输入：nums = [0,2,3,4,6,8,9]
 * 输出：["0","2->4","6","8->9"]
 * 解释：区间范围是：
 * [0,0] --> "0"
 * [2,4] --> "2->4"
 * [6,6] --> "6"
 * [8,9] --> "8->9"
 * 示例 3：
 *
 * 输入：nums = []
 * 输出：[]
 * 示例 4：
 *
 * 输入：nums = [-1]
 * 输出：["-1"]
 * 示例 5：
 *
 * 输入：nums = [0]
 * 输出：["0"]
 *
 * @Author jiahao
 * @Date 2021/2/24 20:20
 */
public class SummaryRanges_228 {

    public static List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if(nums == null || nums.length <= 0 ){
            return res;
        }
        if(nums.length == 1){
            res.add(nums[0] + "");
            return res;
        }
        int pre = nums[0];
        int ptr = nums[0];

        for (int num : nums) {

            int gap = num - pre;
            if(Math.abs(gap) > 1){
                // 说明区间摘到了
                if(ptr != pre){
                    res.add(String.format("%d->%d",ptr,pre));
                }else {
                    res.add("" + pre);
                }
                pre = num;
                ptr = num;
            }else {
                pre = num;
            }

        }
        if(ptr != pre){
            res.add(String.format("%d->%d",ptr,pre));
        }else {
            res.add("" + pre);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-2147483648,-2147483647,2147483647};
        summaryRanges(arr);
    }
}
