package leetcode.mid;


/**
 * 剑指 Offer 35. 复杂链表的复制
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，
 * 每个节点除了有一个 next 指针指向下一个节点，还有一个 random
 * 指针指向链表中的任意节点或者 null。
 *
 * @Author jiahao
 * @Date 2021/1/31 14:22
 */
public class CopyRandomList_offer_35 {
    public Node copyRandomList(Node head) {

        if(head == null){
            return null;
        }
        // 先遍历一遍，生成所有节点
        Node cur = head;
        Node next = null;
        // 每个节点后面生成一个新节点
        while (cur != null){
            next = cur.next;
            cur.next = new Node(cur.val);
            cur.next.next = next;
            cur = next;
        }
        // 拼接随机节点

        cur = head;
        while (cur != null){
            if(cur.random != null){
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;

        }
        // 一分为二
        cur = head;
        Node newNode = head.next;
        Node newHead = head.next;
        while (cur != null){
            cur.next = cur.next.next;
            cur = cur.next;
            if(newNode.next != null){
                newNode.next = newNode.next.next;
                newNode = newNode.next;
            }
        }
        return newHead;

    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}