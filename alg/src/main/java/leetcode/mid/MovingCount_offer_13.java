package leetcode.mid;

import java.beans.Visibility;

/**
 * 剑指 Offer 13. 机器人的运动范围
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 *
 *
 * 示例 1：
 *
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 2：
 *
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 * @Author jiahao
 * @Date 2021/1/23 13:59
 */
public class MovingCount_offer_13 {
    public int movingCount(int m, int n, int k) {
        return DFS(m,n,0,0,k,new boolean[m][n]);
    }

    public int DFS(int m ,int n ,int x ,int y ,int k,boolean[][] visited){
        if(x < 0 || y < 0 || x > m - 1 || y > n - 1 || visited[x][y]){
            return 0;
        }
        if(x / 10 + x % 10 + y / 10 + y % 10 > k){
            return 0;
        }
        visited[x][y] = true;

        int res = 1 +  DFS(m,n,x - 1,y ,k,visited) +
                DFS(m,n,x + 1,y,k,visited)
                + DFS(m,n,x,y - 1,k,visited) +
                DFS(m,n,x,y + 1,k,visited);
//        visited[x][y] = false;
        return res;
    }
}
