package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 383. 赎金信
 * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面的字符构成。如果可以构成，返回 true ；否则返回 false。
 *
 * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。)
 *
 *
 *
 * 注意：
 *
 * 你可以假设两个字符串均只含有小写字母。
 *
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 *
 * @Author jiahao
 * @Date 2020/11/11 20:52
 */
public class CanConstruct_383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length()){
            return false;
        }
        Map<Character,Integer> map = new HashMap<>();
        for(Character each : magazine.toCharArray()){
            map.put(each,map.getOrDefault(each,0) + 1);
        }
        for(Character each : ransomNote.toCharArray()){
            Integer count = map.get(each);
            if(count == null || count <=0){
                return false;
            }
            map.put(each,count - 1);
        }
        return true;
    }
}
