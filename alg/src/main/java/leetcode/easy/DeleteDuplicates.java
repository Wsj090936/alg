package leetcode.easy;

import leetcode.base.ListNode;

/**
 * 删除链表中重复的元素
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 *
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 *
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author jiahao
 * @Date 2020/7/18 10:26
 */
public class DeleteDuplicates {
    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }
        // 既然是排序链表，那就直接判断后一个是不是与前一个相同，是的话就跳过
        ListNode cur = head.next;
        ListNode pre = head;
        while (cur != null){
            if(pre.val == cur.val){
                pre.next = cur.next;
                cur = cur.next;
            }else {
                pre = cur;
                cur = cur.next;
            }
        }
        return head;
    }


}
