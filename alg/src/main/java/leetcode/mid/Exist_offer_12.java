package leetcode.mid;

/**
 * 剑指 Offer 12. 矩阵中的路径
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 *
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 *
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 *
 *
 *
 * 示例 1：
 *
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 *
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 *
 * @Author jiahao
 * @Date 2021/1/23 13:28
 */
public class Exist_offer_12 {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for(int j = 0;j < board[0].length;j++){
                if(board[i][j] == word.charAt(0)){
                    // 首字母符合才走下去
                    if(DFS(board,new boolean[board.length][board[0].length],i,j,word,0)){
                        return true;
                    }
                }

            }
        }
        return false;
    }

    private boolean DFS(char[][] board, boolean[][] visited, int x,int y, String target,int index){
        if(index == target.length()){
            return true;
        }
        if(x < 0 || x > board.length || y < 0 || y > board[0].length){
            return false;
        }
        // 访问过就不能再访问了
        if(visited[x][y]){
            return false;
        }

        if(target.charAt(index) != board[x][y]){
            return false;
        }
        // 可以走下去
        visited[x][y] = true;
        boolean res = DFS(board,visited,x - 1,y,target,index + 1) ||
                        DFS(board,visited,x + 1,y,target,index + 1) ||
                        DFS(board, visited, x, y - 1, target, index + 1) ||
                        DFS(board, visited, x, y + 1, target, index + 1 );
        visited[x][y] = false;
        return res;

    }
}
