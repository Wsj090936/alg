package leetcode.mid;

import java.util.ArrayList;
import java.util.List;

/**
 *77. 组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * @Author jiahao
 * @Date 2020/11/18 19:07
 */
public class Combine_77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> resList = new ArrayList<>();

        huiSu(resList,n,k,new ArrayList<>(),1);
        return resList;
    }

    public void huiSu(List<List<Integer>> resList,int n,int k,List<Integer> path,int x){
        if(path.size() == k){
            resList.add(new ArrayList<>(path));
        }
        for(int i = x;i <= n;i++){
            path.add(x);
            huiSu(resList,n,k,path,i);
            path.remove(path.size() - 1);
        }

    }
}
