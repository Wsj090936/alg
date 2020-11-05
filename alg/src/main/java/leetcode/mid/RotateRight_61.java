package leetcode.mid;

import leetcode.base.ListNode;

import java.util.List;

/**
 * 61. 旋转链表
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 *
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 *
 * @Author jiahao
 * @Date 2020/11/5 19:20
 */
public class RotateRight_61 {

    public static ListNode rotateRight(ListNode head, int k) {

        if(head == null || head.next == null){
            return head;
        }
        // 看下链表的长度
        ListNode cur = head;
        int len = 0;
        while (cur != null){
            cur = cur.next;
            len++;
        }
        // 理论上，如果链表长度和k相同，则还是原来的链表
        int m = k % len;
        if(m == 0){
            return head;
        }


        // 再走一遍 确定倒数第m个链表的位置
        cur = head;
        while (cur != null){
            m--;
            cur = cur.next;
        }
        if(m < 0){
            cur = head;
            while (++m != 0){
                cur = cur.next;
            }
            // 这个时候 cur.next为头结点
            ListNode preHead = head;
            head = cur.next;
            cur.next = null;
            cur = head;
            while (cur.next != null){
                cur = cur.next;
            }
            cur.next = preHead;
        }
        return head;

    }

    public static void main(String[] args) {
        ListNode node = new ListNode(0);
        node.next = new ListNode(1);
        node.next.next = new ListNode(2);

        rotateRight(node,2);

    }
}
