package leetcode.mid;

/**
 * 91. 解码方法
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 *
 * 题目数据保证答案肯定是一个 32 位的整数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "12"
 * 输出：2
 * 解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2：
 *
 * 输入：s = "226"
 * 输出：3
 * 解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 * 示例 3：
 *
 * 输入：s = "0"
 * 输出：0
 * 示例 4：
 *
 * 输入：s = "1"
 * 输出：1
 * 示例 5：
 *
 * 输入：s = "2"
 * 输出：1
 *
 * @Author jiahao
 * @Date 2020/12/9 20:14
 */
public class NumDecodings_91 {
    public static int numDecodings(String s) {
        if(s == null || s.length() <= 0){
            return 0;
        }
        if(s.length() == 1 && s.charAt(0) == '0'){
            return 0;
        }
        if(s.length() == 1 ){
            return 1;
        }
        int[] dp = new int[s.length() + 1];// 第i个表示到第i个位置时 有dp[i]种解码办法
        dp[0] = 1;

        for(int i = 0;i < s.length();i++){

            // f(n) = f(n - 1) + f(n - 2);
            if(s.charAt(i) == '0'){
                // 如果当前为0
                dp[i + 1] = 0;
            }else {
                dp[i + 1] = dp[i];
            }
            if(i > 0){
                int cur = s.charAt(i) - '0';
                int pre = s.charAt(i - 1) - '0';
                if(pre == 1 || (cur <= 6 && pre == 2)){
                    dp[i + 1] += dp[i - 1];
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        numDecodings("27");
    }
}
