package leetcode.easy;

import java.util.Stack;

/**
 * 剑指 Offer 09. 用两个栈实现队列
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 *
 *
 * 示例 1：
 *
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * 示例 2：
 *
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 *
 * @Author jiahao
 * @Date 2021/1/21 20:13
 */
public class CQueue_offer_09 {
    private Stack<Integer> stack;
    private Stack<Integer> stack_1;
    public CQueue_offer_09() {
        stack = new Stack<>();
        stack_1 = new Stack<>();
    }

    public void appendTail(int value) {
        stack.push(value);
    }

    public int deleteHead() {
        if(!stack_1.isEmpty()){
            return stack_1.pop();
        }
        // 全部入栈
        while (!stack.isEmpty()){
            stack_1.push(stack.pop());
        }
        if(stack_1.isEmpty()){
            return -1;
        }
        return stack_1.pop();
    }
}
