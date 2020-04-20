package stackAndQueue;

import java.util.Stack;

/**
 * 一个有getMin功能的栈
 *
 * @Author jiahao
 * @Date 2020/3/30 21:58
 */
public class StackCanGetMin {
    private Stack<Integer> stackData = new Stack<>();// 存所有元素
    private Stack<Integer> stackMin = new Stack<>();// 只存最小的元素

    public void push(int num){
        stackData.push(num);
        if(stackMin.isEmpty()){
            stackMin.push(num);
        }else {
            Integer peek = stackMin.peek();
            if(peek >= num){
                stackMin.push(num);
            }
        }
    }
    public int pop(){
        Integer data = stackData.pop();
        Integer peek = stackMin.peek();
        if(data.equals(peek)){
            this.stackMin.pop();
        }
        return data;
    }
    public int getMin(){
        return stackMin.peek();
    }

    public static void main(String[] args) {
        /**
         * -2
         * -2
         * -1
         * 4
         * -1
         * -1
         * 1
         * 2
         * 1
         */
        StackCanGetMin stackCanGetMin = new StackCanGetMin();
        stackCanGetMin.push(1);
        stackCanGetMin.push(2);
        stackCanGetMin.push(-1);
        stackCanGetMin.push(4);
        stackCanGetMin.push(-2);
        System.out.println(stackCanGetMin.getMin());
        System.out.println(stackCanGetMin.pop());
        System.out.println(stackCanGetMin.getMin());
        System.out.println(stackCanGetMin.pop());
        System.out.println(stackCanGetMin.getMin());
        System.out.println(stackCanGetMin.pop());
        System.out.println(stackCanGetMin.getMin());
        System.out.println(stackCanGetMin.pop());
        System.out.println(stackCanGetMin.getMin());


    }
}
