package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 *数组中占比超过一半的元素称之为主要元素。给定一个整数数组，找到它的主要元素。若没有，返回-1。
 *
 * 示例 1：
 *
 * 输入：[1,2,5,9,5,9,5,5,5]
 * 输出：5
 *  
 *
 * 示例 2：
 *
 * 输入：[3,2]
 * 输出：-1
 *  
 *
 * 示例 3：
 *
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-majority-element-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author jiahao
 * @Date 2020/9/9 20:21
 */
public class MajorityElement {
    // 暴力解法 TLE
    public int majorityElement(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        if(nums.length == 1){
            return nums[0];
        }
        for(int i = 0; i< nums.length;i++){
            int num = nums[i];
            int count = 0;
            for(int j = 0; j < nums.length;j++){
                if(nums[j] == num){
                    count++;
                }
                if(count + nums.length - j < nums.length / 2){
                    break;
                }
                if(count > nums.length / 2){
                    return num;
                }
            }
        }
        return -1;
    }
    //使用Map

    public int majorityElementV2(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        if(nums.length == 1){
            return nums[0];
        }
        Map<Integer,Integer> map = new HashMap<>();
        int max = 0;
        for(int i = 0;i < nums.length;i++){
            int cur = nums[i];
            Integer curNum = map.getOrDefault(cur, 0);
            map.put(cur,++curNum);
            max = Math.max(max,map.get(cur));
            if(max > nums.length / 2){
                return cur;
            }

        }
        return -1;
    }
    // 方法三 投票法
    public int majorityElementV3(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        if(nums.length == 1){
            return nums[0];
        }
        int count = 0;
        int temp = nums[0];
        for(int each : nums){
            if(temp == each){
                count++;
            }else{
                count--;
            }
            if(count == 0){
                temp = each;
                count = 1;
            }
        }
        // 最后验证
        int half = nums.length / 2;
        count = 0;
        for(int each : nums){
            if(each == temp){
                count++;
            }
            if(count == half){
                return temp;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(1 ^ 1);
    }
}
