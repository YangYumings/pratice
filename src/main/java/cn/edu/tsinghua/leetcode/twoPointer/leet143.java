package cn.edu.tsinghua.leetcode.twoPointer;

import cn.edu.tsinghua.leetcode.twoPointer.utils.ListNode;

public class leet143 {
  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    reorderList(head);
  }

  public static void reorderList(ListNode head) {
    ListNode mid = middleNode(head);
    ListNode l1 = head;
    ListNode l2 = mid.next;
    l2 = reverseList(mid.next);
    mid.next = null;
    mergeTwoLists(l1, l2);
  }

  public static ListNode reverseList(ListNode head) {
    ListNode pre = null;
    ListNode cur = head;
    while(cur != null){
      ListNode next = cur.next;
      cur.next = pre;
      pre = cur;
      cur = next;
    }
    return pre;
  }

  public static ListNode middleNode(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while(fast != null && fast.next != null){
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  public static void mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode temp1 = l1;
    ListNode temp2 = l2;
    while(l1 != null && l2 != null){
      temp1 = l1.next;
      temp2 = l2.next;

      l1.next = l2;
      l2.next = temp1;

      l1 = temp1;
      l2 = temp2;
    }
  }
}
