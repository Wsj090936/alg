package leetcode.mid;

import leetcode.base.ListNode;

/**
 * 24. 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 * @Author jiahao
 * @Date 2020/9/29 22:40
 */
public class SwapPairs {
    public static ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode first = new ListNode(0);
        first.next = head;
        ListNode ptr = first;
        ListNode cur = null;
        ListNode n = cur;
        while (ptr.next != null && ptr.next.next != null){
            cur = ptr.next;
            ptr.next = cur.next;
            cur.next = cur.next.next;
            ptr.next.next = cur;
            ptr = cur;

        }
        return first.next;

    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        swapPairs(listNode);
    }
}
