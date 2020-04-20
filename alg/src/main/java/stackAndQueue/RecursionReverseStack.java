package stackAndQueue;

import java.util.Stack;

/**
 * 用递归和栈逆序一个栈
 *
 * @Author jiahao
 * @Date 2020/4/2 22:27
 */
public class RecursionReverseStack {

    private Stack<Integer> stack = new Stack<>();

    /**
     * 得到一个栈的最底层元素
     * @param stack
     * @return
     */
    private static Integer getLastStackNum(Stack<Integer> stack){
        Integer res = stack.pop();
        // 先写返回条件
        if(stack.isEmpty()){
            return res;
        }
        // 递归
        Integer lastStackNum = getLastStackNum(stack);
        // 将之前出来的塞回去
        stack.push(res);
        return lastStackNum;
    }
    private static void reverseStack(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }
        Integer lastStackNum = getLastStackNum(stack);
        reverseStack(stack);
        stack.push(lastStackNum);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        reverseStack(stack);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }


}
