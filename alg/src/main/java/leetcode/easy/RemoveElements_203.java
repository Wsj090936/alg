package leetcode.easy;

import leetcode.base.ListNode;

/**
 *203. 移除链表元素
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 *
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 * @Author jiahao
 * @Date 2020/10/16 20:01
 */
public class RemoveElements_203 {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return null;
        }
        ListNode node = new ListNode(-1);
        node.next = head;
        ListNode cur = node;
        while (cur.next != null){
            if(cur.next.val == val){
                cur = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return node.next;
    }
}
