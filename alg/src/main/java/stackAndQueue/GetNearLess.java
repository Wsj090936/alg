package stackAndQueue;

import java.util.Arrays;
import java.util.Stack;

/**
 * 题目：
 *      给出一个无序数组(重复或者不重复)，要求返回每一个位置对应的左边最近比其最小的位置与右边最近比其最小的位置
 *  要求：时间复杂度为O(N)
 *
 * @Author jiahao
 * @Date 2020/4/20 21:34
 */
public class GetNearLess {

    private static int[][] getNearLessNoRepeat(int[] arr){
        Stack<Integer> tempStack = new Stack<>();
        if(null == arr || arr.length == 0){
            return new int[0][0];
        }
        int[][] res = new int[arr.length][2];
        for (int i = 0; i < arr.length;i++){
            // 一直弹出，直到栈顶元素小于当前元素
            while (!tempStack.isEmpty() && arr[i] < arr[tempStack.peek()]){
                Integer popIndex = tempStack.pop();
                res[popIndex][1] = i;// 右边的等于当前
                int leftLessIndex = tempStack.isEmpty() ? -1 : tempStack.peek();
                res[popIndex][0] = leftLessIndex;
            }
            // 此时栈顶元素肯定小于当前元素
            tempStack.push(i);
        }
        // 清理栈中剩下的
        while (!tempStack.isEmpty()){
            Integer popIndex = tempStack.pop();
            res[popIndex][1] = -1;// 右边已经没有比他小的元素了
            int leftLessIndex = tempStack.isEmpty() ? -1 : tempStack.peek();
            res[popIndex][0] = leftLessIndex;
        }
        return res;

    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(getNearLessNoRepeat(new int[]{3, 4, 1, 5, 6, 2, 7})));
    }
}
