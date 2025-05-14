package cn.edu.tsinghua.leetcode.hot;

import java.util.Stack;

public class leet739 {
    /**
     * 739. 每日温度
     * 其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。
     *
     * @param args
     */
    public static void main(String[] args) {

    }

    /**
     * 用栈实现
     * 栈中保存的是索引，从栈顶到栈底是递增的
     *
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        // 正序遍历
        for (int i = 0; i < temperatures.length; i++) {
            // 当栈不为空并且当前温度大于栈顶元素时，出栈，并且计算出栈元素的答案
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int preIndex = stack.pop();
                answer[preIndex] = i - preIndex;
            }
            // 当栈为空 或者当前温度小于栈顶元素时，将当前索引入栈
            if (stack.isEmpty() || temperatures[i] <= temperatures[stack.peek()]) {
                stack.push(i);
            }
        }
        return answer;
    }
}
