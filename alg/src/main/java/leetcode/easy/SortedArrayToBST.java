package leetcode.easy;


import leetcode.base.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。
 *
 * 示例:
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *           0
 *          / \
 *        -3   9
 *        /   /
 *      -10  5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-height-tree-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author jiahao
 * @Date 2020/9/2 19:28
 */
public class SortedArrayToBST {
    public static TreeNode sortedArrayToBST(int[] nums) {

        return getMinTree(nums,0,nums.length - 1);

    }
    private static TreeNode getMinTree(int[] nums,int start,int end){
        if(start > end){
            return null;
        }
        int mid = (int) Math.ceil((end + start) / 2);
        TreeNode node = new TreeNode(nums[mid]);
        node.setLeft(getMinTree(nums,start,mid-1));
        node.setRight(getMinTree(nums,mid + 1,end));
        return node;
    }

}
