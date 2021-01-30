package tree;

import leetcode.base.TreeNode;

import java.util.Stack;

/**
 * TODO
 *
 * @Author jiahao
 * @Date 2021/1/30 16:51
 */
public class TreeBianli {
    private void pre(TreeNode root){
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
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
    private void mid(TreeNode root){
        if(root == null){
            return;
        }
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
    private void pos(TreeNode root){
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> stack1 = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode pop = stack.pop();
            stack1.push(pop);
            if(pop.left != null){
                stack.push(pop.left);
            }
            if(pop.right != null){
                stack.push(pop.right);
            }
        }
        while (!stack1.isEmpty()){
            System.out.println(stack1.pop().val);
        }

    }
}
