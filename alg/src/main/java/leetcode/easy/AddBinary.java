package leetcode.easy;

/**
 *
 *给你两个二进制字符串，返回它们的和（用二进制表示）。
 *
 * 输入为 非空 字符串且只包含数字 1 和 0。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-binary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author jiahao
 * @Date 2020/6/16 19:54
 */
public class AddBinary {
    public static String addBinary(String a, String b) {
        // 将a和b都转化为10进制数
        return "";
    }

    private static int parseStringtoTen(String str){
        int val = 0;
        int factor = 0;
        for(int i = str.length() - 1 ;i >= 0;i--){
            val += Integer.valueOf(str.substring(i,i + 1)) * Math.pow(2,factor++);
        }
        return val;
    }

    public static void main(String[] args) {
        System.out.println(parseStringtoTen("11"));
    }
}
