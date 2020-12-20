package leetcode.mid;

import leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @Author jiahao
 * @Date 2020/12/20 13:47
 */
public class GenerateTrees_95 {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new ArrayList<>();
        if(n == 0){
            return res;
        }
        return dfs(1,n);
    }
    private List<TreeNode> dfs(int left, int r){
        List<TreeNode> list = new ArrayList<>();
        if(left > r){
            list.add(null);
            return list;
        }
        for(int i = left;i <= r;i++){
            // 根节点为i 左子树
            List<TreeNode> leftList = dfs(left, i - 1);
            // 右子树
            List<TreeNode> rightList = dfs(i + 1, r);
            for (TreeNode leftNode : leftList) {
                for (TreeNode rightNode : rightList) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    list.add(root);
                }
            }
        }
        return list;
    }
}
