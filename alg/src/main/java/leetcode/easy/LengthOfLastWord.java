package leetcode.easy;

/**
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
 *
 * 如果不存在最后一个单词，请返回 0 。
 *
 * 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。
 *
 *  
 *
 * 示例:
 *
 * 输入: "Hello World"
 * 输出: 5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/length-of-last-word
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author jiahao
 * @Date 2020/6/15 21:00
 */
public class LengthOfLastWord {
    /**
     * 使用内置的方法
     * @param s
     * @return
     */
    public static int lengthOfLastWord(String s) {
        if(s == null || s.isEmpty()){
            return 0;
        }
        String[] split = s.split(" ");
        if(split.length <=0){
            return 0;
        }
        return split[split.length - 1].length();
    }
    public static int lengthOfLastWordV2(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int count = 0;
        for(int i = s.length() - 1; i >= 0;i--){
            if(s.charAt(i) == ' '){
                if(count == 0){
                    continue;
                }
                break;
            }
            count++;

        }
        return count;
    }

        public static void main(String[] args) {
        String str = " ";
        String[] split = str.split(" ");
        System.out.println();
        System.out.println(lengthOfLastWord(str));
        System.out.println(lengthOfLastWordV2(str));
    }
}
