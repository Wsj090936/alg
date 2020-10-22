package leetcode.easy;

import leetcode.base.ListNode;

/**
 * 234. 回文链表
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * @Author jiahao
 * @Date 2020/10/22 21:22
 */
public class IsPalindrome_234 {
    public static boolean isPalindrome(ListNode head) {
        if(head == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        // 1 0 1
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode ptr = null;
        ListNode cur = slow;
        ListNode n = cur;
        while (cur != null){
            n = cur.next;
            cur.next = ptr;
            ptr = cur;
            cur = n;
        }
        ListNode left = head;
        while (left != null && ptr != null){
            if(left.val != ptr.val){
                return false;
            }
            left = left.next;
            ptr = ptr.next;

        }
        return true;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(0);
        node.next.next = new ListNode(1);
        isPalindrome(node);
    }
}
