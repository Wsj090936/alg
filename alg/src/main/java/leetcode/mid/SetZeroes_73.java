package leetcode.mid;

/**
 * 73. 矩阵置零
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 * 示例 2:
 *
 * 输入:
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * 输出:
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 * 进阶:
 *
 * 一个直接的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个常数空间的解决方案吗？
 *
 * @Author jiahao
 * @Date 2020/11/11 21:03
 */
public class SetZeroes_73 {
    // 空间复杂度O(n + m)
    public static void setZeroes(int[][] matrix) {
        // 标记每行是否需要被标记为0
        boolean[] rowMark = new boolean[matrix.length];
        // 标记每一列是否需要被标记为0
        boolean[] colMark = new boolean[matrix[0].length];
        for(int i = 0;i < matrix.length;i++){
            for(int j = 0;j < matrix[0].length;j++){
                if(matrix[i][j] == 0){
                    rowMark[i] = true;
                    colMark[j] = true;
                }
            }
        }
        // 将行置为0
        for(int row = 0;row < rowMark.length;row++){
            if(rowMark[row]){
                // 将这一行置为0
                for(int j = 0;j < matrix[row].length;j++){
                    matrix[row][j] = 0;
                }
            }
        }
        // 将列置为0
        for(int col = 0;col < colMark.length;col++){
            if(colMark[col]){
                // 将这一列置为0
                for(int i = 0;i < matrix.length;i++){
                    matrix[i][col] = 0;
                }
            }
        }
    }
    // 空间复杂度 O(1)
    public static void setZeroesV2(int[][] matrix) {
        // 标记第一列是否需要被标记为0
        boolean colNeedZero = false;
        for(int i = 0;i < matrix.length;i++){
            if(matrix[i][0] == 0){
                colNeedZero = true;
                break;
            }
        }
        // 标记第一行是否需要被标记为0
        boolean rowNeedZero = false;
        for(int j = 0;j < matrix[0].length;j++){
            if(matrix[0][j] == 0){
                rowNeedZero = true;
                break;
            }
        }
        for(int i = 0;i < matrix.length;i++){
            for(int j = 0;j < matrix[0].length;j++){
                if(matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for(int i = 1;i < matrix.length;i++){
            if(matrix[i][0] == 0){
                // 将这一行全都设置为0
                for(int j  = 0;j < matrix[i].length;j++){
                    matrix[i][j] = 0;
                }
            }
        }
        for(int i = 1;i < matrix[0].length;i++){
            if(matrix[0][i] == 0){
                // 将这一列全都设置为0
                for(int j  = 0;j < matrix.length;j++){
                    matrix[j][i] = 0;
                }
            }
        }
        // 设置第一行和第一列
        if(colNeedZero){
            for(int i = 0;i < matrix.length;i++){
                matrix[i][0] = 0;
            }
        }
        if(rowNeedZero){
            for(int j = 0;j < matrix[0].length;j++){
                matrix[0][j] = 0;
            }
        }



    }

    public static void main(String[] args) {
        int[][] ma = new int[3][4];
        ma[0] = new int[]{0,1,2,0};
        ma[1] = new int[]{3,4,5,2};
        ma[2] = new int[]{1,3,1,5};
        setZeroes(ma);
    }
}
