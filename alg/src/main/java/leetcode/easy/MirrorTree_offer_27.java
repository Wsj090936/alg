package leetcode.easy;

import leetcode.base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer 27. 二叉树的镜像
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 *
 * 例如输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 镜像输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 *
 *
 * 示例 1：
 *
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 *
 * @Author jiahao
 * @Date 2021/1/24 15:41
 */
public class MirrorTree_offer_27 {
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            TreeNode temp = poll.right;
            poll.right = poll.left;
            poll.left = temp;
            if(poll.left != null){
                queue.add(poll.left);

            }
            if(poll.right != null){
                queue.add(poll.right);
            }
        }
        return root;
    }
}
