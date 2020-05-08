package linkedList;

import linkedList.base.Node;

/**
 * 删除链表中间的节点：
 *  长度为1 不删除
 *  1-2 删除1
 *  1-2-3 删除2
 *  1-2-3-4 删除2
 *  1-2-3-4-5 删除3
 *  思路：
 *      快慢指针，一个指针一次走1步，另一个走两步，等快指针走到头，则慢指针所在的位置即为中间位置
 *
 * @Author jiahao
 * @Date 2020/5/8 21:59
 */
public class RemoveMindNode {
    public static Node removeMindNode(Node head){
        if(head == null || head.next == null){
            return head;
        }
        if(head.next.next == null){
            return head;
        }
        Node slow = head;
        Node fast = head.next.next;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(6);
        head1.next.next.next = new Node(9);
        Node node = removeMindNode(head1);
        System.out.println(node.value);
        System.out.println(node.next.value);
        System.out.println(node.next.next.value);
    }
}
