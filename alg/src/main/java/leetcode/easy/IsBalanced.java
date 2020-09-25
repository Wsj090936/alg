package leetcode.easy;

import leetcode.base.TreeNode;

/**
 * 110. 平衡二叉树
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 *
 * 示例 1:
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 *
 * 示例 2:
 *
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * 返回 false 。
 *
 * @Author jiahao
 * @Date 2020/9/25 21:32
 */
public class IsBalanced {
    // 效率最低
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        if(root.left == null && root.right == null){
            return true;
        }
        int left = getHigh(root.left);
        int right = getHigh(root.right);
        if(Math.abs(right - left) <= 1 ){
            return isBalanced(root.left) && isBalanced(root.right);
        }else {
            return false;
        }
    }
    private int getHigh(TreeNode root){
        if(root == null){
            return 0;
        }
        return Math.max(getHigh(root.left),getHigh(root.right))+1;
    }

    public boolean isBalancedV2(TreeNode root) {
        if(root == null){
            return true;
        }
        if(root.left == null && root.right == null){
            return true;
        }
        return height(root) > 0;
    }
    private int height(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        if(left == -1 || right == -1 || Math.abs(right - left) > 1){
            return -1;// 这种情况直接掠过
        }else {
            return Math.max(left,right) + 1;
        }
    }


}
