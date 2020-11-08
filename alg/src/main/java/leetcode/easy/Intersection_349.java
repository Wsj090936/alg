package leetcode.easy;

import java.util.*;

/**
 * 349. 两个数组的交集
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 *
 *
 * 说明：
 *
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 *
 * @Author jiahao
 * @Date 2020/11/8 19:45
 */
public class Intersection_349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1.length <= 0 || nums2.length <=0){
            return new int[]{};
        }
        Map<Integer,Integer> map = new HashMap<>();
        for(Integer each : nums1){
            map.put(each,1);
        }
        int length = nums1.length > nums2.length ? nums1.length : nums2.length;
        int[] arr = new int[length];
        int i = 0;
        for(Integer each : nums2){

            if(map.get(each) != null){
                arr[i++] = each;
                map.remove(each);
            }
        }
        return Arrays.copyOfRange(arr,0,i - 1);
    }
}
