package leetcode.easy;

import leetcode.base.ListNode;

/**
 *
 * @Author jiahao
 * @Date 2020/10/7 16:08
 */
public class GetIntersectionNode_160 {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        int a = 0;
        int b = 0;
        while (nodeA.next != null){
            nodeA = nodeA.next;
            a++;
        }
        while (nodeB.next != null){
            nodeB = nodeB.next;
            b++;
        }
        nodeA = headA;
        nodeB = headB;
        if(a > b){
            int x = a - b;
            while (x >= 0 && nodeA != null){
                nodeA = nodeA.next;
                x--;
            }
        }else if(b > a){
            int x = b - a;
            while (x >= 0 && nodeB != null){
                nodeB = nodeB.next;
                x--;
            }
        }
        while (nodeA != null && nodeB != null){
            if(nodeA == nodeB){
                return nodeA;
            }
            nodeA = nodeA.next;
            nodeB = nodeB.next;

        }
        return null;
    }

    public static void main(String[] args) {
        ListNode nodeA = new ListNode(4);
        nodeA.next = new ListNode(1);
        nodeA.next.next = new ListNode(8);
        nodeA.next.next.next = new ListNode(4);
        nodeA.next.next.next.next = new ListNode(5);
        ListNode nodeB = new ListNode(5);
        nodeB.next = new ListNode(6);
        nodeB.next.next = new ListNode(1);
        nodeB.next.next.next = new ListNode(8);
        nodeB.next.next.next.next = new ListNode(4);
        nodeB.next.next.next.next.next = new ListNode(5);
        getIntersectionNode(nodeA,nodeB);

    }
}
