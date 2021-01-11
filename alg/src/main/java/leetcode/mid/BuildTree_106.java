package leetcode.mid;

import leetcode.base.TreeNode;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * @Author jiahao
 * @Date 2021/1/9 10:37
 */
public class BuildTree_106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder,postorder,0,inorder.length - 1,0,postorder.length - 1);
    }
    private TreeNode buildTree(int[] inorder,int[] postorder,int inLeft,int inRight,int postLeft,int postRight){
        // 边界
        if(inLeft > inRight || postLeft > postRight){
            return null;
        }
        // 寻找根节点
        int root = postorder[postRight];
        int midRoot = inLeft;
        // 寻找中序的根节点
        for(int i = inLeft;i <= inRight;i++){
            if(root == inorder[i]){
                midRoot = i;
                break;
            }
        }
        int leftNum = midRoot - inLeft;
        TreeNode node = new TreeNode(root);
        // 分割左子树
        node.left = buildTree(inorder,postorder,inLeft,midRoot - 1,postLeft,postLeft + leftNum - 1);
        // 分割柚子树
        node.right = buildTree(inorder,postorder,midRoot + 1,inRight,postLeft + leftNum,postRight - 1);
        return node;
    }

}
