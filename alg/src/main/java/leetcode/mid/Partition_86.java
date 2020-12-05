package leetcode.mid;

import leetcode.base.ListNode;

/**
 * 86. 分隔链表
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 *
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 *
 *
 * 示例:
 *
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 *
 * @Author jiahao
 * @Date 2020/12/5 13:45
 */
public class Partition_86 {
    public ListNode partition(ListNode head, int x) {
        if(head == null){
            return null;
        }
        ListNode low = new ListNode(0);
        ListNode high = new ListNode(0);
        ListNode cur = low;
        ListNode ptr = high;
        while (head != null){
            if(head.val < x){
                // 小于
                cur.next = head;
                head = head.next;
                cur = cur.next;
                cur.next = null;
            }else {
                ptr.next = head;
                head = head.next;
                ptr = ptr.next;
                ptr.next = null;
            }
        }
        cur.next = high.next;

        return low.next;

    }
}
