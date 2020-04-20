package stackAndQueue;

import java.util.Stack;

/**
 * 用一个栈，实现另一个栈的排序
 *
 * @Author jiahao
 * @Date 2020/4/4 22:47
 */
public class StackSortStack {
    private static void sortStack(Stack<Integer> mainStack){
        if(mainStack.isEmpty()){
            return;
        }
        Integer cur = null;
        Stack<Integer> tempStack = new Stack<>();
        while (!mainStack.isEmpty()){
            cur = mainStack.pop();
            if(tempStack.isEmpty() || tempStack.peek() >= cur){
                tempStack.push(cur);
                continue;
            }

            // 如果下一个元素比临时栈的栈顶大，就将临时栈的元素循环倒回mainStack，直到临时栈的元素大于或等于cur
            while (tempStack.isEmpty() || cur > tempStack.peek()){
                mainStack.push(tempStack.pop());
            }
            tempStack.push(cur);
        }
        System.out.println("");

    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(3);
        stack.push(0);
        stack.push(2);
        stack.push(7);
        sortStack(stack);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
