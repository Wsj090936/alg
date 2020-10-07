package leetcode.mid;

/**
 * 31. 下一个排列
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 * @Author jiahao
 * @Date 2020/10/7 18:44
 */
public class NextPermutation_31 {
    public static void nextPermutation(int[] nums) {
        if(nums == null){
            return;
        }
        int j = 0;
        for(int i = nums.length - 1;i > 0 ;i--){

            if(nums[i] > nums[i - 1]){
                int min = Integer.MAX_VALUE;
                int minIndex = -1;
                // 找到前一个比后一个大的的，就和后一个到末尾比nums[i]大的最小的元素交换
                for(int x = i; x <= nums.length - 1;x++){
                    if(nums[i - 1] < nums[x] && min >= nums[x]){
                        min = nums[x];
                        minIndex = x;
                    }
                }
                swap(nums,i - 1,minIndex);
                j = i;
                break;
            }
        }
        // 再倒叙交换
        int len = nums.length - 1;
        while (j < len){
            swap(nums,j,len);
            j++;
            len--;
        }

    }
    private static void swap(int[] nums,int a,int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,3,1,3,3};
        nextPermutation(arr);
    }
}
