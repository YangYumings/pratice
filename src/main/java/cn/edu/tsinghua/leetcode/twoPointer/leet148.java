package cn.edu.tsinghua.leetcode.twoPointer;

import cn.edu.tsinghua.leetcode.twoPointer.utils.ListNode;

public class leet148 {
  public static void main(String[] args) {

  }

  public ListNode sortList(ListNode head) {
    // 空或者一个元素不用排
    if (head == null || head.next == null) {
      return head;
    }
    ListNode slow = new ListNode(0, head);
    ListNode mid = head;
    ListNode fast = head.next;
    while (fast.next != null) {
      if (fast.val < mid.val) {
        slow.next = fast;
        slow = slow.next;
        fast = fast.next;
        slow.next = mid;
        mid.next = fast;
      } else {

      }
    }
    return head;
  }
}
