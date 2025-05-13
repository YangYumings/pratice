package cn.edu.tsinghua.leetcode.hot;

public class leet160 {

    /**
     * 相交链表
     * 给你两个单链表的头节点 headA 和 headB ，
     * 请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
     * <p>
     * 思路： 两个链表到tail后，分别指向对方的首节点
     *
     * @param args
     */
    public static void main(String[] args) {
        ListNode res = getIntersectionNode(null, null);
        System.out.println(res);
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA;
        ListNode B = headB;
        while (A != B) {
            A = A == null ? headB : A.next;
            B = B == null ? headA : B.next;
        }
        return A;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


}
