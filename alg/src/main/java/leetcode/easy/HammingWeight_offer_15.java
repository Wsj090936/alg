package leetcode.easy;

/**
 * TODO
 *
 * @Author jiahao
 * @Date 2021/1/23 19:01
 */
public class HammingWeight_offer_15 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0){
            res += n & 1;
            n = n >>> 1;
        }
        return res;
    }
}
