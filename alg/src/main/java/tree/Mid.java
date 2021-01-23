package tree;

import leetcode.base.TreeNode;

import java.util.Stack;

/**
 * TODO
 *
 * @Author jiahao
 * @Date 2021/1/23 19:28
 */
public class Mid {
    public static void mid(TreeNode root){
        if(root != null){
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || root != null){
                if(root != null){
                    stack.push(root);
                    root = root.left;
                }else {
                    root = stack.pop();
                    System.out.println(root.val);
                    root = root.right;
                }
            }
        }
    }
}
