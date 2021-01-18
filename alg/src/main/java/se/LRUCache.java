package se;

import java.util.*;

/**
 * LRU的实现
 *
 * @Author jiahao
 * @Date 2021/1/18 13:29
 */
public class LRUCache extends LinkedHashMap {
    private int maxElem = 0;
    public LRUCache(int maxSize){
        super(maxSize,0.75f,true);
        maxElem = maxSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return this.size() > maxElem;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        Iterator<Integer> iterator = list.iterator();
        Iterator<Integer> iterator1 = list1.iterator();
        while (iterator.hasNext()){
            Integer next = iterator.next();
            while (iterator1.hasNext()){
                Integer next1 = iterator1.next();
                if(next == next1){
                    System.out.println("删除 list: " + next + " list1" + next1);
                }
            }
        }
    }
}
