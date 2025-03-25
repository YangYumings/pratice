package cn.edu.tsinghua.leetcode.twoPointer;

import cn.edu.tsinghua.leetcode.twoPointer.utils.ListNode;

public class leet28 {
  public static void main(String[] args) {

  }

  public ListNode deleteDuplicates(ListNode head) {
    if(head == null){
      return head;
    }
    ListNode newHead = new ListNode(0, head);
    ListNode fast = newHead;
    while(fast.next != null && fast.next.next != null){
      if(fast.next.val == fast.next.next.val){
        int value = fast.next.val;
        while(fast.next != null && fast.next.val == value){
          fast.next = fast.next.next;
        }
      }else {
        fast = fast.next;
      }
    }
    return newHead.next;
  }

}
