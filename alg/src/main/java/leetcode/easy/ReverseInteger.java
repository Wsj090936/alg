package leetcode.easy;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author jiahao
 * @Date 2020/6/1 21:34
 */
public class ReverseInteger {

    public static int reverse1(int x){
        int res = 0;
        int nextNum = 0;
        while (x != 0){
            nextNum = x % 10;
            if(res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && nextNum > Integer.MAX_VALUE % 10)){
                return 0;
            }
            if(res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && nextNum < Integer.MIN_VALUE % 10)){
                return 0;
            }
            res = res * 10 + nextNum;
            x = x / 10;
        }
        return res;
    }

    /**
     * 普通解法需要用long类型
     * @param x
     * @return
     */
    public static int reverse(int x) {

        Long res = 0L;
        int nextNum = 0;
        while (x != 0){
            nextNum = x%10;
            res = res * 10 + nextNum;// 每次增大10倍
            if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE){
                return 0;
            }
            x = x/10;
        }
        return res.intValue();
    }

    public static void main(String[] args) {
        System.out.println(reverse(1234567899));
        System.out.println(reverse1(1234567));
    }
}
