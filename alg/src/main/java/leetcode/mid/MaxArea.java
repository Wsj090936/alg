package leetcode.mid;

/**
 * 11. 盛最多水的容器
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，
 * 使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 *
 *
 *
 *
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *
 *
 *
 * 示例：
 *
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 *
 * @Author jiahao
 * @Date 2020/9/24 20:54
 */
public class MaxArea {

    public static int maxAreaV2(int[] height) {
        int res = 0;
        int i = 0;
        int j = height.length - 1;
        while (i <= j){
            // 先计算大小
            res = Math.max(res,(j - i) * Math.min(height[i],height[j]));
            // 再判断该移动那个
            if(height[i] < height[j]){
                // 移动小的
                i++;
            }else {
                j--;
            }
        }
        return res;
    }

    // 暴力法，能过，但是效率不高
    public static int maxArea(int[] height) {
        int res = 0;
        for(int i = 0;i < height.length;i++){
            int cur = height[i];
            int curMax = 0;
            for(int j = i + 1;j < height.length;j++){
                // 先找出最大的那个
                    curMax = height[j];
                // 每次计算最大值
                res = Math.max(res,(j - i) * Math.min(curMax,cur));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        maxAreaV2(new int[]{1,8,6,2,5,4,8,3,7});
    }
}
