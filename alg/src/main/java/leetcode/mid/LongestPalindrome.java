package leetcode.mid;

/**
 * 5. 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * @Author jiahao
 * @Date 2020/9/23 19:49
 */
public class LongestPalindrome {
    // 动态规划
    public String longestPalindrome(String s) {
        if(s.length() < 1){
            return "";
        }

        if(s.length() == 1){
            return s;
        }
        // dp[i][j]用来表示 左下标i右下标j是否是回文子串
        boolean[][] dp = new boolean[s.length()][s.length()];
        // 首先初始化
        dp[0][0] = true;
        String ans = "";
        // len表示字符串的长度
        for(int len = 0;len < s.length();len++){
            // 当字符长度位 len 是，从left开始，向右扫描
            for(int left = 0; left + len < s.length();left++){
                int right = left + len;
                if(len == 0){
                    dp[left][right] = true;
                }else if(len == 1){
                    dp[left][right] = s.charAt(left) == s.charAt(right);
                }else {
                    dp[left][right] = (s.charAt(left) == s.charAt(right)) && dp[left + 1][right - 1];
                }
                if(dp[left][right] && right - left + 1 > ans.length()){
                    ans = s.substring(left,right + 1);
                }
            }
        }
        return ans;
    }
    // 方法二 中心扩展
    public String longestPalindromeV2(String s) {
        if(s.length() < 1){
            return "";
        }

        if(s.length() == 1){
            return s;
        }
        int start = 0,end=0;
        for(int i = 0;i < s.length();i++){
            int len1 = getMaxLen(s,i,i );
            int len2 = getMaxLen(s,i,i + 1);
            int len = Math.max(len1,len2);
            if(len > end - start){
                start = i - (len - 1)/2;
                end = i + len/2;
            }
        }
        return s.substring(start,end);
    }
    private int getMaxLen(String str,int left,int right){
        // 相同就向下扩展
        while (left >=0 && right < str.length() && str.charAt(left) == str.charAt(right)){
            --left;
            ++right;
        }
        return right - left - 1;
    }

}
