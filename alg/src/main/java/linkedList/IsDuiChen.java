package linkedList;

import linkedList.base.Node;

import java.util.Stack;

/**
 * 判断一个链表是否为回文结构(对称)
 *
 * @Author jiahao
 * @Date 2020/5/16 11:55
 */
public class IsDuiChen {
    public static boolean isDuiChen(Node head){
        if(head == null || head.next == null){
            return true;
        }
        Node cur = head;
        Node right = head.next;
        while (cur.next != null && cur.next.next != null){
            right = right.next;
            cur = cur.next.next;
        }
        Stack<Node> stack = new Stack<>();
        // 将右半部分压入栈中
        while (right != null){
            stack.push(right);
            right = right.next;
        }
        // 开始比较一致
        while (!stack.isEmpty()){
            if(head.value != stack.pop().value){
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(6);
        System.out.println(isDuiChen(head1));


        Node head2 = new Node(1);
        head2.next = new Node(2);
        head2.next.next = new Node(2);
        head2.next.next.next = new Node(1);
        System.out.println(isDuiChen(head2));
    }
}
