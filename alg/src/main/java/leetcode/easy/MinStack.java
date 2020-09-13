package leetcode.easy;

import java.util.Stack;

/**
 * 可以getMin的栈
 *
 * @Author jiahao
 * @Date 2020/9/13 14:53
 */
class MinStack {
    private Stack<Integer> minStack;
    private Stack<Integer> stack;


    /** initialize your data structure here. */
    public MinStack() {
        minStack = new Stack<>();
        stack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if(minStack.isEmpty()){
            minStack.push(x);
        }else {
            Integer peek = minStack.peek();
            if(x <= peek){
                minStack.push(x);
            }else {
                minStack.push(peek);
            }
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();

    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

