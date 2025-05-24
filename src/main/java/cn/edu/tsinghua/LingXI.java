package cn.edu.tsinghua;

import java.io.ByteArrayOutputStream;
import java.util.Arrays;
import java.util.Comparator;

public class LingXI {

    public static void main(String[] args) {
        int[][] a = {{1, 5}, {10, 4}, {4, 3}, {2, 3}, {6, 7}};
//        int res = numOfWeakRoles(a);
//        System.out.println(res);

        int res = uniquePaths(3, 7);
        System.out.println(res);
    }

    // 3.Dp 到达某个格子 (i, j) 的路径数 = 到达它上方 (i-1, j) 和左侧 (i, j-1) 的路径数之和。
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++)
            dp[i][1] = 1;
        for (int j = 1; j <= n; j++)
            dp[1][j] = 1;
        for (int i = 2; i <= m; i++)
            for (int j = 2; j <= n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        return dp[m][n];
    }

    // 2. 比较器
    public static int numOfWeakRoles(int[][] properties) {
        int count = 0;
        for (int k = 0; k < properties.length; k++) {
            for (int i = k + 1; i < properties.length; i++) {
                // 问题：把所有判断取反，然后和现在的是或关系
                if (properties[k][0] < properties[i][0] && properties[k][1] < properties[i][1]) {
                    count++;
                }
            }
        }
        return count;
    }

    // 按攻击力降序，若攻击力相同则按防御力升序
    public static int WeekRoles(int[][] properties) {
        Arrays.sort(properties, (a, b) -> {
            if (a[0] != b[0]) {
                return b[0] - a[0];
            } else {
                return a[1] - b[1];
            }
        });

        int maxDefense = 0;
        int weakCount = 0;

        for (int[] p : properties) {
            if (p[1] < maxDefense) {
                weakCount++;
            } else {
                maxDefense = p[1];
            }
        }
        return weakCount;
    }


    // 1. 交换链表值
    public ListNode exchange(ListNode head, int k) {
        // write code here
        // 遍历一次
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }

        if (1 > k || k > len) {
            return head;
        }

        int k2 = len - k + 1;
        int k1 = k;

        int i = 1;
        cur = head;
        ListNode t1 = null;
        ListNode t2 = null;
        while (cur != null) {
            if (i == k1) {
                t1 = cur;
            }
            if (i == k2) {
                t2 = cur;
            }
            i++;
            cur = cur.next;
        }
        int temp = t1.val;
        t1.val = t2.val;
        t2.val = temp;
        return head;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

}
