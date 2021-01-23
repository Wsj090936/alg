package sort;

import java.util.Arrays;

/**
 * TODO
 *
 * @Author jiahao
 * @Date 2021/1/23 18:25
 */
public class QuickSort {

    public static void quickSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        quickSort(arr,0,arr.length - 1);

    }
    public static void quickSort(int[] arr,int left,int right){
        if(left < right){
            // 选取中间的为基准点
            int mid = (right + left) / 2;
            swap(arr,mid,right);
            int[] partition = partition(arr, left, right);
            quickSort(arr,left,partition[0] - 1);
            quickSort(arr,partition[1] + 1,right);
        }
    }

    public static int[] partition(int[] arr,int left,int right){
        int less = left - 1;// 比基准小的下标
        int more = right;// 比基准大的下标
        while (left < more){

            if(arr[left] < arr[right]){
                swap(arr,++less,left++);
            }else if(arr[left] > arr[right]){
                swap(arr,--more,left);
            }else {
                left++;
            }

        }
        // 还回去
        swap(arr,more,right);
        return new int[]{less + 1,more};// 等于区域的下标
    }



    private static void swap(int[] arr ,int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int[] ints = {7,6,6,6,5,5,5,3,3,3, 4, 3, 2, 1};
        quickSort(ints);
        System.out.println(Arrays.toString(ints));
    }





}
