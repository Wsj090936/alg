package leetcode.easy;

import leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @Author jiahao
 * @Date 2020/10/24 21:57
 */
public class BinaryTreePaths_257 {
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        dfs(root,res,root.val + "");
        return res;
    }
    // 版本一
    private void dfs(TreeNode node,List<String> res,String path){
        if(node.left == null && node.right == null){
            res.add(path);
            return;
        }
        if(node.left != null){
            dfs(node.left,res,path + "->" + node.left.val + "");
        }
        if(node.right != null){
            dfs(node.right,res,path + "->" + node.right.val + "");
        }
    }
}
