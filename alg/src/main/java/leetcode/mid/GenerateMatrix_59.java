package leetcode.mid;

/**
 * 59. 螺旋矩阵 II
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 *
 * 示例:
 *
 * 输入: 3
 * 输出:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 *
 * @Author jiahao
 * @Date 2020/11/4 21:01
 */
public class GenerateMatrix_59 {
    public int[][] generateMatrix(int n) {
        if(n == 1){
            return new int[][]{{1}};
        }
        int[][] res = new int[n][n];
        int num = 1;
        int left = 0;
        int right = res[0].length - 1;
        int top = 0;
        int land = res[0].length - 1;
        while (true){
            // 从左到右
            for(int x = top,y = left;y <= right;y++){
                res[x][y] = num;
                num++;
            }
            if(++top > land){
                break;
            }
            // 从上到下
            for(int x = top,y = right;x <= land;x--){
                res[x][y] = num;
                num++;
            }
            if(--right < left){
                break;
            }
            // 从右到左
            for(int x = land,y = right;y >= left;y--){
                res[x][y] = num;
                num++;
            }
            if(--land < top){
                break;
            }
            // 从下到上
            for(int x = land,y = left;x >= top;x--){
                res[x][y] = num;
                num++;
            }
            if(++left > right){
                break;
            }
        }
        return res;

    }
}
