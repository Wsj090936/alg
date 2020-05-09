package linkedList;

import linkedList.base.DoubleNode;
import linkedList.base.Node;

/**
 * 翻转单向链表和双向链表，返回翻转后链表的头节点
 *
 * @Author jiahao
 * @Date 2020/5/9 21:00
 */
public class ReverseLinkedList {

    public static Node reverseSingleList(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node pre = null;
        Node next = null;
        Node cur = head;
        while (cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
    public static DoubleNode reverseDoubleList(DoubleNode head){
        if(head == null || head.next == null){
            return head;
        }
        DoubleNode pre = null;
        DoubleNode next = null;
        DoubleNode cur = head;
        while (cur != null){
            next = cur.next;
            cur.next = pre;
            cur.last = next;
            pre = cur;
            cur = next;
        }
        return pre;
    }


    public static void main(String[] args) {
//        Node head1 = new Node(1);
//        head1.next = new Node(2);
//        head1.next.next = new Node(6);
//        head1.next.next.next = new Node(9);
//        Node node = reverseSingleList(head1);
//        System.out.println(node.value);
//        System.out.println(node.next.value);
//        System.out.println(node.next.next.value);
//        System.out.println(node.next.next.next.value);
        DoubleNode node = new DoubleNode(1);
        DoubleNode node1 = new DoubleNode(2);
        DoubleNode node2 = new DoubleNode(3);
        node.next = node1;
        node1.last = node;
        node1.next = node2;
        node2.last = node1;
        DoubleNode head = node;
        System.out.println(head.value);
        System.out.println(head.next.value);
        System.out.println(head.next.next.value);
        DoubleNode head2 = reverseDoubleList(head);
        System.out.println(head2.value);
        System.out.println(head2.next.value);
        System.out.println(head2.next.next.value);
    }
}
