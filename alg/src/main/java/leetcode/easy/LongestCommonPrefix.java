package leetcode.easy;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author jiahao
 * @Date 2020/6/8 19:50
 */
public class LongestCommonPrefix {

    /**
     * 只要有一个单词，与其他单词的首字母不相同，就可以任务他们的最长前缀不存在
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs){
        if(strs == null ||  strs.length == 0){
            return "";
        }
        String pre = strs[0];
        String now = null;
        for (int i = 1; i < strs.length;i++){
            now = strs[i];
            int j = 0;
            for (; j < pre.length() && j < now.length();j++){
                if(pre.charAt(j) != now.charAt(j)){
                    break;
                }
            }
            // 截取最长前缀
            pre = strs[i].substring(0,j);
            if(pre.length() == 0){
               return "";
            }
        }
        return pre;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"ab","cbc","a"};
        System.out.println(longestCommonPrefix(strs));
    }
}
