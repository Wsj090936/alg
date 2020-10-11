package leetcode.mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 39. 组合总和
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1：
 *
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2：
 *
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *
 * @Author jiahao
 * @Date 2020/10/11 15:26
 */
public class CombinationSum_39 {
    // 基本回溯，还可优化，先排序，记录每次累加的值，如果大于target了，直接跳出循环,进行剪枝
    public List<List<Integer>> combinationSum_39(int[] candidates, int target) {
        if(candidates == null || candidates.length <= 0){
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        dfs_39(candidates,0,new ArrayList<>(),target,res);
        return res;
    }
    private void dfs_39(int[] candidates,int start, List<Integer> temp,int target,List<List<Integer>> res){
        if(target < 0){
            return;
        }
        if(target == 0){// 说明找到了
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i = start;i < candidates.length;i++){
            temp.add(candidates[i]);
            dfs_39(candidates,i,temp,target - candidates[i],res);
            // 递归结束再移除元素
            temp.remove(temp.size() - 1);
        }
    }


    public static List<List<Integer>> combinationSum_40(int[] candidates, int target) {
        if(candidates == null || candidates.length <= 0){
            return new ArrayList<>();
        }
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        dfs_40(candidates,0,new ArrayList<>(),target,res);
        return res;
    }
    private static void dfs_40(int[] candidates,int start, List<Integer> temp,int target,List<List<Integer>> res){

        if(target < 0){
            return;
        }
        if(target == 0){// 说明找到了
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i = start;i < candidates.length;i++){
            if(i > start && candidates[i] == candidates[i - 1]){
                continue;
            }
            temp.add(candidates[i]);
            dfs_40(candidates,i + 1,temp,target - candidates[i],res);
            // 递归结束再移除元素
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] ints = {2, 5, 2, 1, 2};
        combinationSum_40(ints,5);
    }
}
