package linkedList;

import linkedList.base.Node;

/**
 * 翻转部分链表
 *
 * @Author jiahao
 * @Date 2020/5/10 19:52
 */
public class ReversePartList {

    public static Node reversePartList(Node head,Integer from, Integer to){
        // 先确定要反转的部分
        int len = 0;
        Node node1 = head;
        Node fromPre = null;
        Node toNext = null;
        while (node1 != null){
            len++;
            fromPre = len == from - 1 ? node1 : fromPre;
            toNext = len == to + 1 ? node1 : toNext;
            node1 = node1.next;
        }
        if(from > to || from < 1 || to > len){
            return head;
        }
        Node fromNode = fromPre == null ? head : fromPre.next;// 翻转部分的第一个节点
        Node fromNext = fromNode.next;
        fromNode.next = toNext;
        Node temp = null;
        while (fromNext != toNext){
            temp = fromNext.next;
            fromNext.next = fromNode;
            fromNode = fromNext;
            fromNext = temp;
        }
        // 链接旧的翻转接点的上一个节点和翻转后节点的头结点
        if(fromPre != null){
            fromPre.next = fromNode;
            return head;
        }
        // 为空说直接返回翻转节点的头结点
        return fromNode;
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(6);
        head1.next.next.next = new Node(9);
        head1.next.next.next.next = new Node(10);
        Node node = reversePartList(head1, 2, 4);
        System.out.println(node.value);
        System.out.println(node.next.value);
        System.out.println(node.next.next.value);
        System.out.println(node.next.next.next.value);
        System.out.println(node.next.next.next.next.value);
    }
}
