package leetcode.easy;

/**
 * 剑指 Offer 11. 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，
 * 输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
 *
 * 示例 1：
 *
 * 输入：[3,4,5,1,2]
 * 输出：1
 * 示例 2：
 *
 * 输入：[2,2,2,0,1]
 * 输出：0
 *
 * @Author jiahao
 * @Date 2021/1/23 12:59
 */
public class MinArray_offer_11 {
    public static int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        while (left != right){
            int mid = (right + left) / 2;
            int cur = numbers[mid];
            if(cur < numbers[right]){
                right = mid;
            }else if(cur > numbers[right]){
                left = mid + 1;
            }else {
                // 相等
                right--;
            }
        }
        return numbers[left];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,5};
        minArray(arr);
    }
}
