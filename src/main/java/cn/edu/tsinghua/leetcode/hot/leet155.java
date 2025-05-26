package cn.edu.tsinghua.leetcode.hot;

import java.util.Deque;
import java.util.LinkedList;

public class leet155 {
    class MinStack {
        Deque<Integer> stack;
        Deque<Integer> minStack;

        public MinStack() {
            stack = new LinkedList<>();
            minStack = new LinkedList<>();
            minStack.push(Integer.MAX_VALUE);
        }

        public void push(int val) {
            stack.push(val);
            minStack.push(Math.min(val, minStack.peek()));
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
}
