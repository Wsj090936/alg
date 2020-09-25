package leetcode.easy;

import leetcode.base.TreeNode;

/**
 * TODO
 *
 * @Author jiahao
 * @Date 2020/9/25 22:02
 */
public class MinDepth_111 {
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right != null){
            return 1 + minDepth(root.right);
        }
        if(root.right == null && root.left != null){
            return 1 + minDepth(root.left);
        }
        return Math.min(minDepth(root.left),minDepth(root.right)) + 1;
    }
}
