package cn.edu.tsinghua.leetcode.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class leet3 {
    /**
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
     */


    /**
     * DP + hashMap
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        // 列表 dp[i] 代表以字符串 arr[i] 为结尾的最长不重复子串的长度
        // dp[i] < j - i  : dp[i] = dp[i-1] + 1
        // i = -1 : dp[i] = dp[i-1] + 1
        // dp[i] >= j - i : dp[i] = j - i;
        /**
         * 假设状态矩阵中存储的数据都是字符串中当前字符前的最大长度不重复子串subStr，然后再考虑下一个字符；
         * 会记录下一个字符的上一次出现的位置；
         * 若位置在subStr中的位置，则长度为 j - i
         * 若位置不在subStr中，则长度为 dp[i-1] + 1
         */
        HashMap<Character, Integer> dic = new HashMap<>();
        int temp = 0;
        int ans = 0;
        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            int i = dic.getOrDefault(c, -1);
            dic.put(c, j);
            temp = temp < j - i ? temp + 1 : j - i;
            ans = Math.max(ans, temp);
        }
        return ans;
    }

    /**
     * 方法一：滑动窗口 + hashMap
     * <p>
     * hashMap 存储每个字符上一次出现的位置，如果出现重复，更新左指针，并更新 hashMap。-1 表示未出现过
     * 遍历右指针，遇到重复字符时，更新左指针，并更新 hashMap
     *
     * @param s
     * @return
     */

    public static int lengthOfLongestSubstring1(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        // 保存上一次字符出现的位置
        HashMap<Character, Integer> dic = new HashMap<>(32);
        int ans = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            Character c = s.charAt(right);
            int index = dic.getOrDefault(c, -1);
            dic.put(c, right);
            // 更新左边界
            left = Math.max(left, index);
            ans = Math.max(ans, right - left);
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static void main(String[] args) {
        String s1 = "abcabcbb";
        System.out.println(lengthOfLongestSubstring1(s1));

        String s2 = "bbbbbb";
        System.out.println(lengthOfLongestSubstring1(s2));

        String s3 = "pwwkew";
        System.out.println(lengthOfLongestSubstring1(s3));
    }
}
