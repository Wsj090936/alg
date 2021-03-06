package leetcode.easy;

import leetcode.base.ListNode;

import java.util.List;

/**
 * 剑指 Offer 18. 删除链表的节点
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 *
 * 返回删除后的链表的头节点。
 *
 * 注意：此题对比原题有改动
 *
 * 示例 1:
 *
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * 示例 2:
 *
 * 输入: head = [4,5,1,9], val = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 *
 * @Author jiahao
 * @Date 2021/1/24 11:13
 */
public class DeleteNode_offer_18 {
    public ListNode deleteNode(ListNode head, int val) {
        if(head == null){
            return null;
        }
        ListNode pre = new ListNode(-1);
        ListNode cur = pre;
        pre.next = head;
        while (head != null){
            if(head.val == val){
                pre.next = head.next;
                break;
            }else {
                pre = pre.next;
                head = head.next;
            }

        }
        return cur.next;

    }
}
