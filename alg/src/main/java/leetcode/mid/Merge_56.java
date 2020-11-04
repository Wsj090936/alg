package leetcode.mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 *56. 合并区间
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 *
 *
 * 示例 1:
 *
 * 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 *
 * 输入: intervals = [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * 注意：输入类型已于2019年4月15日更改。 请重置默认代码定义以获取新方法签名。
 *
 *
 *
 * 提示：
 *
 * intervals[i][0] <= intervals[i][1]
 * @Author jiahao
 * @Date 2020/11/4 20:32
 */
public class Merge_56 {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                return Integer.compare(o1[0],o2[1]);
            }
        });

        int i = 0;
        int len = intervals.length;
        List<int[]> res = new ArrayList<>();
        while (i < len){
            int left = intervals[i][0];
            int right = intervals[i][1];
            while (i < len - 1 && right >= intervals[i + 1][1]){
                right = Math.max(right,intervals[i + 1][1]);
            }
            i++;
            res.add(new int[]{left,right});
        }
        return res.toArray(new int[res.size()][2]);
    }
}
