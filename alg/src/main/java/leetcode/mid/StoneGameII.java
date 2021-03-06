package leetcode.mid;

/**
 * 亚历克斯和李继续他们的石子游戏。许多堆石子 排成一行，每堆都有正整数颗石子 piles[i]。游戏以谁手中的石子最多来决出胜负。
 *
 * 亚历克斯和李轮流进行，亚历克斯先开始。最初，M = 1。
 *
 * 在每个玩家的回合中，该玩家可以拿走剩下的 前 X 堆的所有石子，其中 1 <= X <= 2M。然后，令 M = max(M, X)。
 *
 * 游戏一直持续到所有石子都被拿走。
 *
 * 假设亚历克斯和李都发挥出最佳水平，返回亚历克斯可以得到的最大数量的石头。
 *
 *  
 *
 * 示例：
 *
 * 输入：piles = [2,7,9,4,4]
 * 输出：10
 * 解释：
 * 如果亚历克斯在开始时拿走一堆石子，李拿走两堆，接着亚历克斯也拿走两堆。在这种情况下，亚历克斯可以拿到 2 + 4 + 4 = 10 颗石子。
 * 如果亚历克斯在开始时拿走两堆石子，那么李就可以拿走剩下全部三堆石子。在这种情况下，亚历克斯可以拿到 2 + 7 = 9 颗石子。
 * 所以我们返回更大的 10。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/stone-game-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author jiahao
 * @Date 2020/9/10 21:40
 */
public class StoneGameII {
    public int stoneGameII(int[] piles) {
        int len = piles.length;
        int sum = 0;
        //dp[i][j]当前石子剩余i堆时，M=j的情况下，先取的人获得的最多的石子数
        int[][] dp = new int[len + 1][len + 1];
        for(int i = len - 1;i >= 0;i++){
            sum += piles[i];
            for(int M = 1; M <= len;M++){
                // 从第i个开始拿，如果拿了2 * M个后，剩余石子堆的最小索引超了，那说明可以全拿
                if(i + 2 * M >= len){
                    dp[i][M] = sum;
                    continue;
                }
                // 如果拿不完 就计算当前 下一个人走x个后自己可以得到的石子数
                //1 <= x <= 2*M
                for(int x = 1; x <= 2*M;x++){
                    dp[i][M] = Math.max(dp[i][M],sum - dp[i + x][Math.max(M,x)]);
                }
            }

        }
        return dp[0][1];
    }

}
