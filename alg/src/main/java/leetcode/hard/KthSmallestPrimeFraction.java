package leetcode.hard;

import java.util.Arrays;

/**
 * 786. 第 K 个最小的素数分数
 *一个已排序好的表 A，其包含 1 和其他一些素数.  当列表中的每一个 p<q 时，我们可以构造一个分数 p/q 。
 *
 * 那么第 k 个最小的分数是多少呢?  以整数数组的形式返回你的答案, 这里 answer[0] = p 且 answer[1] = q.
 *
 * 示例:
 * 输入: A = [1, 2, 3, 5], K = 3
 * 输出: [2, 5]
 * 解释:
 * 已构造好的分数,排序后如下所示:
 * 1/5, 1/3, 2/5, 1/2, 3/5, 2/3.
 * 很明显第三个最小的分数是 2/5.
 *
 * 输入: A = [1, 7], K = 1
 * 输出: [1, 7]
 * 注意:
 *
 * A 长度的取值范围在 2 — 2000.
 * 每个 A[i] 的值在 1 —30000.
 * K 取值范围为 1 —A.length * (A.length - 1) / 2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/k-th-smallest-prime-fraction
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author jiahao
 * @Date 2020/8/30 11:01
 */
public class KthSmallestPrimeFraction {
    public static int[] kthSmallestPrimeFraction(int[] arr, int k) {
        double low = 0;// 低位
        double high = 1;// 高位
        int[] ans = new int[]{0,1};
        while (high - low > 1e-9){
            double mid = high - (high - low)/2;
            // 找出当前区间内的分数 x,使得 小于x的分数恰好有k个，并记录最大的分数，这就是结果
            int[] res = under(mid,arr);
            if(res[0] < k){
                low = mid;
            }else {// 如果小于x的分数大于等于K，就添加值
                ans[0] = res[1];// 分子
                ans[1] = res[2];// 分母
                high = mid;
            }
        }
        return ans;
    }
    private static int[] under(double mid,int[] arr){
        int fenzi = 0;// 分子
        int fenmu = 1;// 分母
        int count = 0;
        int i = -1;
        for(int j = 1; j < arr.length;j++){
            // 找出最大的i，使得 arr[i] / arr[j] < mid
            while (arr[i + 1]  < mid *  arr[j]) ++i;
            count += i + 1;// 小于mid的分数个数
            if(i >= 0 && fenzi * arr[j] < fenmu * arr[i]){
                // 如果新的分子除以分母 大于 旧的分子除以分母，就替换
                fenzi = arr[i];
                fenmu = arr[j];
            }
        }
        return new int[]{count,fenzi,fenmu};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(kthSmallestPrimeFraction(new int[]{1, 2, 3, 5}, 3)));
    }
}
