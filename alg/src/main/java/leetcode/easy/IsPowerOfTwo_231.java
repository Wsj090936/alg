package leetcode.easy;

/**
 *
 * @Author jiahao
 * @Date 2020/10/21 22:09
 */
public class IsPowerOfTwo_231 {
    public boolean isPowerOfTwo(int n) {
        int tmp = 1;
        for(int i = 0;i < 31;i++){
            if(tmp == n){
                return true;
            }
            tmp <<= 1;
        }
        return false;
    }
}
