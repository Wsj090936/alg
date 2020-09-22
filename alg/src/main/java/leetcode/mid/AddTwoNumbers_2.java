package leetcode.mid;

import leetcode.base.ListNode;

import java.util.List;

/**
 *2. 两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @Author jiahao
 * @Date 2020/9/22 20:12
 */
public class AddTwoNumbers_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode cur = l1;
        ListNode ptr = l2;
        ListNode head = new ListNode(-1);
        ListNode n = head;
        int pre = 0;
        while (cur != null && ptr != null){
            int num = cur.val + ptr.val + pre;
            if(num >= 10){
                pre = num / 10;// 进位
                num = num % 10;// 剩余
                n.next = new ListNode(num);
                n = n.next;
            }else {
                n.next = new ListNode(num);
                n = n.next;
                pre = 0;
            }
            cur = cur.next;
            ptr = ptr.next;
        }
        // 说明ptr完了，那就进行填补
        ListNode m2 = cur != null ? cur : ptr;
        while (m2 != null){
            if(m2 != null){
                int num = m2.val + pre;
                if(num >= 10){
                    pre = num / 10;
                    num = num % 10;
                    n.next = new ListNode(num);
                    n = n.next;
                }else {
                    n.next = new ListNode(num);
                    n = n.next;
                    pre = 0;
                }
                m2 = m2.next;
            }
        }
        // 说明还有进位
        if(pre > 0){
            n.next = new ListNode(pre);
        }
        return head.next;
    }
}
