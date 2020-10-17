package leetcode.easy;

import leetcode.base.ListNode;

import java.util.List;

/**
 *
 * @Author jiahao
 * @Date 2020/10/17 11:51
 */
public class ReverseList_206 {
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = head.next;
        while (next != null){
            cur.next = pre;
            pre = cur;
            cur = next;
            next = next.next;

        }
        return cur;
    }
}
