package leetcode.mid;

/**
 *36. 有效的数独
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 *
 *
 * 上图是一个部分填充的有效的数独。
 *
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   ["5","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: true
 * @Author jiahao
 * @Date 2020/10/11 15:09
 */
public class IsValidSudoku_36 {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];// row[i][num] 表示第i行 num这个数字是否出现
        boolean[][] col = new boolean[9][9];// 同上，列
        boolean[][] sqr = new boolean[9][9];// 面积 3 * 3 sqr[i][num] 表示第ige 3*3 区域，num是否出现过
        for(int i = 0;i < board.length;i ++){
            for(int j = 0;j < board[0].length;j++){
                if(board[i][j] == '.'){
                    continue;
                }
                int num = board[i][j] - '1';
                if(row[i][num]){// 判断该行这个数字是否出现过
                    return false;
                }
                row[i][num] = true;
                if(col[j][num]){
                    return false;
                }
                col[j][num] = true;
                int sqrNum = i / 3 * 3 + j / 3;
                if(sqr[sqrNum][num]){
                    return false;
                }
                sqr[sqrNum][num] = true;
            }
        }
        return true;
    }
}
