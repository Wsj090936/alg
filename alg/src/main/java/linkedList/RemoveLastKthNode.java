package linkedList;

import linkedList.base.Node;

/**
 * 删除链表中的倒数第k个节点
 *
 * @Author jiahao
 * @Date 2020/5/7 22:40
 */
public class RemoveLastKthNode {

    public static Node remogeLastKthNode(Node head, int k){
        if(head == null || k < 1){
            return head;
        }
        Node cur = head;
        while (cur != null){
            k--;
            cur = cur.next;
        }
        if(k == 0){
            head = head.next;
        }
        if(k < 0){
            cur = head;
            while (++k != 0){
                cur = cur.next;
            }
            cur.next = cur.next.next;// 重新拼装装链表
        }
        return head;
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(6);
        head1.next.next.next = new Node(9);
        Node node = remogeLastKthNode(head1, 1);
        System.out.println(node.value);
        System.out.println(node.next.value);
        System.out.println(node.next.next.value);
//        System.out.println(node.next.next.next.value);
    }
}
