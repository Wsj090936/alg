package leetcode.easy;

import leetcode.base.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 *
 * @Author jiahao
 * @Date 2020/9/8 20:03
 */
public class NTreePostorder {
    // 方法一 递归 太过简单
    public static List<Integer> postorder(Node root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<Node> children = root.children;
        List<Integer> res = new ArrayList<>();
        for(Node node : children){
            List<Integer> all = postorder(node);
            res.addAll(all);
            res.add(node.val);
        }
        return res;
    }
    // 方法二 非递归，迭代的方式

    public static List<Integer> postOrderV2(Node root){
        if(root == null){
            return new ArrayList<>();
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        List<Integer> res = new ArrayList<>();
        while (!stack.isEmpty()){
            Node curNode = stack.pop();
            List<Node> children = curNode.children;
            res.add(curNode.val);
            for(Node each : children){
                if(each != null){
                    stack.add(each);
                }
            }
        }
        Collections.reverse(res);
        return res;
    }


}
