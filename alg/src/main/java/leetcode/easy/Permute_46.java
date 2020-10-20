package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @Author jiahao
 * @Date 2020/10/20 21:00
 */
public class Permute_46 {
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null && nums.length <=0){
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        dfs(res,new ArrayList<>(),nums,new boolean[nums.length]);
        return res;
    }

    private void dfs(List<List<Integer>> res,List<Integer> path, int[] nums, boolean[] visited) {
        if(path.size() == nums.length){
            List<Integer> temp = new ArrayList<>(path);

            res.add(temp);
            return;
        }
        for(int i = 0;i < nums.length;i++){
            if(visited[i]){
                continue;
            }
            visited[i] = true;
            path.add(nums[i]);
            dfs(res,path,nums,visited);
            visited[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
