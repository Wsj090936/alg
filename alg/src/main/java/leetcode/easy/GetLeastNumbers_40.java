package leetcode.easy;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 剑指 Offer 40. 最小的k个数
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 *
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *
 * @Author jiahao
 * @Date 2021/1/31 15:12
 */
public class GetLeastNumbers_40 {


    public int[] getLeastNumbersV2(int[] arr,int k){
        if(arr == null || k <= 0){
            return new int[0];
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(k,(o1, o2) -> o2 - o1);
        for(int i = 0;i < k;i++){
            queue.add(arr[i]);
        }
        for(int i = k;i < arr.length;i++){
            if(queue.peek() > arr[i]){
                queue.poll();
                queue.add(arr[i]);
            }
        }
        int[] res = new int[k];
        for(int i = 0;i < k;i++){
            res[i] = queue.poll();
        }
        return res;
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        return quicksort(arr,0,arr.length - 1,k - 1);
    }
    private int[] quicksort(int[] arr,int left,int right,int k){
        int j = partition(arr,left,right);
        if(j == k){
            return Arrays.copyOf(arr,j + 1);
        }
        return j > k ? quicksort(arr,left,right - 1,k) : quicksort(arr,left + 1,right,k);
    }

    private int partition(int[] arr, int left, int right) {
        int less = left - 1;
        int more = right;
        while (left < more){
            if(arr[left] > arr[right]){
                swap(arr,left,--more);
            }else if(arr[left] < arr[right]){
                swap(arr,++less,left++);
            }else {
                left++;
            }
        }
        swap(arr,more,right);

        return less;// 最左边区域的下标
    }
    private static void swap(int[] arr ,int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
