package leetcode.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例 2:
 *
 * 输入:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 * 通过次数88,275提交次数213,253
 *
 * @Author jiahao
 * @Date 2020/11/1 15:17
 */
public class SpiralOrder_54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length <= 0){
            return new ArrayList<>();
        }
        int left = 0;// 左边界
        int right = matrix[0].length - 1;// 右边界
        int top = 0;// 上边界
        int land = matrix.length - 1;// 下边界;
        List<Integer> res = new ArrayList<>();
        while (true){
            // 从左到右，不过界
            for(int y = left,x = top;y <= right;y++){
                res.add(matrix[x][y]);
            }
            // 上边界下降
            if(++top > land) break;
            // 从上到下
            for(int x = top,y = right;x <= land;x++){
                res.add(matrix[x][y]);
            }
            // 右边界变动
            if(--right < left) break;
            // 从右到左
            for(int x = land,y = right; y >= left;y--){
                res.add(matrix[x][y]);
            }
            // 下边界变动
            if(--land < top) break;

            // 从下到上\
            for(int x = land,y = left;x >= top;x--){
                res.add(matrix[x][y]);
            }
            // 左边界变动

            if(++left > right){
                break;
            }
        }
        return res;
    }

}
