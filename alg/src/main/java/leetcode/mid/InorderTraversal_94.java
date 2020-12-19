package leetcode.mid;

import leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94. 二叉树的中序遍历
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 *
 *
 *
 * @Author jiahao
 * @Date 2020/12/19 13:33
 */
public class InorderTraversal_94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<Integer> arrayList = new ArrayList<>();
        dfs(root,arrayList);
        return arrayList;

    }
    private void dfs(TreeNode root,List<Integer> path){
        if(root == null){
            return;
        }
        dfs(root.left,path);
        path.add(root.val);
        dfs(root.left,path);
    }
    public List<Integer> inorderTraversalV2(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;

        while (!stack.isEmpty() || node != null){
            if(node != null){
                stack.push(node);
                node = node.left;
            }else {
                node = stack.pop();
                res.add(node.val);
                node = node.right;
            }
        }
        return res;
    }
}
