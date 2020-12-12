package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 * @Author jiahao
 * @Date 2020/12/10 20:24
 */
public class FindDisappearedNumbers_448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums == null || nums.length <= 0 ){
            return res;
        }
        for(int i =0; i<nums.length;i++){
            if(nums[Math.abs(nums[i] - 1)] > 0){// 防止重复
                // 置为负数
                nums[Math.abs(nums[i] - 1)] = -nums[Math.abs(nums[i] - 1)];
            }
        }
        for(int i = 0;i < nums.length;i++){
            if(nums[i] > 0){
                res.add(i + 1);
            }
        }
        return res;
    }

    public void swap(int[] nums,int a,int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
