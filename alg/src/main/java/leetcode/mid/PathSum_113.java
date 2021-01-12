package leetcode.mid;

import leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 113. 路径总和 II
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 * @Author jiahao
 * @Date 2021/1/12 21:10
 */
public class PathSum_113 {
    List<List<Integer>> resList = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root,sum,new ArrayList<>(),0);
        return resList;
    }
    private void dfs(TreeNode root,int sum,List<Integer> path,int cut){

        if(root == null){
            return;
        }
        if(sum == cut + root.val && root.left == null && root.right == null){
            path.add(root.val);
            resList.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }

        path.add(root.val);
        // 左子树
        dfs(root.left,sum ,path,cut + root.val);
        // 右子树
        dfs(root.right,sum,path,cut + root.val);
        path.remove(path.size() - 1);

    }
}
