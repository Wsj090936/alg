package leetcode.mid;

import java.util.ArrayList;
import java.util.List;

/**
 *22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *
 *
 * 示例：
 *
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 * @Author jiahao
 * @Date 2020/9/29 22:16
 */
public class GenerateParenthesis_22 {
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        if(n <= 0){
            return new ArrayList<>();
        }
        dfs(n,n,"");
        return res;
    }
    private void dfs(int left,int right,String str){
        if(left == 0 && right == 0){
            res.add(str);
            return;
        }
        if(left > 0){
            dfs(left - 1,right,str + "(");
        }
        if(right > left){
            dfs(left,right - 1,str + ")");
        }
    }
}
