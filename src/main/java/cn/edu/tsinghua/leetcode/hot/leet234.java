package cn.edu.tsinghua.leetcode.hot;

public class leet234 {
    /**
     * 回文链表
     * <p>
     * 想法：
     * 1.用数组存值 + 双指针
     * 2.递归
     * 3.快慢指针  将链表的后半部分反转
     */
    public static void main(String[] args) {

    }

    static ListNode temp;

    public boolean isPalindrome(ListNode head) {
        // temp 记录正序遍历的值
        temp = head;
        return check(head);
    }

    // check 用递归逆向遍历
    public boolean check(ListNode head) {
        // 当 head 是最后一个元素，返回 true
        if (head == null) {
            return true;
        }
        // 最后一个元素
        boolean res = check(head.next) && (temp.val == head.val);
        // 正序向后遍历
        temp = temp.next;
        // 当头尾相等时，继续递归；否则没必要递归，就返回 false
        return res;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}


