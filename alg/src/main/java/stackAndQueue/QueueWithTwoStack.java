package stackAndQueue;

import java.util.Stack;

/**
 * 两个栈组成一个队列
 *
 * @Author jiahao
 * @Date 2020/4/2 21:58
 */
public class QueueWithTwoStack {
    private Stack<Integer> stackLeft = new Stack<>();
    private Stack<Integer> stackRight = new Stack<>();

    private void left2Right(){
        if(stackRight.isEmpty()){// 当右边的栈为空，就将左边的栈全部移到右边
            while (!stackLeft.isEmpty()){
                Integer lastNum = stackLeft.pop();
                stackRight.add(lastNum);
            }
        }
    }
    private void add(Integer num){

        stackLeft.push(num);//push完需要同步到右边的栈
        left2Right();
    }
    private Integer poll(){

        if(stackRight.isEmpty() && stackLeft.isEmpty()){
            return null;
        }
        left2Right();
        return stackRight.pop();
    }
    private Integer peek(){
        if(stackRight.isEmpty() && stackLeft.isEmpty()){
            return null;
        }
        left2Right();
        return stackRight.peek();
    }

    public static void main(String[] args) {
        QueueWithTwoStack queueWithTwoStack = new QueueWithTwoStack();
        queueWithTwoStack.add(1);
        queueWithTwoStack.add(2);
        queueWithTwoStack.add(3);
        queueWithTwoStack.add(4);
        System.out.println(queueWithTwoStack.peek());
        System.out.println(queueWithTwoStack.poll());
        System.out.println(queueWithTwoStack.peek());
        System.out.println(queueWithTwoStack.poll());
        System.out.println(queueWithTwoStack.peek());
        System.out.println(queueWithTwoStack.poll());
        System.out.println(queueWithTwoStack.peek());
        System.out.println(queueWithTwoStack.poll());
        System.out.println(queueWithTwoStack.peek());
        System.out.println(queueWithTwoStack.poll());
    }
}
