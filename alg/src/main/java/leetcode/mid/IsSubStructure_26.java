package leetcode.mid;

import leetcode.base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer 26. 树的子结构
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 *
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 *
 * 例如:
 * 给定的树 A:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 B：
 *
 *    4
 *   /
 *  1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 *
 * 示例 1：
 *
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 * 示例 2：
 *
 * 输入：A = [3,4,5,1,2], B = [4,1]
 *
 * @Author jiahao
 * @Date 2021/1/24 15:06
 */
public class IsSubStructure_26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(B == null){
            return true;
        }
        if(A == null){
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(A);
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            if(poll.val == B.val){
                if(DFS(poll,B)){
                    return true;
                }

            }
            // 继续
            if(poll.left != null){
                queue.add(poll.left);
            }
            if(poll.right != null){
                queue.add(poll.right);
            }
        }
        return false;
    }

    private boolean DFS(TreeNode root,TreeNode B){
        // A不包含B
        if(B != null && root == null){
            return false;
        }
        // B为空说明A包含了B 肯定为true
        if(B == null){
            return true;
        }
        // 值不相等
        if(root.val != B.val){
            return false;
        }
        // 判断双方的左子树和右子树是不是都相等
        return DFS(root.left,B.left) && DFS(root.right ,B.right);

    }
}
