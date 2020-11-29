package leetcode.mid;

/**
 * 79. 单词搜索
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，
 * 其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 *
 *
 *
 * 示例:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 *
 *
 * 提示：
 *
 * board 和 word 中只包含大写和小写英文字母。
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 *
 * @Author jiahao
 * @Date 2020/11/29 14:17
 */
public class Exist_79 {
    public boolean exist(char[][] board, String word) {
        if(word == null || word.length() <= 0){
            return false;
        }
        // 首先，看下word的总长度，构建一个数组
        char[] wordArr = word.toCharArray();

        for(int i = 0;i < board.length;i++){
            for(int j = 0;j < board[0].length;j++){
                if(board[i][j] == wordArr[0]){
                    // 只有首字母匹配才进行寻找
                    if(doSearch(board,i,j,0,wordArr,new boolean[board.length][board[0].length])){
                        return true;
                    }
                }

            }
        }
        return false;

    }

    public boolean doSearch(char[][] board,int x,int y,int len,char[] wordArr,boolean[][] used){
        if(len == wordArr.length){
            return true;
        }
        int m = board.length;
        int n = board[0].length;
        // 使用过或者超限了
        if(x >= m || y >= n || x < 0 || y < 0 || used[x][y]){
            return false;
        }
        // 不相等，此路不通
        if(wordArr[len] != board[x][y]){
            return false;
        }
        used[x][y] = true;
        if(doSearch(board, x, y + 1, len + 1, wordArr, used)){
            return true;
        }
        if(doSearch(board, x, y - 1, len + 1, wordArr, used)){
            return true;
        }
        if(doSearch(board, x + 1, y, len + 1, wordArr, used)){
            return true;
        }
        if(doSearch(board, x - 1, y, len + 1, wordArr, used)){
            return true;
        }
        // 没有符合的
        used[x][y] = false;
        return false;
    }
}
