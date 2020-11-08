package leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 345. 反转字符串中的元音字母
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 *
 *
 *
 * 示例 1：
 *
 * 输入："hello"
 * 输出："holle"
 * 示例 2：
 *
 * 输入："leetcode"
 * 输出："leotcede"
 *
 *
 * 提示：
 *
 * 元音字母不包含字母 "y" 。
 *
 * @Author jiahao
 * @Date 2020/11/8 19:37
 */
public class ReverseVowels_345 {
    public String reverseVowels(String s) {
        if(s == null || s.length() <= 1){
            return s;
        }
        Set<Character> vowelsSet = new HashSet<>();
        vowelsSet.add('a');
        vowelsSet.add('e');
        vowelsSet.add('i');
        vowelsSet.add('o');
        vowelsSet.add('u');
        vowelsSet.add('A');
        vowelsSet.add('E');
        vowelsSet.add('I');
        vowelsSet.add('O');
        vowelsSet.add('U');
        char[] chars = s.toCharArray();
        int i = 0;
        int r = chars.length - 1;
        while (i < r){
            if(vowelsSet.contains(chars[i]) && vowelsSet.contains(chars[r])){
                char temp = chars[i];
                chars[i] = chars[r];
                chars[r] = temp;
                i++;
                r--;
            }else {
                if(!vowelsSet.contains(chars[i])){
                    i++;
                }
                if(!vowelsSet.contains(chars[r])){
                    r--;
                }
            }
        }
        return new String(chars);
    }
}
