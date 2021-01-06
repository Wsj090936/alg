package leetcode.mid;

import leetcode.base.TreeNode;

/**
 *105. 从前序与中序遍历序列构造二叉树
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
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
 * @Author jiahao
 * @Date 2021/1/6 20:15
 */
public class BuildTree_105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder,inorder,0,preorder.length - 1,0,inorder.length - 1);
    }
    private TreeNode buildTree(int[] preorder, int[] inorder,int preLeft,int preRight,int inLeft,int inRight){
        if(preLeft > preRight || inLeft > inRight){
            return null;
        }
        int root = preorder[preLeft];
        int mid = inLeft;
        // 寻找中序的根节点
        for(int i = inLeft;i <= inRight;i++){
            if(root == inorder[i]){
                mid = i;
                break;
            }
        }
        int leftNum = mid - inLeft;// 左子树个数
        TreeNode node = new TreeNode(root);
        // 分割 前序左子树 中序左子树
        node.left = buildTree(preorder,inorder,preLeft + 1,preLeft + leftNum,inLeft,mid - 1);
        node.right = buildTree(preorder,inorder,preLeft + leftNum + 1,preRight,mid + 1,inRight);
        return node;
    }
}
