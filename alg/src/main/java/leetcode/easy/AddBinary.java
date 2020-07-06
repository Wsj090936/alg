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
        int i = a.length() - 1;
        int j = b.length() - 1;
        int pre = 0;// 进位
        StringBuilder sb = new StringBuilder();
        while (i >= 0 && j >= 0){
            int sum = pre;
            sum += a.charAt(i--) - '0';// - '0' 得到的是他的int值
            sum += b.charAt(j--) - '0';
            pre = sum / 2;// 2 / 2 = 1 用来判断有没有进位
            sb.append(sum % 2);
        }
        // a多了
        while (i >= 0){
            int sum = pre + a.charAt(i--) - '0';
            pre = sum / 2;
            sb.append(sum % 2);
        }
        // b多了
        while (j >= 0){
            int sum = pre + b.charAt(j--) - '0';
            pre = sum / 2;
            sb.append(sum % 2);
        }
        // 有进位
        if(pre == 1){
            sb.append(pre);
        }
        return sb.reverse().toString();
    }

//    private static int parseStringtoTen(String str){
//        int val = 0;
//        int factor = 0;
//        for(int i = str.length() - 1 ;i >= 0;i--){
//            val += Integer.valueOf(str.substring(i,i + 1)) * Math.pow(2,factor++);
//        }
//        return val;
//    }
//    private static String parseTenToBinary(int num){
//        if(num == 0){
//            return "0";
//        }
//        String res = "";
//        int pre = 0;
//        while (num > 0){
//            pre = num % 2;
//            num /= 2;
//            res = pre + res;
//        }
//        return res;
//    }

    public static void main(String[] args) {
        System.out.println(addBinary("10","10"));
    }
}
