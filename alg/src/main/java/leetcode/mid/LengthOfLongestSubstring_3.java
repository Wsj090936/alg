package leetcode.mid;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * @Author jiahao
 * @Date 2020/9/22 21:06
 */
public class LengthOfLongestSubstring_3 {

    public static int lengthOfLongestSubstring(String s) {
        if(s == null){
            return 0;
        }
        int left = 0;
        int max = 0;
        Map<Character,Integer> map = new HashMap<>();

        for(int i = 0;i < s.length();i++){
            char cur = s.charAt(left);

            char ptr = s.charAt(i);
            map.put(ptr,map.getOrDefault(ptr,0) + 1);
            while (map.getOrDefault(ptr,0) > 1){
                // 遇到重复的就移动
                map.put(s.charAt(left),map.getOrDefault(s.charAt(left),0) - 1);
                left++;
            }

            if(i - left + 1 > max){
                max = i - left + 1;
            }

        }
        return max;
    }

    public static void main(String[] args) {
        lengthOfLongestSubstring("pwwkew");
    }
}
