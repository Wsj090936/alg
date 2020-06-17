package leetcode.easy;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 *
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plus-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author jiahao
 * @Date 2020/6/16 19:30
 */
public class PlusOne {
    public static int[] plusOne(int[] digits) {
        if(digits.length <= 0){
            return new int[]{};
        }
        int curval = 0;
        int i = digits.length - 1;
        while (i >= 0){
            curval = digits[i] + 1;
            if(curval == 10){
                digits[i] = 0;
                i--;
            }else {
                digits[i] = curval;
                return digits;
            }
        }
        // 能走到这里说明超了
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;

    }

    public static void main(String[] args) {
        int[] ints = plusOne(new int[]{9, 9, 9, 9});
        System.out.println();

    }
}
