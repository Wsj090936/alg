package leetcode.easy;

import leetcode.base.ListNode;

/**
 * 剑指 Offer 25. 合并两个排序的链表
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 * 示例1：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * @Author jiahao
 * @Date 2021/1/24 12:14
 */
public class MergeTwoLists_25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode head = new ListNode(-1);
        ListNode temp = head;
        while (l1 != null && l2 != null){
            if(l1.val >= l2.val){
                temp.next = l2;
                l2 = l2.next;
            }else{
                temp.next = l1;
                l1 = l1.next;
            }
            temp = temp.next;
        }
        while (l1 != null){
            temp.next = l1;
            l1 = l1.next;
            temp = temp.next;
        }
        while (l2 != null){
            temp.next = l2;
            l2 = l2.next;
            temp = temp.next;
        }
        return head.next;

    }
}
