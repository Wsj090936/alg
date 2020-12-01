package leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *409. 最长回文串
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 *
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 *
 * 注意:
 * 假设字符串的长度不会超过 1010。
 *
 * 示例 1:
 *
 * 输入:
 * "abccccdd"
 *
 * 输出:
 * 7
 *
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 * @Author jiahao
 * @Date 2020/12/1 18:54
 */
public class LongestPalindrome_409 {
    public int longestPalindrome(String s) {
        if(s == null || s.isEmpty()){
            return 0;
        }
        Map<Character,Integer> map = new HashMap<>(s.length());
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            Integer num = map.getOrDefault(chars[i], 0);
            map.put(chars[i],num + 1);
        }
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        int len = 0;
        int mid = 0;
        for (Map.Entry<Character, Integer> entry : entries) {
            Integer value = entry.getValue();
            if(value % 2 == 0){
                len = len + value;
            }else {
                // 奇数的话
                len = len + value - 1;
                mid = 1;
            }
        }
        return len + mid;

    }
}
