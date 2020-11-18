package leetcode.easy;

/**
 *
 * @Author jiahao
 * @Date 2020/11/18 18:36
 */
public class IsSubsequence_392 {

    public boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;
        while (i < s.length() && j < t.length()){
            if(s.charAt(i) == t.charAt(j)){
                i++;
                j++;
            }else {
                j++;
            }
        }
        return i == s.length();
    }
}
