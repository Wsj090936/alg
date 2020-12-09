package leetcode.mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 90. 子集 II
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: [1,2,2]
 * 输出:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 *
 * @Author jiahao
 * @Date 2020/12/8 19:29
 */
public class SubsetsWithDup_90 {
    static List<List<Integer>> res = new ArrayList<>();
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        doSubSet(nums,new ArrayList<>(),0);
        return res;
    }
    private static void doSubSet(int[] nums,List<Integer> path,int cur){
        res.add(new ArrayList<>(path));
        for(int i = cur;i < nums.length;i++){
            System.out.println("第" + cur +"层" + i);
            System.out.println("path: " + res);

            if(i > cur && nums[i] == nums[i - 1]){
                System.out.println(path);
                continue;
            }
            path.add(nums[i]);
            doSubSet(nums,path,i + 1);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(subsetsWithDup(new int[]{1,2,2}));
    }

}
