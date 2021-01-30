package sort;

/**
 * TODO
 *
 * @Author jiahao
 * @Date 2021/1/30 16:58
 */
public class Quick3 {
    public static void quickSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        quickSort(arr,0,arr.length - 1);

    }
    public static void quickSort(int[] arr,int left,int right){
        if(left < right){
            int mid = (right + left)/2;
            swap(arr,mid,right);
            int[] partition = partition(arr, left, right);
            quickSort(arr,left,partition[0] - 1);
            quickSort(arr,partition[1] + 1,right);
        }
    }

    public static int[] partition(int[] arr,int left,int right){
        int less = left - 1;
        int more = right;
        int factor = arr[right];
        while (left < more){
            if(arr[left] > factor){
                // 交换
                swap(arr,left,--more);
            }else if(arr[left] < factor){
                swap(arr,++less,left++);
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
}
