package leetcode.easy;

import javax.lang.model.type.IntersectionType;
import java.net.InetAddress;
import java.util.*;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例 2:
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author jiahao
 * @Date 2020/9/8 20:46
 */
public class IntersectV2 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        int length = nums1.length;
        int length1 = nums2.length;
        if(length > length1){
            return intersect(nums2,nums1);
        }
        for(int i = 0;i < length;i++){
            int count = map.getOrDefault(nums1[i],0) + 1;
            map.put(nums1[i],count);
        }
        int[] res = new int[nums1.length];
        int index = 0;
        for(Integer each : nums2){
            Integer count = map.getOrDefault(each, 0);
            if(count > 0){
                res[index++] = each;
                count--;
                map.put(each,count);
            }
        }
        return Arrays.copyOfRange(res,0,index);
    }
}
