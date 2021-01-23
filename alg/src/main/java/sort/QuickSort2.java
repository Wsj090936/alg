package sort;

import java.util.Arrays;

/**
 * TODO
 *
 * @Author jiahao
 * @Date 2021/1/23 18:25
 */
public class QuickSort2 {

    public static void quickSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        quickSort(arr,0,arr.length - 1);

    }
    public static void quickSort(int[] arr,int left,int right){
        if(left < right){
            int mid = (right + left) / 2;
            swap(arr,mid,right);
            int[] partition = partition(arr, left, right);
            quickSort(arr,left,partition[0] - 1);
            quickSort(arr,partition[1] + 1,right);
        }
    }

    public static int[] partition(int[] arr,int left,int right){
        int less = left - 1;
        int more = right;
        while (left < more){
            // 左边小于基准值，放到左边
            if(arr[left] < arr[right]){
                swap(arr,++less,left++);
            }else if(arr[left] > arr[right]){
                swap(arr,--more,left);
            }else {
                left++;
            }
        }
        swap(arr,more,right);
        return new int[]{less + 1,more};
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
