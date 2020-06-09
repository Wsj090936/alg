package leetcode.easy;

/**
 * 实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 *
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 *
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 *
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 *
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author jiahao
 * @Date 2020/6/9 23:28
 */
public class Strstr {


    /**
     * 最坏的时间复杂度O((N-L) * L)
     * @param haystack
     * @param needle
     * @return
     */
    public static int strstr1(String haystack, String needle){
        int needLen = needle.length();
        int len = haystack.length();
        if(needLen == 0){
            return 0;
        }
        int pre = 0;
        while (pre < len - needLen +1){
            if(haystack.charAt(pre) != needle.charAt(0)){
                pre++;
            }else {
                // 首字母相同，比较后面的
                int curLen = 0;
                int cur = 0;
                while (cur < needLen && pre < len){
                    if(haystack.charAt(pre) != needle.charAt(cur)){
                        break;
                    }
                    pre++;
                    cur++;
                    curLen++;
                }
                // 循环中断时，长度相同说明找到了
                if(curLen == needLen){
                    return pre - needLen;
                }
                // 不相同，则重新来
                pre = pre - curLen + 1;// 从下一个开始找

            }
        }
        return -1;
    }

    /**
     * 最容易想到的办法时间复杂度为O((N-L) * L)
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {
        if(needle == null || needle.isEmpty()){
            return 0;
        }
        if(haystack == null || haystack.length() < needle.length()){
            return -1;
        }
        int fromIndex = 0;
        int needLen = needle.length();
        int toIndex = needLen;
        String temp;
        while (toIndex <= haystack.length()){
            temp = haystack.substring(fromIndex,toIndex);
            if(temp.equals(needle)){
                return fromIndex;
            }
            fromIndex++;
            toIndex++;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("a","a"));
        System.out.println(strstr1("hello","llo"));
    }
}
