package leetcode.mid;

import leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. 二叉树的层序遍历
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 *
 *
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层序遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 * 通过次数233,654提交次数36
 *
 * @Author jiahao
 * @Date 2020/12/28 21:03
 */
public class LevelOrder_102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queueOne = new LinkedList<>();
        queueOne.offer(root);
        int count = 0;
        while (!queueOne.isEmpty()){
            List<Integer> list = new ArrayList<>();
            count = queueOne.size();
            while (count > 0){
                TreeNode node = queueOne.poll();
                list.add(node.val);
                if(node.left != null){
                    queueOne.offer(node.left);
                }
                if(node.right != null){
                    queueOne.offer(node.right);
                }
                count--;
            }
            res.add(list);
        }
        return res;
    }
}
