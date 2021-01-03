package leetcode.mid;

import leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 103. 二叉树的锯齿形层序遍历
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层序遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 * @Author jiahao
 * @Date 2021/1/3 12:36
 */
public class ZigzagLevelOrder_103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Stack<TreeNode> stackLeft = new Stack<>();
        Stack<TreeNode> stackRight = new Stack<>();
        stackLeft.push(root);
        while (!stackLeft.isEmpty() || !stackRight.isEmpty()){
            List<Integer> list = new ArrayList<>();
            if(!stackLeft.isEmpty()){
                while (!stackLeft.isEmpty()){
                    TreeNode pop = stackLeft.pop();
                    list.add(pop.val);
                    if(pop.left != null){
                        stackRight.push(pop.left);
                    }
                    if(pop.right != null){
                        stackRight.push(pop.right);
                    }
                }
            }else if(!stackRight.isEmpty()){
                while (!stackRight.isEmpty()){
                    TreeNode pop = stackRight.pop();
                    list.add(pop.val);
                    if(pop.right != null){
                        stackLeft.push(pop.right);
                    }
                    if(pop.left != null){
                        stackLeft.push(pop.left);
                    }
                }
            }
            res.add(list);

        }
        return res;

    }
}
