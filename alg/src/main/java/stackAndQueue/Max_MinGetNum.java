package stackAndQueue;

import java.util.LinkedList;

/**
 * 最大值减去最小值小于或等于num的子数组数量
 *
 * @Author jiahao
 * @Date 2020/4/23 22:07
 */
public class Max_MinGetNum {

    public static void main(String[] args) {
        int[] arr = {1};
        int num = -1;
        System.out.println(getNum(arr,num));
    }

    public static int getNum(int[] arr, int num){
        if(arr == null || arr.length == 0){
            return 0;
        }
        LinkedList<Integer> qmax = new LinkedList<>();
        LinkedList<Integer> qmin = new LinkedList<>();
        int i = 0;// 扫描数组窗口的左边界
        int j = 0;// 扫描数组窗口的右边界
        int res = 0;
        while (i < arr.length){
            while (j < arr.length){
                if(qmax.isEmpty() || qmax.peekFirst() != j){
                    // 更新最大值队列 如果max队列的最后一个比当前值小，就弹出，知道peeklast大于等于当前值
                    while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[j]){
                        qmax.pollLast();
                    }
                    qmax.addLast(j);

                    // 更新最小值队列
                    while (!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[j]){
                        qmin.pollLast();
                    }
                    qmin.addLast(j);

                }
                // 何时更新结束？遇到 qmax.first 减去 qmin.first 结束 此时 arr[i...j - 1]子数组都满足条件
                if(arr[qmax.getFirst()] - arr[qmin.getFirst()] > num){
                    break;
                }
                // 还没结束就向右扩一位
                j++;
            }
            res += j - i;
            // 删掉过期的下标
            if(qmax.peekFirst() == i){
                qmax.pollFirst();
            }
            if(qmin.peekFirst() == i){
                qmin.pollFirst();
            }
            // 更新左边界
            i++;
        }
        return res;
    }
}
