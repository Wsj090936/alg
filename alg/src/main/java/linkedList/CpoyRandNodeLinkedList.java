package linkedList;

import linkedList.base.RandNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 复制含有随机指针的单链表
 *
 * @Author jiahao
 * @Date 2020/5/27 20:35
 */
public class CpoyRandNodeLinkedList {



    public static RandNode copyLinkedList(RandNode head){
        Map<RandNode,RandNode> map = new HashMap<>();
        RandNode cur = head;
        while (cur != null){
            map.put(cur,new RandNode(cur.value));
            cur = cur.next;
        }
        cur = head;
        while (cur != null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).rand = map.get(cur.rand);
            cur = cur.next;
        }
        return map.get(head);
    }

}
