package cn.edu.tsinghua.meeting;

import java.util.Stack;

public class Queue {
  static Stack<Integer> stackPush = new Stack<>();
  static Stack<Integer> stackPop = new Stack<>();

  public static void push(Integer item){
    stackPush.push(item);
  }

  public static Integer pop(){
    // 没数值将栈Push中的数据全部弹出到栈Pop中
    if(stackPop.isEmpty()){
      while(!stackPush.isEmpty()){
        stackPop.push(stackPush.pop());
      }
    }
    return stackPop.pop();
  }



}
