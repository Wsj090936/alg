package leetcode.easy;

import leetcode.base.TreeNode;

import java.awt.print.PrinterGraphics;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @Author jiahao
 * @Date 2020/9/24 19:24
 */
public class LevelOrderBottom {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();

        if(root == null){
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            // 每次都取出一整行
            List<Integer> list = new ArrayList<>();
            for(int i = 0;i < size;i++){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            // 结果保存队头
            res.offerFirst(list);
        }
        return res;
    }
}
