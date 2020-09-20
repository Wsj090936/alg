package leetcode.mid;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * 1090. 受标签影响的最大值
 * 我们有一个项的集合，其中第 i 项的值为 values[i]，标签为 labels[i]。
 *
 * 我们从这些项中选出一个子集 S，这样一来：
 *
 * |S| <= num_wanted
 * 对于任意的标签 L，子集 S 中标签为 L 的项的数目总满足 <= use_limit。
 * 返回子集 S 的最大可能的 和。
 *
 *
 *
 * 示例 1：
 *
 * 输入：values = [5,4,3,2,1], labels = [1,1,2,2,3], num_wanted = 3, use_limit = 1
 * 输出：9
 * 解释：选出的子集是第一项，第三项和第五项。
 * 示例 2：
 *
 * 输入：values = [5,4,3,2,1], labels = [1,3,3,3,2], num_wanted = 3, use_limit = 2
 * 输出：12
 * 解释：选出的子集是第一项，第二项和第三项。
 *
 * @Author jiahao
 * @Date 2020/9/20 19:32
 */
public class LargestValsFromLabels {
    public static int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        Map<Integer,Integer> labCount = new HashMap<>();
        // 初始化标签的个数
        for (int label : labels) {
            labCount.put(label,0);
        }
        int len = values.length;
        int[][] valueAndLabel = new int[len][2];// 第一个存值，第二个存标签
        for(int i = 0;i < len;i++){
            valueAndLabel[i][0] = values[i];
            valueAndLabel[i][1] = labels[i];
        }
        // 倒叙排序，每次取最大的
        Arrays.sort(valueAndLabel,  (o1,o2) -> o2[0] - o1[0]);
        // 取的时候，取的数个数不能超过num_wanted，而且label限制正在use_limit个
        int res = 0;
        int nowNum = 0;
        for (int[] each : valueAndLabel) {
            int label = each[1];
            Integer count = labCount.get(label);
            if(count >= use_limit){
                continue;
            }
            // 开始取
            res += each[0];
            labCount.put(label,count + 1);
            ++nowNum;
            if(nowNum == num_wanted ){
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        int[] label = {1,1,2,2,3};
        largestValsFromLabels(arr,label,3,1);
        System.out.println();
    }
}
