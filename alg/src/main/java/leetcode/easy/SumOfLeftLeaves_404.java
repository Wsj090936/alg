package leetcode.easy;

import leetcode.base.TreeNode;

/**
 * 404. 左叶子之和
 * 计算给定二叉树的所有左叶子之和。
 *
 * 示例：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 *
 *
 * @Author jiahao
 * @Date 2020/11/29 14:00
 */
public class SumOfLeftLeaves_404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null){
            return 0;
        }
        // 判断是左叶子
        int ans = 0;
        if(root.left != null && root.left.left == null && root.left.right == null){
            ans += root.left.val;
        }

        return ans + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
}
