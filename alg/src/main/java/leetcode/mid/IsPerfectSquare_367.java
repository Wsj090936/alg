package leetcode.mid;

/**
 * 367. 有效的完全平方数
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 *
 * 说明：不要使用任何内置的库函数，如  sqrt。
 *
 * 示例 1：
 *
 * 输入：16
 * 输出：True
 * 示例 2：
 *
 * 输入：14
 * 输出：False
 *
 * @Author jiahao
 * @Date 2020/11/10 20:18
 */
public class IsPerfectSquare_367 {
    public static boolean isPerfectSquare(int num) {
        if(num <= 1){
            return true;
        }
//        int left = 0;
//        int right = num;
//        while (right - left > 1){
//            int mid = (left + right) / 2;
//            if(mid * mid >= num){
//                right = mid;
//            }else {
//                left = mid;
//            }
//        }
//        return left * left == num && right * right == num;
        long left = 0;
        long right = num;
        while (left <= right) {
            long mid = (left + right) / 2;
            if(mid * mid == num){
                return true;
            }else if(mid * mid > num){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        isPerfectSquare(16);
    }
}
