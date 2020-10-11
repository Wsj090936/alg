package leetcode.easy;

/**
 *
 * @Author jiahao
 * @Date 2020/10/11 14:26
 */
public class ReverseBits_190 {

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        // 每次取出最后一位，将改位左移n
        for(int i = 0;i < 32;i++){
            int temp = n >> i;
            temp = temp & 1;// 取出最后一位
            res = res + (temp << (31 - i));
        }

        return res;
    }

}
