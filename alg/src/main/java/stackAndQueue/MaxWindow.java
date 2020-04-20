package stackAndQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 得到窗口的最大值
 *
 * @Author jiahao
 * @Date 2020/4/14 22:40
 */
public class MaxWindow {

    private static int[] getMaxWindow(int[] arr, int windowSize){
        if(arr == null || windowSize < 1 || arr.length < windowSize){
            return null;
        }
        LinkedList<Integer> maxQueue = new LinkedList<>();// 保存最大元素的下标
        int[] res = new int[arr.length - windowSize + 1];
        int index = 0;
        for(int i = 0; i < arr.length; i++){
            while (!maxQueue.isEmpty() && arr[maxQueue.peekLast()] <= arr[i]){
                maxQueue.pollLast();
            }
            maxQueue.addLast(i);
            if(maxQueue.peekFirst() == i - windowSize){
                // 过期
                maxQueue.pollFirst();
            }
            if(i >= windowSize - 1){
                res[index++] = (arr[maxQueue.peekFirst()]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {4,3,5,4,3,3,6,7};
        int[] maxWindow = getMaxWindow(arr, 3);
        for (int num : maxWindow){
            System.out.println(num);
        }
    }

}
