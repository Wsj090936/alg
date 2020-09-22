package leetcode.easy;

/**
 * 88. 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 *
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *
 *
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 *
 * @Author jiahao
 * @Date 2020/9/22 18:37
 */
public class MergeArr_86 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m == 0){
            for(int i = 0;i < nums2.length;i++){
                nums1[i] = nums2[i];
            }
            return;
        }
        int last = m + n - 1;
        int curNum1 = m - 1;
        int ptrNum2 = n - 1;
        int n1 = curNum1;
        while (ptrNum2 >= 0 && curNum1 >= 0){
            int num1 = nums1[curNum1];
            int num2 = nums2[ptrNum2];
            // 比较大小 2 比1 大将2放到最后一个位置 移动下一个下标
            if(num2 >= num1){
                nums1[last] = num2;
                last--;
                ptrNum2--;
            }else if(num2 < num1){
                // num2小于num1
                nums1[last] = num1;
                last--;
                curNum1--;
            }
        }
        // 说明没有用完
        if(ptrNum2 >= 0){
            for(int i = 0;i <= ptrNum2;i++){
                nums1[i] = nums2[i];
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        /**
         * [1,2,3,0,0,0]
         * 3
         * [2,5,6]
         * 3
         */
        int[] nums1 = {4,0,0,0,0,0};
        int[] nums2 = {1,2,3,5,6};
        merge(nums1,1,nums2,5);
        System.out.println();

    }
}
