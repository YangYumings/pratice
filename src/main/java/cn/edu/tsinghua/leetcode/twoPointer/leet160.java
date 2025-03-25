package cn.edu.tsinghua.leetcode.twoPointer;

import cn.edu.tsinghua.leetcode.twoPointer.utils.ListNode;

public class leet160 {
  public static void main(String[] args) {

  }
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode A = headA;
    ListNode B = headB;
    while(A != B){
      // 由于两个链表没有交点，最终两个指针都会遍历完两个链表的所有节点，最终同时变成 null，循环终止。
      A = A == null ? headB : A.next;
      B = B == null ? headA : B.next;
    }
    return A;
  }

}
