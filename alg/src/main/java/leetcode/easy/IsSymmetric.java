package leetcode.easy;

import leetcode.base.TreeNode;

/**
 * 101. 对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 *
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 * @Author jiahao
 * @Date 2020/9/23 18:38
 */
public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return leftAndRightIsSymmetric(root.left,root.right);
    }
    private boolean leftAndRightIsSymmetric(TreeNode left,TreeNode right){
        if(left == null && right == null ){
            return true;
        }
        if(left == null){
            return false;
        }
        if(right == null){
            return false;
        }
        if(left.val != right.val){
            return false;
        }
        // 左边的左=右边的右 && 左边的右=右边的左
        return leftAndRightIsSymmetric(left.left,right.right) && leftAndRightIsSymmetric(left.right,right.left);

    }
}
