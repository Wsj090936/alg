package leetcode.easy;

/**
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 *
 *
 *
 * 示例：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 *
 * @Author jiahao
 * @Date 2021/1/24 11:35
 */
public class Exchange_offer_21 {
    public int[] exchange(int[] nums) {
        if(nums == null || nums.length <= 0){
            return nums;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            // 当前为奇数
            if(nums[left] % 2 == 1){
                // 右边为偶数
                if(nums[right] % 2 == 0){
                    left++;
                    right--;
                }else {
                    // 右边为奇数 找到一个偶数换过去
                    left++;
                }
            }else {
                // 左边为偶数 右边也为偶数
                if(nums[right] % 2 == 0){
                    right--;
                }else {
                    // 右边为奇数
                    swap(nums,left++,right--);
                }
            }
        }
        return nums;

    }
    private void swap(int[] arr ,int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
