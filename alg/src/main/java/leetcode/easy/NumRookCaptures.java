package leetcode.easy;

/**
 * 999. 可以被一步捕获的棋子数
 * 在一个 8 x 8 的棋盘上，有一个白色的车（Rook），用字符 'R' 表示。棋盘上还可能存在空方块，白色的象（Bishop）以及黑色的卒（pawn），分别用字符 '.'，'B' 和 'p' 表示。不难看出，大写字符表示的是白棋，小写字符表示的是黑棋。
 *
 * 车按国际象棋中的规则移动。东，西，南，北四个基本方向任选其一，然后一直向选定的方向移动，直到满足下列四个条件之一：
 *
 * 棋手选择主动停下来。
 * 棋子因到达棋盘的边缘而停下。
 * 棋子移动到某一方格来捕获位于该方格上敌方（黑色）的卒，停在该方格内。
 * 车不能进入/越过已经放有其他友方棋子（白色的象）的方格，停在友方棋子前。
 * 你现在可以控制车移动一次，请你统计有多少敌方的卒处于你的捕获范围内（即，可以被一步捕获的棋子数）。
 *
 * @Author jiahao
 * @Date 2020/9/20 18:58
 */
public class NumRookCaptures {

    public int numRookCaptures(char[][] board) {
        // 先找到对应的R在哪里
        int rX = 0;
        int rY = 0;
        for(int x = 0;x < 8;x++){
            for(int y = 0;y < 8;y++ ){
                if(board[x][y] == 'R'){
                    rX = x;
                    rY = y;
                    break;
                }
            }
        }
        int res = 0;
        int y = rY;
        int x = rX;
        // 向上走
        while (--x >= 0){
            if(board[x][y] == 'p'){
                res++;
                break;
            }
            if(board[x][y] == 'B'){
                break;
            }
        }
        //向下走
        y = rY;
        x = rX;
        while (++x < 8){
            if(board[x][y] == 'p'){
                res++;
                break;
            }
            if(board[x][y] == 'B'){
                break;
            }
        }
        //向左走
        y = rY;
        x = rX;
        while (--y >= 0){
            if(board[x][y] == 'p'){
                res++;
                break;
            }
            if(board[x][y] == 'B'){
                break;
            }
        }
        //向右走
        y = rY;
        x = rX;
        while (++y < 8){
            if(board[x][y] == 'p'){
                res++;
                break;
            }
            if(board[x][y] == 'B'){
                break;
            }
        }
        return res;
    }

}
