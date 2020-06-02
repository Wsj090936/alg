package leetcode.easy;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author jiahao
 * @Date 2020/6/2 19:51
 */
public class IsPalindrome {


    public static boolean isPalindrome1(int x){
        if(x < 0){
            return false;
        }
        int temp = 0;
        int nextNum = 0;
        while (x > temp) {// 遍历了一半已经可以判断出来了
            nextNum = x % 10;
            temp = temp * 10 + nextNum;
            x = x / 10;
        }
        return x == temp || x == temp/10;
    }

    public static boolean isPalindrome(int x) {
        // 首先，负数都不是回文结构
        if(x < 0){
            return false;
        }
        int origin = x;
        int temp = 0;
        int nextNum = 0;
        while (x != 0){
            nextNum = x % 10;
            temp = temp * 10 + nextNum;

            x = x / 10;
        }
        return  temp == origin;

    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(12321));
        System.out.println(isPalindrome1(12321));
    }


}
