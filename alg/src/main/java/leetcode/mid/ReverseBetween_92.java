package leetcode.mid;

import leetcode.base.ListNode;

/**
 * 92. 反转链表 II
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 *
 * @Author jiahao
 * @Date 2020/12/10 21:07
 */
public class ReverseBetween_92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null){
            return null;
        }
        if(m == n){
            return head;
        }
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode node = temp;
        for(int i = 1;i < m;i++){
            node = node.next;
        }
        ListNode cur = node.next;
        ListNode pre = null;
        // 中间部分反转
        for(int i = m;i < n;i++){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        // 处理最后的边界
        node.next.next = cur;
        node.next = pre;
        return temp.next;

    }
}
