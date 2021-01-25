package leetcode.easy;

import leetcode.base.ListNode;

/**
 * TODO
 *
 * @Author jiahao
 * @Date 2021/1/24 11:27
 */
public class DeleteNode_1 {
    public void deleteNode(ListNode node) {
        if(node == null){
            return;
        }
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
