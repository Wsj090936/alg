package leetcode.easy;

/**
 * 459. 重复的子字符串
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 *
 * 示例 1:
 *
 * 输入: "abab"
 *
 * 输出: True
 *
 * 解释: 可由子字符串 "ab" 重复两次构成。
 * 示例 2:
 *
 * 输入: "aba"
 *
 * 输出: False
 *
 * @Author jiahao
 * @Date 2020/12/20 13:11
 */
public class RepeatedSubstringPattern_459 {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        for(int i = 1;i * 2 <= len;i++){
            if(len % i == 0){
                boolean match = true;
                for(int j = i;j < len;j++){
                    if(s.charAt(j) != s.charAt(j - i)){
                        match = false;
                        break;
                    }
                }
                if(match){
                    return true;
                }
            }
        }
        return false;
    }
}
