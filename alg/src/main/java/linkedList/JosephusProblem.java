package linkedList;

import linkedList.base.Node;

/**
 * 环形单链表的约瑟夫问题
 * 解法一：时间复杂度O(M*N)
 * 解法二：时间复杂度O(N)
 * @Author jiahao
 * @Date 2020/5/11 20:49
 */
public class JosephusProblem {
    public static Node resolveOne(Node head,int m){
        if(head == null || head.next == null || m < 1){
            return head;
        }
        // 先找到最后的节点
        Node last = head;
        while (last.next != head){
            last = last.next;
        }
        int count = 0;
        while (head != last){
            if(++count != m){
                last = last.next;
            }else {
                last.next = head.next;// do deleted
                count = 0;
                System.out.println("deleted:"+ head.value);
            }
            head = last.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(6);
        Node last = head1.next.next.next = new Node(9);
        last.next = head1;
        Node node = resolveOne(head1, 2);
        System.out.println(node.value);
        System.out.println(node.next.value);
    }
}
