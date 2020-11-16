package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 *387. 字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 *
 *
 * 示例：
 *
 * s = "leetcode"
 * 返回 0
 *
 * s = "loveleetcode"
 * 返回 2
 *
 *
 * 提示：你可以假定该字符串只包含小写字母。
 * @Author jiahao
 * @Date 2020/11/12 20:24
 */
public class FirstUniqChar_387 {
    public int firstUniqChar(String s) {
        if(s == null || s.length() <= 0 ){
            return -1;
        }
        Map<Character,Integer> map = new HashMap<>();
        Map<Character,Integer> indexMap = new HashMap<>();
        for(int i = 0;i < s.length();i++){
            char ch = s.charAt(i);
            indexMap.putIfAbsent(ch, i);
            Integer count = map.get(ch);
            if(count == null){
                map.put(ch,1);
            }else {
                map.put(ch,++count);
            }
        }
        char cha = '#';
        for(int i = 0;i < s.length();i++){
            char ch = s.charAt(i);
            Integer count = map.get(ch);
            if(count == 1){
                cha = ch;
                break;
            }
        }
        return cha == '#' ? -1 : indexMap.get(cha);
    }
}
