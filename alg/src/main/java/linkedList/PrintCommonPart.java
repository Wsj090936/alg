package linkedList;

import linkedList.base.Node;

/**
 * 打印两个有序链表的公共部分
 *
 * @Author jiahao
 * @Date 2020/4/27 21:13
 */
public class PrintCommonPart {

    public static void printCommon(Node head1,Node head2){
        if(head1 == null || head2 == null){
            return;
        }
        Node cur1 = head1;
        Node cur2 = head2;
        while (cur1 != null && cur2 != null){
            if(cur1.value == cur2.value){
                System.out.println(cur1.value);
                cur1 = cur1.next;
                cur2 = cur2.next;
            }else if(cur1.value > cur2.value){
                cur2 = cur2.next;
            }else {
                cur1 = cur1.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(6);
        head1.next.next.next = new Node(9);

        Node head2 = new Node(0);
        head2.next = new Node(2);
        head2.next.next = new Node(6);
        head2.next.next.next = new Node(8);
        printCommon(head1, head2);
    }
}
