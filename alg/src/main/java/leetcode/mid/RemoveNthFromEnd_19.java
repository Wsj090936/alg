package leetcode.mid;

import leetcode.base.ListNode;

/**
 * 19. 删除链表的倒数第N个节点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 *
 * @Author jiahao
 * @Date 2020/9/28 22:27
 */
public class RemoveNthFromEnd_19 {
    // 进阶遍历一遍
    public ListNode removeNthFromEndV2(ListNode head, int n) {
        if(head == null){
            return head;
        }
        //块指针
        ListNode fast = head;
        for(int i = 0;i < n;i++){
            fast = fast.next;
        }
        // 删除头部
        if(fast == null){
            return head.next;
        }
        //慢指针
        ListNode slow = head;
        while (fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }
        // 普通方法
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return head;
        }
        ListNode cur = head;
        while (cur != null){
            n--;
            cur = cur.next;
        }
        if(n == 0){
            head = head.next;
        }else if(n < 0){
            cur = head;
            while (++n != 0){
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }// 大于0 证明不用删除
        return head;
    }

}
