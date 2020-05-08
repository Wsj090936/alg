package linkedList;

import linkedList.base.Node;

/**
 * 删除 a/b 处的节点
 *
 * @Author jiahao
 * @Date 2020/5/8 22:14
 */
public class RemoveByRatio {

    public static Node removeByRatio(Node head,int a,int b){
        if(a < 1 || a > b){
            return head;
        }
        Node cur = head;
        int n = 0;
        while (cur != null){
            n++;
            cur = cur.next;
        }
        int i = (int) Math.ceil((double)(a * n) / (double) b);
        if(i == 1){
            // 删除第一个
            head = head.next;
        }
        if(i > 1){
            Node cur2 = head;
            while (--i != 1){
                cur2 = cur2.next;
            }
            cur2.next = cur2.next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(6);
        head1.next.next.next = new Node(9);
        Node node = removeByRatio(head1,1,5);
        System.out.println(node.value);
        System.out.println(node.next.value);
        System.out.println(node.next.next.value);
    }
}
