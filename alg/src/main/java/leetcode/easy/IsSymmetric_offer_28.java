package leetcode.easy;

import leetcode.base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer 28. 对称的二叉树
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 *
 *
 * 示例 1：
 *
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * 示例 2：
 *
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 *
 * @Author jiahao
 * @Date 2021/1/24 15:52
 */
public class IsSymmetric_offer_28 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return false;
        }
        return isSymmetric(root.left,root.right);
    }
    private boolean isSymmetric(TreeNode left,TreeNode right){
        if(left == null && right == null){
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
        return isSymmetric(left.left,right.right) && isSymmetric(left.right,right.left);
    }
}
