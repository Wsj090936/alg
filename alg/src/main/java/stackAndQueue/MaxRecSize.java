package stackAndQueue;

import javax.swing.plaf.metal.MetalTheme;
import java.util.Map;
import java.util.Stack;

/**
 * 给出一个 N * M 大小的矩阵，内容为0或者1
 * 要求，在时间复杂度为O(N * M) 的情况下，找出这个矩阵中，全是1的矩阵的最大面积
 *  解答需要参考单调栈结构 getNearLess
 * @Author jiahao
 * @Date 2020/4/21 23:23
 */
public class MaxRecSize {

    public static void main(String[] args) {
        int[][] arr = {{1,0,1,1},{1,1,1,1},{1,1,1,0}};
        System.out.println(maxRecSize(arr));
    }

    private static int maxRecSize(int[][] arr){
        if(arr == null || arr.length == 0){
            return 0;
        }
        int n = arr.length;
        int m = arr[0].length;
        int[] height = new int[m];// 表示每一行，每个位置网上数，1的数量
        int maxArea = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                height[j] = arr[i][j] == 0 ? 0 : height[j] + 1;
            }
            maxArea = Math.max(getCurMaxRrea(height),maxArea);
        }
        return maxArea;
    }
    // 得到每一行中，最大的面积
    private static int getCurMaxRrea(int[] height){
        if(null == height || height.length == 0){
            return 0;
        }
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < height.length; i++){
            while (!stack.isEmpty() && height[i] <= height[stack.peek()]){
                // 弹出
                int j = stack.pop();
                // 弹出之后计算K的值
                int k = stack.isEmpty() ? -1 : stack.peek();
                int curArea = (i - k -1) * height[j];
                maxArea = Math.max(maxArea,curArea);
            }
            stack.push(i);
        }
        // 清空栈
        while (!stack.isEmpty()){
            int j = stack.pop();
            int k = stack.isEmpty() ? -1 : stack.peek();
            int curArea = (height.length - k -1) * height[j];// 上一个循环完了说明当前的位置在最后一个 + 1
            maxArea = Math.max(maxArea,curArea);
        }
        return maxArea;
    }
}
