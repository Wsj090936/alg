package leetcode.mid;

import leetcode.base.ListNode;
import leetcode.base.TreeNode;

/**
 * 109. 有序链表转换二叉搜索树
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 *
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * @Author jiahao
 * @Date 2021/1/11 19:53
 */
public class SortedListToBST_109 {
    /**
     * 整体思路
     *      找到中间节点，然后左子树肯定是中间节点以左边，右子树为中间节点以右
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }
        if(head.next == null){
            return new TreeNode(head.val);
        }
        ListNode pre = new ListNode(0);
        pre.next = head;
        // 找到中间节点
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            pre = pre.next;
        }

        pre.next = null;// 左右分开
        ListNode rightHead = slow.next;
        TreeNode root = new TreeNode(slow.val);
        // 左子树
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(rightHead);
        return root;
    }
}
