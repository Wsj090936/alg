package leetcode.easy;

/**
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * @Author jiahao
 * @Date 2020/11/1 14:07
 */
public class MoveZeroes_283 {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length <= 0){
            return;
        }
        for(int ptr = 0,cur = 0;cur < nums.length;cur++){
            if(nums[ptr] == 0){
                int temp = nums[ptr];
                nums[ptr] = nums[cur];
                nums[cur] = temp;
            }
        }
    }

    /**
     * 移动0
     * @param nums
     */
    public void moveZeroes_V2(int[] nums){
        if(nums == null || nums.length <= 0){
            return;
        }
        for(int ptr = 0,cur = 0;cur < nums.length;cur++){
            if(cur != 0){
                int remp = nums[ptr];
                nums[ptr] = nums[cur];
                nums[cur] = remp;
                ptr++;
            }
        }

    }

    public static void main(String[] args) {

    }
}
