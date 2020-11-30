package leetcode.mid;

/**
 * 80. 删除排序数组中的重复项 II
 * 给定一个增序排列数组 nums ，你需要在 原地 删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * @Author jiahao
 * @Date 2020/11/30 20:27
 */
public class RemoveDuplicates_80 {
    // 解法1
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int index = 2;
        for(int i = 2;i < nums.length;i++){
            if(nums[i] != nums[index - 2]){
                nums[index++] = nums[i];
            }
        }
        return index + 1;
    }
    // 解法二
    public int removeDuplicatesV2(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int pre = 0;
        int count = 1;
        // 慢慢覆盖
        for(int cur = 1;cur < nums.length;cur++){
            if(nums[pre] == nums[cur]){// 这里必须要先判断
                nums[++pre] = nums[cur];
                count++;
            }else if(count >= 2){
            }else {
                count = 1;
                nums[++pre] = nums[cur];
            }
        }
        return pre + 1;
    }
}
