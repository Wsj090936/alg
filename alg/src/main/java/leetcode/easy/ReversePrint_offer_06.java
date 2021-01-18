package leetcode.easy;

import leetcode.base.ListNode;

/**
 *剑指 Offer 06. 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 * @Author jiahao
 * @Date 2021/1/18 20:52
 */
public class ReversePrint_offer_06 {
    public int[] reversePrint(ListNode head) {
        ListNode cur = head;
        int len = 0;
        while (cur != null){
            len++;
            cur = cur.next;
        }
        int[] res = new int[len];
        cur = head;
        while (cur != null){
            res[len - 1] = cur.val;
            cur = cur.next;
            len--;
        }
        return res;
    }
}
