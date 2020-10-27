package leetcode.easy;

/**
 *
 *
 * @Author jiahao
 * @Date 2020/10/27 22:17
 */
public class MissingNumber_268 {
    public int missingNumber(int[] nums) {
        int res = 0;
        for(int i = 0;i < nums.length;i++){
            res ^= nums[i] ^ i;
        }
        return res;
    }
}
