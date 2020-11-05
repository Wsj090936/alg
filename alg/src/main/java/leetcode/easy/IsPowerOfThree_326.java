package leetcode.easy;

/**
 *
 * @Author jiahao
 * @Date 2020/11/5 19:13
 */
public class IsPowerOfThree_326 {
    public static boolean isPowerOfThree(int n) {
        if(n < 3){
            return false;
        }
        while(n % 3 == 0){
            n = n / 3;
        }
        return n == 1;
    }

    public static void main(String[] args) {
        final boolean powerOfThree =
                isPowerOfThree(9);
        System.out.println(powerOfThree);
    }
}
