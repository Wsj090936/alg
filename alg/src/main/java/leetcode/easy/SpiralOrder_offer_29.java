package leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 剑指 Offer 29. 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 *
 *
 *
 * 示例 1：
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 *
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * @Author jiahao
 * @Date 2021/1/24 16:11
 */
public class SpiralOrder_offer_29 {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix == null){
            return new int[]{};
        }
        // 左边界
        int left = 0;
        // 右边界
        int right = matrix[0].length - 1;
        // 上边界
        int top = 0;
        // 下边界
        int land = matrix.length - 1;
        int[] res = new int[matrix.length * matrix[0].length];
        int count = 0;
        while (true){
            // 从左到右
            for(int x = top,y = left;y <= right;y++){
                res[count] = matrix[x][y];
                count++;
            }
            // 上边界下移动
            if(++top > land){
                break;
            }
            // 从上到下
            for(int x = top,y = right; x <= land;x++){
                res[count] = matrix[x][y];
                count++;
            }
            if(--right < left){
                break;
            }
            // 从右到左
            for (int x = land,y = right;y >= left;y--){
                res[count] = matrix[x][y];
                count++;
            }
            // 下边界上移
            if(--land < top){
                break;
            }
            // 从下到上
            for (int x = land,y = left;x >= top;x--){
                res[count] = matrix[x][y];
                count++;
            }
            if(++left > right){
                break;
            }
        }
        return res;

    }
}
