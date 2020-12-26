package leetcode.mid;

import leetcode.base.TreeNode;

import java.util.Stack;

/**
 * 98. 验证二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 *
 * @Author jiahao
 * @Date 2020/12/26 21:16
 */
public class IsValidBST_98 {
    long cur = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        boolean isLeft = isValidBST(root.left);
        if(root.val <= cur){
            return false;
        }
        cur = root.val;
        boolean isRight = isValidBST(root.right);


        return isLeft && isRight;
    }
    public boolean isValidBSTV2(TreeNode root){
        if(root == null){
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        long pre = Long.MIN_VALUE;
        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(pre >= root.val){
                return false;
            }
            pre = root.val;
            root = root.right;
        }
        return true;
    }
}
