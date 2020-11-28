package leetcode.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 * @Author jiahao
 * @Date 2020/11/28 13:34
 */
public class SubSets_78 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> path = new ArrayList<>();
        dfs(nums,0,path);
        return res;
    }
    public void dfs(int[] nums, int cur,List<Integer> path){
        if(cur > 0){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = cur;i < nums.length;i++){
            if(i > 0 && nums[i] == path.get(i - 1)){
                continue;
            }
            path.add(nums[i]);
            dfs(nums,i + 1,path);
            path.remove(path.size() - 1);
        }
    }
}
