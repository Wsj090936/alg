package leetcode.mid;

/**
 * 43. 字符串相乘
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 示例 1:
 *
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 *
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 *
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 *
 * @Author jiahao
 * @Date 2021/2/24 20:42
 */
public class Multiply_43 {
    public static String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        if(num1.equals("1")){
            return num2;
        }
        if(num2.equals("1")){
            return num1;
        }
        int m = num1.length();
        int n = num2.length();
        int[] res = new int[num1.length() + num2.length()];
        for(int i = m - 1;i >=0;i--){
            int x = num1.charAt(i) - '0';
            for(int j = n - 1;j >= 0;j--){
                int y = num2.charAt(j) - '0';
                res[i + j + 1] += x * y;// 存储每一位乘积
            }
        }
        // 累计求和
        for(int i = res.length - 1;i > 0;i++){
            res[i - 1] += res[i] / 10;
            res[i] = res[i] % 10;
        }
        int index = res[0] == 0 ? 1 : 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (index < m + n){
            stringBuilder.append(res[index]);
            index++;
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        multiply("2","3");
    }
}
