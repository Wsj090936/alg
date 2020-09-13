package leetcode.mid;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 47. 全排列 II
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * 示例:
 *
 * 输入: [1,1,2]
 * 输出:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author jiahao
 * @Date 2020/9/13 15:10
 */
public class PermuteUnique {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        if(nums == null && nums.length == 1){
            List<Integer> list = new ArrayList<>();
            list.add(nums[0]);
            res.add(list);
            return res;
        }
        Arrays.sort(nums);
        dfs(new ArrayList<>(),new int[nums.length],nums);


        return res;
    }

    private void dfs(List<Integer> path,int[] visited,int[] nums){
        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0;i < nums.length;i++){
            // 去重，与上次一样，看下上次用过没有这个数字，有的话就忽略
            if(i > 0 && nums[i] == nums[i - 1]&& visited[i - 1] == 1){
                continue;
            }
            if(visited[i] == 1){
                continue;
            }
            visited[i] = 1;
            path.add(nums[i]);
            dfs(path,visited,nums);
            visited[i] = 0;
            path.remove(path.size() - 1);
        }

    }
}
