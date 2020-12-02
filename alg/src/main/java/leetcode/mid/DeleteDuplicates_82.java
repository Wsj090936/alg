package leetcode.mid;

import leetcode.base.ListNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 82. 删除排序链表中的重复元素 II
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 *
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 *
 * @Author jiahao
 * @Date 2020/12/2 18:41
 */
public class DeleteDuplicates_82 {
    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        // 辅助节点
        ListNode listNode = new ListNode(-1);
        listNode.next = head;
        ListNode cur = head;
        ListNode pre = listNode;
        while (cur != null && cur.next != null){
            if(cur.val == cur.next.val){
                // 直接去掉所有
                while (cur.next != null && cur.val == cur.next.val){
                    cur = cur.next;
                }
                // 重复的去掉了
                pre.next = cur.next;// cur = 重复的前面一个
                cur = cur.next;
            }else {
                // 只有两种情况，第一个结点不重复，直接作为头节点，如果第一个重复，则在上面的条件中以及变更过了
                pre = cur;
                cur = cur.next;
            }

        }

        return listNode.next;
    }
//    ListNode cur = head;
//    Set<Integer> dupValue = new HashSet<>();
//        while (cur.next != null){
//        if(cur.val == cur.next.val){
//            cur.next = cur.next.next;
//            dupValue.add(cur.val);
//        }
//        cur = cur.next;
//    }
//    // 再次去重
//    cur = head;
//    head = null;
//    int headNum = 1;
//    ListNode ptr = new ListNode(-1);
//        while (ptr.next != null && cur.next != null){
//        boolean contains = dupValue.contains(cur.val);
//        if(contains){
//            // 移除当前元素
//            ptr.next = ptr.next.next;
//            cur = ptr;
//        }else {
//            // 第一个不重复元素
//            if(headNum == 1){
//                head = cur;
//                headNum = 0;
//            }
//            ptr = cur;
//            cur = cur.next;
//        }
//    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(3);
        node.next.next.next.next = new ListNode(4);
        node.next.next.next.next.next = new ListNode(4);
        node.next.next.next.next.next.next = new ListNode(5);
        deleteDuplicates(node);

    }
}
