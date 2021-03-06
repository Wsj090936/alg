package leetcode.mid;

/**
 * 64. 最小路径和
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例:
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 *
 * @Author jiahao
 * @Date 2020/11/8 19:56
 */
public class MinPathSum_64 {
    public int minPathSum(int[][] grid) {
        if(grid == null){
            return 0;
        }
        int[][] dp = new int[grid.length][grid[0].length];
        // 每次只能向下或者向右
        dp[0][0] = grid[0][0];
        // 第一列
        for(int i = 1;i < grid.length;i++){
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }
        // 第一行
        for(int i = 1;i < grid[0].length;i++){
            dp[0][i] = grid[0][i] + dp[0][i - 1];
        }
        for(int i = 1;i < grid.length;i++){
            for(int j = 1;j < grid[0].length;j++){
                dp[i][j] = Math.min(dp[i][j - 1] + grid[i][j],dp[i - 1][j] + grid[i][j]);
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }
}
