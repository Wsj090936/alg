package leetcode.easy;

import leetcode.base.ListNode;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 *  
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author jiahao
 * @Date 2020/6/8 21:01
 */
public class MergeTwoLists {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode res = new ListNode(-1);
        ListNode temp = res;
        while (cur1 != null && cur2 != null){
            if(cur1.val >= cur2.val){
                temp.next = cur2;
                cur2 = cur2.next;
            }else {
                temp.next = cur1;
                cur1 = cur1.next;
            }
            temp = temp.next;
        }
        temp.next = cur1 == null ? cur2 : cur1;
        return res.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(3);
        ListNode listNode2 = new ListNode(5);
        ListNode listNode3 = new ListNode(7);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3 = null;
        ListNode listNodeT = new ListNode(2);
        ListNode listNodeT1 = new ListNode(4);
        ListNode listNodeT2 = new ListNode(6);
        ListNode listNodeT3 = new ListNode(8);
        listNodeT.next = listNodeT1;
        listNodeT1.next = listNodeT2;
        listNodeT2.next = listNodeT3;
        listNodeT3 = null;
        ListNode res = mergeTwoLists(listNode, listNodeT);
        System.out.println(res.val);
        System.out.println(res.next.val);
        System.out.println(res.next.next.val);
        System.out.println(res.next.next.next.val);
        System.out.println(res.next.next.next.next.val);
        System.out.println(res.next.next.next.next.next.val);
        System.out.println(res.next.next.next.next.next.next.val);
        System.out.println(res.next.next.next.next.next.next.next.val);
    }
}
