package leetcode.mid;

/**
 * 29. 两数相除
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 *
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 *
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 *
 *
 *
 * @Author jiahao
 * @Date 2020/10/7 18:10
 */
public class Divide_29 {
    public static int divide(int dividend, int divisor) {
        if(dividend == 0){
            return 0;
        }
        if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }

        boolean negative = (dividend ^ divisor) < 0;
        // 确定符号后，变正运算
        long divi = Math.abs((long) dividend);
        long divis = Math.abs((long) divisor);
        int res = 0;
        // 限制最大的数为 2^31
        for(int i = 31; i >= 0;i--){
            // 右移动，每次和除数比较,注意 某个数右移2的n次方，如果某个数n很小，结果是0
            long temp = divi >> i;
            if((divi >> i) >= divis){
                res += 1 << i; // 加上 2 ^ n
                // 减小被除数
                divi -= divis << i;
            }
        }
        return negative ? -res : res;

    }

    public static void main(String[] args) {


//        System.out.println(divide(-2147483648,1));
        System.out.println(Integer.MAX_VALUE);
    }
}
