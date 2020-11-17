package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 *389. 找不同
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 *
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 *
 * 请找出在 t 中被添加的字母。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "abcd", t = "abcde"
 * 输出："e"
 * 解释：'e' 是那个被添加的字母。
 * 示例 2：
 *
 * 输入：s = "", t = "y"
 * 输出："y"
 * 示例 3：
 *
 * 输入：s = "a", t = "aa"
 * 输出："a"
 * 示例 4：
 *
 * 输入：s = "ae", t = "aea"
 * 输出："a"
 *
 *
 * 提示：
 *
 * 0 <= s.length <= 1000
 * t.length == s.length + 1
 * s 和 t 只包含小写字母
 * @Author jiahao
 * @Date 2020/11/17 18:32
 */
public class FindTheDifference_389 {
    // 方法一
    public char findTheDifference(String s, String t) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0;i < s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0) + 1);
        }
        for(int i = 0;i < t.length();i++){
            Integer count = map.get(t.charAt(i));
            if(count == null || count <= 0){
                return t.charAt(i);
            }
            map.put(t.charAt(i),count - 1);
        }
        return '0';
    }
    // 方法二可以用异或 相同为0，相异为1
}
