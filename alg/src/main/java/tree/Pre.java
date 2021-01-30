package tree;

import leetcode.base.TreeNode;

import java.util.Stack;

/**
 * 二叉树的前序遍历
 *
 * @Author jiahao
 * @Date 2021/1/23 19:24
 */
public class Pre {

    public static void pre(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        if(root != null){
            stack.add(root);
            while (!stack.isEmpty()){
                TreeNode pop = stack.pop();
                System.out.println(pop.val);
                if(pop.right != null){
                    stack.push(pop.right);
                }
                if(pop.left != null){
                    stack.push(pop.left);
                }

            }
        }
    }
}
