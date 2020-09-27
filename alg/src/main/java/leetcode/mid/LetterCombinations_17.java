package leetcode.mid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 * @Author jiahao
 * @Date 2020/9/27 22:53
 */
public class LetterCombinations_17 {
    public List<String> letterCombinations(String digits) {
        if(digits.length() <= 0){
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        DFS(digits,0,new StringBuilder(),res,phoneMap);
        return res;

    }
    private void DFS(String digits,int index,StringBuilder str,List<String> res,Map<Character,String> map){
        if(index == digits.length()) {
            res.add(str.toString());
        }else {
            char num = digits.charAt(index);
            String letters = map.get(num);
            for(int i = 0;i < letters.length();i++){
                str.append(letters.charAt(i));
                DFS(digits,index + 1,str,res,map);
                // 最后一定要删除
                str.deleteCharAt(index);
            }
        }

    }




}
