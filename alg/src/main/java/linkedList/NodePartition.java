package linkedList;

import linkedList.base.Node;

/**
 * 将链表按照一个数，分为中间与这个数相等，左边比这个数小，右边比这个数大
 *
 * 进阶，要求分区后各分区中，各节点的相对顺序与分区前一致
 *
 * @Author jiahao
 * @Date 2020/5/20 20:55
 */
public class NodePartition {

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(6);
        head1.next.next = new Node(2);
        head1.next.next.next = new Node(9);
        Node node = nodePartition(head1, 3);
        System.out.println(node.value);
        System.out.println(node.next.value);
        System.out.println(node.next.next.value);
        System.out.println(node.next.next.next.value);
    }


    public static Node nodePartition(Node head,int pivot){
        if(head == null ){
            return head;
        }
        Node cur = head;
        int len = 0;
        while (cur != null){
            len++;
            cur = cur.next;
        }
        Node[] nodeArr = new Node[len];
        cur = head;
        for (int i = 0; i != len;i++){
            nodeArr[i] = cur;
            cur = cur.next;
        }
        partition(nodeArr,pivot);
        for (int i = 1; i != len;i++){
            nodeArr[i - 1].next = nodeArr[i];
        }
        nodeArr[len - 1].next = null;
        return nodeArr[0];
    }

    /**
     * 其实就是快速排序
     * @param nodeArr
     * @param pivot
     */
    private static void partition(Node[] nodeArr, int pivot) {
        int small = -1;
        int big = nodeArr.length;
        int index = 0;
        int val = 0;
        while (index != big){
            val = nodeArr[index].value;
            if(val < pivot){
                swapNode(nodeArr,++small,index++);
            }else if(val == pivot){
                index++;// 相等，不做操作
            }else {
                // 大于
                swapNode(nodeArr,--big,index);
            }
        }

    }
    private static void swapNode(Node[] nodeArr,int a,int b){
        Node temp = nodeArr[a];
        nodeArr[a] = nodeArr[b];
        nodeArr[b] = temp;
    }
}
