package stack;

import java.util.Stack;

/**
 * Min Stack
 * 
 * https://leetcode.com/problems/min-stack/
 * 
 * Design a stack that supports push, pop, top, and retrieving the minimum
 * element in constant time.
 * Implement the MinStack class:
 * - MinStack() initializes the stack object.
 * - void push(int val) pushes the element val onto the stack.
 * - void pop() removes the element on the top of the stack.
 * - int top() gets the top element of the stack.
 * - int getMin() retrieves the minimum element in the stack.
 * - You must implement a solution with O(1) time complexity for each function.
 * 
 */

public class MinStack {

    private final Stack<Integer> operations = new Stack<>();
    private final Stack<Integer> minValueStack = new Stack<>();

    public void push(int val) {
        operations.push(val);

        val = Math.min(val, minValueStack.isEmpty() ? val : minValueStack.peek());
        minValueStack.push(val);
    }

    public void pop() {
        operations.pop();
        minValueStack.pop();
    }

    public int top() {
        return operations.peek();
    }

    public int getMin() {
        return minValueStack.peek();
    }

    //["MinStack","push","push","push","push","getMin","pop","getMin","pop","getMin","pop","getMin"]

    public static void main(String[] args) {
        var minStack = new MinStack();
        minStack.push(2);
        minStack.push(0);
        minStack.push(3);
        minStack.push(0);

        System.out.println(minStack.getMin());//0
        minStack.pop();
        System.out.println(minStack.getMin());//0
        minStack.pop();
        System.out.println(minStack.getMin());//0
        minStack.pop();
        System.out.println(minStack.getMin());//2

    }
}
