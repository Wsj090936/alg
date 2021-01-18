package leetcode.mid;

import leetcode.base.TreeNode;

/**
 * 剑指 Offer 07. 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 *
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * @Author jiahao
 * @Date 2021/1/18 20:59
 */
public class BuildTree_offer_07 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder,inorder,0,preorder.length - 1,0,inorder.length - 1);
    }
    private TreeNode buildTree(int[] preorder, int[] inorder,int preleft,int preright,int inleft,int inright){
        if(inleft > inright || preleft > preright){
            return null;
        }
        int root = preorder[preleft];
        int mid = preleft;
        // 寻找中序的根节点
        for(int i = inleft;i <= inright;i++){
            if(root == inorder[i]){
                mid = i;
                break;
            }
        }
        int leftNum = mid - inleft;
        TreeNode node = new TreeNode(mid);
        node.left = buildTree(preorder,inorder,preleft + 1,preleft + leftNum,inleft,mid - 1);// 左边
        node.right = buildTree(preorder,inorder,preleft + leftNum + 1,preright,mid + 1,inright);
        return node;
    }
}
