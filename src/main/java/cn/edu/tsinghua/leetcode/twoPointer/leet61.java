package cn.edu.tsinghua.leetcode.twoPointer;

import cn.edu.tsinghua.leetcode.twoPointer.utils.ListNode;

public class leet61 {
  public static void main(String[] args) {

  }
  public ListNode rotateRight(ListNode head, int k) {
    // 不必旋转
    if (head == null || head.next == null || k == 0) {
      return head;
    }
    // 找尾指针
    ListNode tail = head;
    int size = 1;
    while (tail.next != null) {
      tail = tail.next;
      size ++;
    }
    // 环形
    tail.next = head;
    // 循环次数
    int step = size - k % size;
    while(step -- > 0){
      head = head.next;
      tail = tail.next;
    }
    tail.next = null;
    return head;
  }

}
