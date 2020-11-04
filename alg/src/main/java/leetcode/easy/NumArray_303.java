package leetcode.easy;

/**
 * 303. 区域和检索 - 数组不可变
 * 给定一个整数数组  nums，求出数组从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点。
 *
 * 实现 NumArray 类：
 *
 * NumArray(int[] nums) 使用数组 nums 初始化对象
 * int sumRange(int i, int j) 返回数组 nums 从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点（也就是 sum(nums[i], nums[i + 1], ... , nums[j])）
 *
 *
 * 示例：
 *
 * 输入：
 * ["NumArray", "sumRange", "sumRange", "sumRange"]
 * [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
 * 输出：
 * [null, 1, -1, -3]
 *
 * 解释：
 * NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
 * numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
 * numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1))
 * numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
 *
 *
 * 提示：
 *
 * 0 <= nums.length <= 104
 * -105 <= nums[i] <= 105
 * 0 <= i <= j < nums.length
 * 最多调用 104 次 sumRange 方法
 *
 * @Author jiahao
 * @Date 2020/11/4 20:07
 */
public class NumArray_303 {
    private int[] nums = null;
    int[] dp = null;
//    public NumArray_303(int[] nums) {
//        this.nums = nums;
//        dp = new int[nums.length][nums.length];
//        for(int i = 0;i < nums.length;i++){
//            dp[i][i] = nums[i];
//        }
//        for(int i = 0;i < nums.length;i++){
//            for(int j = i + 1;j < nums.length;j++){
//                dp[i][j] = dp[i][j - 1] + nums[j];
//            }
//        }
//    }
//
//    public int sumRange(int i, int j) {
//        return dp[i][j];
//    }

    public NumArray_303(int[] nums) {
        if(nums.length == 0){
            return;
        }
        this.nums = nums;
        dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i = 0;i < nums.length;i++){
            dp[i] = nums[i] + dp[i - 1];
        }

    }

    public int sumRange(int i, int j) {
        if(i > 0){
            return dp[j] - dp[i - 1];
        }
        return dp[j];
    }

    public static void main(String[] args) {
        int[] arr = {-2,0,3,-5,2,-1};
        NumArray_303 na = new NumArray_303(arr);
    }
}
