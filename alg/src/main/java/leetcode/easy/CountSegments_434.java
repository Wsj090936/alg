package leetcode.easy;

/**
 * 434. 字符串中的单词数
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 *
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 *
 * 示例:
 *
 * 输入: "Hello, my name is John"
 * 输出: 5
 * 解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
 *
 * @Author jiahao
 * @Date 2020/12/8 19:25
 */
public class CountSegments_434 {
    public int countSegments(String s) {
        String[] split = s.split(" ");
        int res = 0;
        for (String s1 : split) {
            if(s1.equals(" ") || s1.isEmpty()){
                continue;
            }
            res++;
        }
        return res;
    }
}
