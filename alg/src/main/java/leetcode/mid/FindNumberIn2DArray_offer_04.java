package leetcode.mid;

/**
 * 剑指 Offer 04. 二维数组中的查找
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 *
 *
 * 示例:
 *
 * 现有矩阵 matrix 如下：
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 *
 * 给定 target = 20，返回 false。
 *
 *
 *
 * 限制：
 *
 * 0 <= n <= 1000
 *
 * 0 <= m <= 1000
 *
 * @Author jiahao
 * @Date 2021/1/18 20:29
 */
public class FindNumberIn2DArray_offer_04 {
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix == null || matrix.length <= 0 || matrix[0].length <= 0){
            return false;
        }
        int y = 0,x = matrix.length - 1;
        while (x >= 0 && y < matrix[0].length){
            int cur = matrix[x][y];
            if(cur == target){
                return true;
            }else if(cur > target){
                // 比target大 x - 1
                x = x - 1;
            }else {
                // 小 y + 1
                y = y + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr = {{-1,3}};
        System.out.println(findNumberIn2DArray(arr,3));
    }
}
