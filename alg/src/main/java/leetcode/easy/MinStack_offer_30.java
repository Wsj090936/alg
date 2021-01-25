package leetcode.easy;

import java.util.Stack;

/**
 * TODO
 *
 * @Author jiahao
 * @Date 2021/1/24 16:31
 */
public class MinStack_offer_30 {
    /** initialize your data structure here. */
    Stack<Integer> stack;
    Stack<Integer> minStack;
    public MinStack_offer_30() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if(minStack.isEmpty()){
            minStack.push(x);
        }else {
            Integer peek = minStack.peek();
            if(x < peek){
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

    public int min() {
        return minStack.peek();
    }
}
